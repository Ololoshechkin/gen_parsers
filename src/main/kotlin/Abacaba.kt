
import java.io.File
import java.io.IOException


class TokenWithText(val token: Token, val text: String) {
    override fun equals(other: Any?) = other is TokenWithText && other.token == token && (other.token != Token.LITERAL || other.text == text)
}

enum class Token {
    IDENTIFIER,
    EOF,
    EPS,
    LITERAL,
    NUMBER,
    POW_OP,
    MUL_OP,
    SUM_OP,
}


fun applyLexer(fileName: String): List<TokenWithText> {
    val text = File(fileName).readText()
    val tokenList = mutableListOf<TokenWithText>()
    var i = 0
    while (i < text.length) {
        if (text[i].isWhitespace()) {
            i++
        } else if (text[i].isLetter()) {
            var pos = i + 1
            while (pos < text.length && (text[pos].isLetter() || text[pos].isDigit())) pos++
            val identifier = text.substring(i, pos)
            if (false) {}
            else if (identifier == "7") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "6") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "5") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "4") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "3") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "2") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "1") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "0") {tokenList.add(TokenWithText(Token.NUMBER, identifier)) }
            else if (identifier == "-") {tokenList.add(TokenWithText(Token.SUM_OP, identifier)) }
            else if (identifier == "+") {tokenList.add(TokenWithText(Token.SUM_OP, identifier)) }
            else if (identifier == "*") {tokenList.add(TokenWithText(Token.MUL_OP, identifier)) }
            else if (identifier == ")") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
            else if (identifier == "(") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
            else if (identifier == "pow") {tokenList.add(TokenWithText(Token.POW_OP, identifier)) }
            else {
                tokenList.add(TokenWithText(Token.IDENTIFIER, identifier))
            }
            i = pos
        }
        else if (text.substring(i).startsWith("7")) {
            tokenList.add(TokenWithText(Token.NUMBER, "7"))
            i += "7".length
        }
        else if (text.substring(i).startsWith("6")) {
            tokenList.add(TokenWithText(Token.NUMBER, "6"))
            i += "6".length
        }
        else if (text.substring(i).startsWith("5")) {
            tokenList.add(TokenWithText(Token.NUMBER, "5"))
            i += "5".length
        }
        else if (text.substring(i).startsWith("4")) {
            tokenList.add(TokenWithText(Token.NUMBER, "4"))
            i += "4".length
        }
        else if (text.substring(i).startsWith("3")) {
            tokenList.add(TokenWithText(Token.NUMBER, "3"))
            i += "3".length
        }
        else if (text.substring(i).startsWith("2")) {
            tokenList.add(TokenWithText(Token.NUMBER, "2"))
            i += "2".length
        }
        else if (text.substring(i).startsWith("1")) {
            tokenList.add(TokenWithText(Token.NUMBER, "1"))
            i += "1".length
        }
        else if (text.substring(i).startsWith("0")) {
            tokenList.add(TokenWithText(Token.NUMBER, "0"))
            i += "0".length
        }
        else if (text.substring(i).startsWith("-")) {
            tokenList.add(TokenWithText(Token.SUM_OP, "-"))
            i += "-".length
        }
        else if (text.substring(i).startsWith("+")) {
            tokenList.add(TokenWithText(Token.SUM_OP, "+"))
            i += "+".length
        }
        else if (text.substring(i).startsWith("*")) {
            tokenList.add(TokenWithText(Token.MUL_OP, "*"))
            i += "*".length
        }
        else if (text.substring(i).startsWith(")")) {
            tokenList.add(TokenWithText(Token.LITERAL, ")"))
            i += ")".length
        }
        else if (text.substring(i).startsWith("(")) {
            tokenList.add(TokenWithText(Token.LITERAL, "("))
            i += "(".length
        }
        else if (text.substring(i).startsWith("pow")) {
            tokenList.add(TokenWithText(Token.POW_OP, "pow"))
            i += "pow".length
        }
        else throw Exception("unexpected symbol: ${text[i]}")
    }
    tokenList.add(TokenWithText(Token.EOF, "^"))
    return tokenList
}


abstract class AnyNode(var parent: AnyNode? = null) {
    abstract val text: String
    abstract val childCount: Int
    abstract fun getChild(i: Int): AnyNode
    @Throws(IOException::class)
    private fun treeView(outstrBuilder: StringBuilder, colPositions: ArrayList<Int>, depth: Int, popLast: Boolean) {
        var j = 0
        for (i in 0 until depth) {
            if (j < colPositions.size && colPositions[j] == i) {
                outstrBuilder.append(if (j == colPositions.size - 1 && popLast) '+' else '|')
                j++
            } else if (i == depth - 1) {
                outstrBuilder.append('>')
            } else if (j == colPositions.size) {
                outstrBuilder.append('-')
            } else {
                outstrBuilder.append(' ')
            }
        }
        outstrBuilder.append(toString())
        outstrBuilder.append("  " + getAttributes())
        outstrBuilder.append('\n')
        if (popLast) {
            colPositions.removeAt(colPositions.size - 1)
        }
        colPositions.add(depth)
        for (i in 0 until childCount) {
            getChild(i).treeView(
                    outstrBuilder,
                    colPositions,
                    depth + toString().length / 2,
                    i == childCount - 1
            )
        }
        if (childCount == 0) {
            colPositions.removeAt(colPositions.size - 1)
        }
    }

    fun getAttributes() = when {
        this is TerminalNode -> ""
        else -> this::class.java.methods
                .filter {
                    it.name.startsWith("get") && !it.name.startsWith("getChild") && it.name !in listOf(
                            "getText",
                            "getParent",
                            "getClass",
                            "getAttributes"
                    )
                }
                .sortedBy { it.name }
                .joinToString(separator = ", ") {
                    "${it.name.removePrefix("get")} = ${it.invoke(this)}"
                }
    }

    override fun toString(): String {
        var str = this.javaClass.simpleName
        if (this is TerminalNode) {
            str += "[\"$text\"]"
        }
        return str
    }

    @Throws(IOException::class)
    fun treeView(): String {
        val outstrBuilder = StringBuilder()
        treeView(outstrBuilder, ArrayList(), 0, false)
        return outstrBuilder.toString()
    }
}

class TerminalNode(parent: AnyNode?, override val text: String) : AnyNode(parent) {

    override val childCount: Int
        get() = 0

    override fun getChild(i: Int): AnyNode {
        throw UnsupportedOperationException()
    }
}

open class NonTerminalNode(parent: AnyNode?) : AnyNode(parent) {

    var children: List<AnyNode> = listOf()

    override val childCount: Int
        get() = children.size

    override fun getChild(i: Int) = children[i]

    override val text: String by lazy {
        children.map { it.text }.joinToString("")
    }
}


class expr_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var result: Int?  = null
        private set


    fun setChildren(p : pow_Node) {
        children = listOf(p)
        this.result = p.result!!
    }

}


class pow_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var result: Int?  = null
        private set


    fun setChildren(m : mul_Node) {
        children = listOf(m)
        this.result = m.result!!
    }


    fun setChildren(a : mul_Node, arg1 : TerminalNode, n : pow_Node) {
        children = listOf(a, arg1, n)
        this.result = Math.pow(a.result!!.toDouble(), n.result!!.toDouble()).toInt()
    }

}


class mul_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var result: Int?  = null
        private set


    fun setChildren(s : sum_Node) {
        children = listOf(s)
        this.result = s.result!!
    }


    fun setChildren(m : mul_Node, arg1 : TerminalNode, s : sum_Node) {
        children = listOf(m, arg1, s)
        this.result = m.result!! * s.result!!
    }

}


class sum_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var result: Int?  = null
        private set


    fun setChildren(v : value_Node) {
        children = listOf(v)
        this.result = v.result!!
    }


    fun setChildren(v : value_Node, op : TerminalNode, s : sum_Node) {
        children = listOf(v, op, s)

        this.result = if (op.text == "+")
            v.result!! + s.result!!
        else
            v.result!! - s.result!!

    }

}


class value_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var result: Int?  = null
        private set


    fun setChildren(arg0 : TerminalNode, e : expr_Node, arg2 : TerminalNode) {
        children = listOf(arg0, e, arg2)
        this.result = e.result!!
    }


    fun setChildren(n : TerminalNode) {
        children = listOf(n)
        this.result = n.text.toInt()
    }


    fun setChildren(arg0 : TerminalNode, v : value_Node) {
        children = listOf(arg0, v)
        this.result = - v.result!!
    }

}


class Parser(fileName: String) {
    private val tokens = applyLexer(fileName).also { println(it.map { it.token }) }
    private var pos = 0

    private fun curToken() = tokens[pos]
    private fun nextToken() {
        pos++
    }
    private fun consumeToken(parent: AnyNode?, token: Token) : TerminalNode {
        val curText = curToken().text
        if (curToken().token != token) {
            throw Exception("Expected \"$token\" instead of \"${curText}\"")
        }
        nextToken()
        return TerminalNode(parent, curText)
    }
    private fun consumeLiteral(parent: AnyNode?, literal: String) : TerminalNode {
        if (curToken().token != Token.LITERAL || curToken().text != literal) {
            throw Exception("Expected \"$literal\" instead of \"${curToken().text}\"")
        }
        nextToken()
        return TerminalNode(parent, literal)
    }


    private fun parse_expr(parent: AnyNode?): expr_Node {
        val expr = expr_Node(parent)
        when (curToken()) {
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val _x0 = parse_pow(expr)
                expr.setChildren(_x0)
            }
            else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
        }
        return expr
    }

    private fun parse_pow(parent: AnyNode?): pow_Node {
        val pow = pow_Node(parent)
        when (curToken()) {
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val m = parse_mul(pow)
                pow.setChildren(m)
            }
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val a = parse_mul(pow)
                val _x1 = consumeToken(pow, Token.POW_OP)
                val n = parse_pow(pow)
                pow.setChildren(a, _x1, n)
            }
            else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
        }
        return pow
    }

    private fun parse_mul(parent: AnyNode?): mul_Node {
        val mul = mul_Node(parent)
        when (curToken()) {
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val s = parse_sum(mul)
                mul.setChildren(s)
            }
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val m = parse_mul(mul)
                val _x1 = consumeToken(mul, Token.MUL_OP)
                val s = parse_sum(mul)
                mul.setChildren(m, _x1, s)
            }
            else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
        }
        return mul
    }

    private fun parse_sum(parent: AnyNode?): sum_Node {
        val sum = sum_Node(parent)
        when (curToken()) {
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val v = parse_value(sum)
                sum.setChildren(v)
            }
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-"), TokenWithText(Token.LITERAL, "("), TokenWithText(Token.NUMBER, "")) -> {
                val v = parse_value(sum)
                val op = consumeToken(sum, Token.SUM_OP)
                val s = parse_sum(sum)
                sum.setChildren(v, op, s)
            }
            else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
        }
        return sum
    }

    private fun parse_value(parent: AnyNode?): value_Node {
        val value = value_Node(parent)
        when (curToken()) {
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "(")) -> {
                val _x0 = consumeLiteral(value, "(")
                val e = parse_expr(value)
                val _x2 = consumeLiteral(value, ")")
                value.setChildren(_x0, e, _x2)
            }
            in listOf<TokenWithText>(TokenWithText(Token.NUMBER, "")) -> {
                val n = consumeToken(value, Token.NUMBER)
                value.setChildren(n)
            }
            in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "-")) -> {
                val _x0 = consumeLiteral(value, "-")
                val v = parse_value(value)
                value.setChildren(_x0, v)
            }
            else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
        }
        return value
    }

    fun parse() = parse_expr(null)

}

fun main(args: Array<String>) {
    val node = Parser("input.txt").parse()
    println(node.treeView())
}

