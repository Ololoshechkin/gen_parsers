package generator

import antlr.generated.LL1GrammarParser
import java.io.PrintWriter

internal class ParserGenVisitor(output: PrintWriter) : SkippingVisitor(output) {

    val EPS = ""

    val first = hashMapOf<String, HashSet<String>>()

    fun first(ctx: LL1GrammarParser.SequenceContext): HashSet<String> = when {

        ctx.sequenceItem().size == 1 -> hashSetOf(ctx.sequenceItem().first().text)
        else -> {
            val firstAlpha = first(ctx.sequenceItem().)
            firstAlpha
        }

    }

    fun buildFirst(ctx: LL1GrammarParser.RulesetContext?) {
        ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }.forEach {
            first[it.nonTerminal().text] = hashSetOf()
        }
        var changed = true
        while (changed) {
            changed = false
            ctx!!.ruleStatement()!!.mapNotNull { it.nonTerminalRule() }.forEach {
                val A = it.nonTerminal().text
                it.nonTerminalOptionList()!!.nonTerminalOption()!!.forEach {
                    val firstAlpha = first(it.sequence()!!)
                }
            }
        }
    }

    override fun visitRuleset(ctx: LL1GrammarParser.RulesetContext?) {

    }
}