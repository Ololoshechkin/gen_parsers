package generator

import antlr.generated.LL1GrammarParser
import java.io.PrintWriter
import java.util.*

internal class ParserGenVisitor(output: PrintWriter) : SkippingVisitor(output) {


    data class Token(val token: String, val literal: String? = null) {
        override fun toString() = "TokenWithText(Token.$token, ${literal ?: "\"\""})"
    }

    val EPS = Token("EPS", "\"\"")
    val EOF = Token("EOF")

    val first = hashMapOf<String, HashSet<Token>>()
    val follow = hashMapOf<String, HashSet<Token>>()

    fun first(sequence: List<LL1GrammarParser.SequenceItemContext>): HashSet<Token> {
        println("   first(${sequence.map { it.getChild(0).text }})")
        if (sequence.isEmpty()) return hashSetOf(EPS)
        val firstElem = sequence.first()
        return when {
            firstElem.literal() != null -> hashSetOf(Token("LITERAL", firstElem.literal().text))
            firstElem.terminal() != null && firstElem.terminal().text == "EPS" -> hashSetOf(EPS)
            firstElem.terminal() != null  -> hashSetOf(Token(firstElem.terminal().text))
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
        println("buildFirst - enter\n")
        val nonTerminalRules = ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }
        nonTerminalRules.forEach {
            first[it.nonTerminal().text] = hashSetOf()
        }
        var changed = true
        while (changed) {
            changed = false
            nonTerminalRules.forEach {
                val A = it.nonTerminal().text
                println("A = $A")
                it.nonTerminalOptionList()!!.nonTerminalOption()!!.forEach {
                    println(" rule: ${it.sequence()!!.sequenceItem().map { it.getChild(0).text }}")
                    val firstAlpha = first(it.sequence()!!.sequenceItem())
                    if (!first[A]!!.containsAll(firstAlpha)) {
                        println("       first[$A] !containsAll $firstAlpha}")
//                        readLine()
                        changed = true
                        first[A]!! += firstAlpha
                    }
                }
            }
        }
        println("buildFirst - exit")
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

        output.println(
            "" +
                    "class Parser(fileName: String) {\n" +
                    "    private val tokens = applyLexer(fileName).also { println(it.map { it.token }) }\n" +
                    "    private var pos = 0\n" +
                    "\n" +
                    "    private fun curToken() = tokens[pos]\n" +
                    "    private fun nextToken() {\n" +
                    "        pos++\n" +
                    "    }\n" +
                    "    private fun consumeToken(parent: AnyNode?, token: Token) : TerminalNode {\n" +
                    "        val curText = curToken().text\n" +
                    "        if (curToken().token != token) {\n" +
                    "            throw Exception(\"Expected \\\"\$token\\\" instead of \\\"\${curText}\\\"\")\n" +
                    "        }\n" +
                    "        nextToken()\n" +
                    "        return TerminalNode(parent, curText)\n" +
                    "    }\n" +
                    "    private fun consumeLiteral(parent: AnyNode?, literal: String) : TerminalNode {\n" +
                    "        if (curToken().token != Token.LITERAL || curToken().text != literal) {\n" +
                    "            throw Exception(\"Expected \\\"\$literal\\\" instead of \\\"\${curToken().text}\\\"\")\n" +
                    "        }\n" +
                    "        nextToken()\n" +
                    "        return TerminalNode(parent, literal)\n" +
                    "    }\n" +
                    "\n"
        )

        visitChildren(ctx)

        output.println(
            "" +
                    "   fun parse() = parse_${ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }.first().nonTerminal().text}(null)\n"
        )

        output.println("}")
        output.println("" +
                "\n" +
                "fun main(args: Array<String>) {\n" +
                "    val node = Parser(\"input.txt\").parse()\n" +
                "    println(node.treeView())\n" +
                "}\n"
        )
    }


    override fun visitNonTerminalRule(ctx: LL1GrammarParser.NonTerminalRuleContext?) {
        val someNode = ctx!!.nonTerminal()!!.text
        val inheritedAttributes = ctx.inheritedAttributes()?.attributeList()?.attribute()
        output.println(
            "" +
                    "   private fun parse_$someNode(parent: AnyNode?${inheritedAttributes?.joinToString(separator = ", ", prefix = ", ") { it.text } ?: ""}): ${someNode}_Node {\n" +
//                    "       println(\"parse_$someNode, \$pos\")\n" +
                    "       val $someNode = ${someNode}_Node(parent${inheritedAttributes?.joinToString(separator = ", ", prefix = ", ") { it.varName().text } ?: ""})\n" +
                    "       when (curToken()) {"
        )

        val alphas = ctx.nonTerminalOptionList()!!.nonTerminalOption()!!

        alphas.forEach { alpha ->
            val sequence = alpha!!.sequence()!!.sequenceItem()!!
            val firstAlpha = first(sequence)
            output.println(
                "           in listOf<TokenWithText>(${(firstAlpha - EPS).joinToString(", ")}) -> {"
            )
            sequence.forEachIndexed { i, X ->
                val varName = X.namedArg()?.varName()?.text ?: "_x$i"
                when {
                    X.literal() != null -> {
                        output.println(
                            "               val $varName = consumeLiteral($someNode, ${X.literal().text})"
                        )
                    }
                    X.terminal() != null -> {
                        output.println(
                            "               val $varName = consumeToken($someNode, Token.${X.terminal().text})"
                        )
                    }
                    else -> { // non-terminal
                        output.println(
                            "               val $varName = parse_${X.nonTerminal().text}($someNode${X.inheritedValues()?.initializer()
                                ?.joinToString(separator = ", ", prefix = ", ") { it.text.replace("$", "$someNode.") }
                                ?: ""
                            })"
                        )
                    }
                }
            }
            output.println("                $someNode.setChildren(${(0 until sequence.size).joinToString(", ") {
                sequence[it].namedArg()?.varName()?.text ?: "_x$it"
            }})")
            output.println("            }")
        }

        if (alphas.any { EPS in first(it!!.sequence()!!.sequenceItem()!!) }) {
            output.println(
                "" +
                        "           in listOf<TokenWithText>(${follow[someNode]!!.joinToString(", ")}) -> {\n" +
                        "               $someNode.setChildren(TerminalNode($someNode, ${EPS.literal}))\n" +
                        "           }"
            )
        }

        output.println(
            "" +
                    "           else -> throw Exception(\"unexpected token : \${curToken().token} (\\\"\${curToken().text}\\\")\")"
        )

        output.println("       }")
        output.println("       return $someNode")
        output.println("    }\n")
    }
}