package generator

import antlr.generated.LL1GrammarParser
import java.io.PrintWriter
import java.util.*

internal class ParserGenVisitor(output: PrintWriter, lexerVisitor: LexerVisitor) : SkippingVisitor(output) {

    val tokenToTexts = lexerVisitor.tokenToTexts

    val EPS = "\"\""
    val EOF = "\"^\""
    val IDENTIFIER_MARKER: String by lazy {
        val bytes = ByteArray(10)
        Random().nextBytes(bytes)
        "\"${bytes}\""
    }

    val first = hashMapOf<String, HashSet<String>>()
    val follow = hashMapOf<String, HashSet<String>>()

    init {
        tokenToTexts.put("IDENTIFIER", hashSetOf(IDENTIFIER_MARKER))
        tokenToTexts.put("EOF", hashSetOf(EOF))
    }

    fun first(sequence: List<LL1GrammarParser.SequenceItemContext>): HashSet<String> {
        if (sequence.isEmpty()) return hashSetOf(EPS)
        val firstElem = sequence.first()
        return when {
            firstElem.literal() != null -> hashSetOf(firstElem.literal().text)
            firstElem.terminal() != null -> {
                val terminal = firstElem.terminal().text
                if (terminal != "IDENTIFIER") tokenToTexts[terminal]!!
                else hashSetOf(IDENTIFIER_MARKER)
            }
            else -> {
                val ans = first[firstElem.nonTerminal().text]!!
                if (EPS in ans) {
                    ans -= EPS
                    ans += first(sequence.subList(1, sequence.size))
                }
                return ans
            }

        }
    }

    fun buildFirst(ctx: LL1GrammarParser.RulesetContext?) {
        val nonTerminalRules = ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }
        nonTerminalRules.forEach {
            first[it.nonTerminal().text] = hashSetOf()
        }
        var changed = true
        while (changed) {
            changed = false
            nonTerminalRules.forEach {
                val A = it.nonTerminal().text
                it.nonTerminalOptionList()!!.nonTerminalOption()!!.forEach {
                    val firstAlpha = first(it.sequence()!!.sequenceItem())
                    if (!first[A]!!.containsAll(firstAlpha)) {
                        changed = true
                        first[A]!! += firstAlpha
                    }
                }
            }
        }
    }

    fun buildFollow(ctx: LL1GrammarParser.RulesetContext?) {
        val nonTerminalRules = ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }
        nonTerminalRules.forEach {
            follow[it.nonTerminal().text] = hashSetOf()
        }
        follow[nonTerminalRules[0].nonTerminal().text]!!.add(EOF)
        var changed = true
        while (changed) {
            changed = false
            nonTerminalRules.forEach {
                val A = it.nonTerminal().text
                it.nonTerminalOptionList()!!.nonTerminalOption()!!.forEach {
                    val sequence = it.sequence()!!.sequenceItem()!!
                    if (sequence.size != 1 || sequence.first().literal()?.text != "") {
                        sequence.forEachIndexed { i, b ->
                            val B = b.nonTerminal()?.text
                            if (B != null) {
                                val firstGamma = first(sequence.subList(i + 1, sequence.size))
                                val initSizeB = follow[B]!!.size
                                follow[B]!!.addAll(firstGamma - EPS)
                                if (EPS in firstGamma) {
                                    follow[B]!!.addAll(follow[A]!!)
                                }
                                if (initSizeB != follow[B]!!.size)
                                    changed = true
                            }
                        }
                    }
                }
            }
        }
    }

    override fun visitRuleset(ctx: LL1GrammarParser.RulesetContext?) {
        buildFirst(ctx)
        buildFollow(ctx)

        output.println("" +
                "class Parser(fileName: String) {\n" +
                "    private val tokens = applyLexer(fileName)\n" +
                "    private var pos = 0\n" +
                "\n" +
                "    private fun curToken() = tokens[pos].text\n" +
                "    private fun nextToken() {\n" +
                "        pos++\n" +
                "    }\n" +
                "    private fun satisfies(cur: String, text: String) : Boolean {\n" +
                "        if (text == $IDENTIFIER_MARKER) {\n" +
                "            return cur.all { it.isLetterOrDigit() || it == '_' } && cur.length != 0 && cur[0].isLetter()\n" +
                "        }\n" +
                "        return cur == text\n" +
                "    }\n" +
                "    private fun consume(parent: AnyNode?, text: String) : TerminalNode {\n" +
                "        if (!satisfies(curToken(), text)) {\n" +
                "            throw Exception(\"Expected \${text.takeIf { it != $IDENTIFIER_MARKER }?.let { \"\\\"\$it\\\"\" } ?: \"IDENTIFIER\" } instead of \\\"\${curToken()}\\\"\")\n" +
                "        }\n" +
                "        nextToken()\n" +
                "        return TerminalNode(parent, text)\n" +
                "    }\n" +
                "    private fun consumeAny(parent: AnyNode?, texts: List<String>) : TerminalNode {\n" +
                "        val matchedText = texts.find { satisfies(curToken(), it) } ?: throw Exception(\"Expected \${ texts.map{ it.takeIf { it != $IDENTIFIER_MARKER } ?: \"IDENTIFIER\" } } instead of \\\"\${curToken()}\\\"\")\n" +
                "        nextToken()\n" +
                "        return TerminalNode(parent, matchedText)\n" +
                "    }\n" +
                "\n"
        )

        visitChildren(ctx)

        output.println("" +
                "   fun parse() = parse_${ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }.first().nonTerminal().text}(null)\n"
        )

        output.println("}")
    }


    override fun visitNonTerminalRule(ctx: LL1GrammarParser.NonTerminalRuleContext?) {
        val someNode = ctx!!.nonTerminal()!!.text
        output.println("" +
                "   private fun parse_$someNode(parent: AnyNode?, z: Int = 0): ${someNode}_Node {\n" +
                "       val $someNode = ${someNode}_Node(parent)\n" +
                "       when {"
        )

        val alphas = ctx.nonTerminalOptionList()!!.nonTerminalOption()!!

        alphas.forEach { alpha ->
            val sequence = alpha!!.sequence()!!.sequenceItem()!!
            val firstAlpha = first(sequence)
            output.println(
                    "           listOf<String>(${(firstAlpha - EPS).joinToString(", ")}).any { satisfies(curToken(), it) } -> {"
            )
            sequence.forEachIndexed { i, X ->
                when {
                    X.literal() != null -> {
                        output.println(
                                "               val x$i = consume($someNode, ${X.literal().text})"
                        )
                    }
                    X.terminal() != null -> {
                        output.println(
                                "               val x$i = consumeAny($someNode, listOf(${tokenToTexts[X.terminal().text]!!.joinToString(", ")}))"
                        )
                    }
                    else -> { // non-terminal
                        output.println(
                                "               val x$i = parse_${X.nonTerminal().text}($someNode${X.inheritedValues()?.initializer()
                                        ?.joinToString(separator = ", ", prefix = ", ") { it.text.replace("$", "$someNode.") } ?: ""
                                })"
                        )
                    }
                }
            }
            output.println("                $someNode.setChildren(${(0 until sequence.size).joinToString(", ") { "x$it" }})")
            output.println("            }")
        }

        if (alphas.any { EPS in first(it!!.sequence()!!.sequenceItem()!!) }) {
            output.println("" +
                    "           listOf<String>(${follow[someNode]!!.joinToString(", ")}).any { satisfies(curToken(), it) } -> {\n" +
                    "               $someNode.setChildren(TerminalNode($someNode, $EPS))\n" +
                    "           }"
            )
        }

        output.println("" +
                "           else -> throw Exception(\"unexpected token : \${curToken()}\")"
        )

        output.println("       }")
        output.println("       return $someNode")
        output.println("    }\n")
    }
}