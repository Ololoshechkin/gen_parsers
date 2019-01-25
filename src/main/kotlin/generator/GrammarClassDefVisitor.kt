package generator

import antlr.generated.LL1GrammarParser
import java.io.PrintWriter

internal class GrammarClassDefVisitor(output: PrintWriter) : SkippingVisitor(output) {

    private val uniqueNodes = hashSetOf<String>()

    private var curNode: String = "!!!"

    private val usedArguments = hashSetOf<String>()

    override fun visitRuleset(ctx: LL1GrammarParser.RulesetContext?) {
        output.println(
            "" +
                    "abstract class AnyNode(var parent: AnyNode? = null) {\n" +
                    "    abstract val text: String\n" +
                    "    abstract val childCount: Int\n" +
                    "    abstract fun getChild(i: Int): AnyNode\n" +
                    "    @Throws(IOException::class)\n" +
                    "    private fun treeView(outstrBuilder: StringBuilder, colPositions: ArrayList<Int>, depth: Int, popLast: Boolean) {\n" +
                    "        var j = 0\n" +
                    "        for (i in 0 until depth) {\n" +
                    "            if (j < colPositions.size && colPositions[j] == i) {\n" +
                    "                outstrBuilder.append(if (j == colPositions.size - 1 && popLast) '+' else '|')\n" +
                    "                j++\n" +
                    "            } else if (i == depth - 1) {\n" +
                    "                outstrBuilder.append('>')\n" +
                    "            } else if (j == colPositions.size) {\n" +
                    "                outstrBuilder.append('-')\n" +
                    "            } else {\n" +
                    "                outstrBuilder.append(' ')\n" +
                    "            }\n" +
                    "        }\n" +
                    "        outstrBuilder.append(toString())\n" +
                    "        outstrBuilder.append(\"  \" + getAttributes())\n" +
                    "        outstrBuilder.append('\\n')\n" +
                    "        if (popLast) {\n" +
                    "            colPositions.removeAt(colPositions.size - 1)\n" +
                    "        }\n" +
                    "        colPositions.add(depth)\n" +
                    "        for (i in 0 until childCount) {\n" +
                    "            getChild(i).treeView(\n" +
                    "                outstrBuilder,\n" +
                    "                colPositions,\n" +
                    "                depth + toString().length / 2,\n" +
                    "                i == childCount - 1\n" +
                    "            )\n" +
                    "        }\n" +
                    "        if (childCount == 0) {\n" +
                    "            colPositions.removeAt(colPositions.size - 1)\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    fun getAttributes() = when {\n" +
                    "        this is TerminalNode -> \"\"\n" +
                    "        else -> this::class.java.methods\n" +
                    "            .filter {\n" +
                    "                it.name.startsWith(\"get\") && !it.name.startsWith(\"getChild\") && it.name !in listOf(\n" +
                    "                    \"getText\",\n" +
                    "                    \"getParent\",\n" +
                    "                    \"getClass\",\n" +
                    "                    \"getAttributes\"\n" +
                    "                )\n" +
                    "            }\n" +
                    "            .sortedBy { it.name }\n" +
                    "            .joinToString(separator = \", \") {\n" +
                    "                \"\${it.name.removePrefix(\"get\")} = \${it.invoke(this)}\"\n" +
                    "            }\n" +
                    "    }\n" +
                    "\n" +
                    "    override fun toString(): String {\n" +
                    "        var str = this.javaClass.simpleName\n" +
                    "        if (this is TerminalNode) {\n" +
                    "            str += \"[\\\"\$text\\\"]\"\n" +
                    "        }\n" +
                    "        return str\n" +
                    "    }\n" +
                    "\n" +
                    "    @Throws(IOException::class)\n" +
                    "    fun treeView(): String {\n" +
                    "        val outstrBuilder = StringBuilder()\n" +
                    "        treeView(outstrBuilder, ArrayList(), 0, false)\n" +
                    "        return outstrBuilder.toString()\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class TerminalNode(parent: AnyNode?, override val text: String) : AnyNode(parent) {\n" +
                    "\n" +
                    "    override val childCount: Int\n" +
                    "        get() = 0\n" +
                    "\n" +
                    "    override fun getChild(i: Int): AnyNode {\n" +
                    "        throw UnsupportedOperationException()\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "open class NonTerminalNode(parent: AnyNode?) : AnyNode(parent) {\n" +
                    "\n" +
                    "    var children: List<AnyNode> = listOf()\n" +
                    "\n" +
                    "    override val childCount: Int\n" +
                    "        get() = children.size\n" +
                    "\n" +
                    "    override fun getChild(i: Int) = children[i]\n" +
                    "\n" +
                    "    override val text: String by lazy {\n" +
                    "        children.map { it.text }.joinToString(\"\")\n" +
                    "    }\n" +
                    "}\n\n"
        )

        visitChildren(ctx)
    }

    override fun visitRuleStatement(ctx: LL1GrammarParser.RuleStatementContext?) = visitChildren(ctx)

    override fun visitNonTerminalRule(ctx: LL1GrammarParser.NonTerminalRuleContext?) {
        val node = ctx!!.nonTerminal()!!.text
        if (node in uniqueNodes) throw Exception("Redefinition of rule $node")
        uniqueNodes.add(node)
        curNode = node
        usedArguments.clear()

        val simpleAttributes = ctx.simpleAttributes()?.attributeList()?.attribute() ?: listOf()
        val inheritedAttributes = ctx.inheritedAttributes()?.attributeList()?.attribute()

        output.println(
            "class ${node}_Node(parent: AnyNode?${inheritedAttributes
                ?.map { "val ${it.text}" }
                ?.joinToString(separator = ", ", prefix = ", ")
                ?: ""
            }) : NonTerminalNode(parent) {\n"
        )

        simpleAttributes.forEach {
            output.println("" +
                    "    var ${it.varName().text}: ${it.type().text}? ${it.initialValue()?.text ?: " = null"}\n" +
                    "        private set\n"
            )
        }

        visitNonTerminalOptionList(ctx.nonTerminalOptionList())

        output.println("}\n\n")
    }

    override fun visitNonTerminalOption(ctx: LL1GrammarParser.NonTerminalOptionContext?) {
        val arguments = ctx!!.sequence()!!.sequenceItem()!!
            .mapIndexedNotNull { i, it ->
                val argType =
                    if (it.nonTerminal() != null)
                        it.nonTerminal()!!.text + "_Node"
                    else
                        "TerminalNode"
                val argName = it.namedArg()?.varName()?.text ?: "arg$i"
                "$argName : $argType"
            }
            .joinToString(", ")

        if (arguments in usedArguments) return
        usedArguments.add(arguments)

        val argNames = ctx.sequence().sequenceItem()!!
            .mapIndexedNotNull { i, it ->
                it.namedArg()?.varName()?.text ?: "arg$i"
            }
            .joinToString(", ")

        val code = ctx.code()?.text
            ?.removePrefix("{")
            ?.removeSuffix("}")
            ?.split("\n")
            ?.joinToString("\n") { "      $it" }
            ?.replace("$", "this.")
            ?: ""

        output.println(
            "\n" +
                    "   fun setChildren($arguments) {\n" +
                    "       children = listOf($argNames)\n" +
                    /*   */ code + "\n" +
                    "   }\n"
        )
    }
}