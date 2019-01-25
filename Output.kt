
import java.io.File
import java.io.IOException


class TokenWithText(val token: Token, val text: String) {
   override fun equals(other: Any?) = other is TokenWithText && other.token == token && (other.token != Token.LITERAL || other.text == text)
}

enum class Token {
    IDENTIFIER,
    EOF,
    LITERAL,
    Term,
}


fun applyLexer(fileName: String): List<TokenWithText> {
    val text = File(fileName).readText()
    val tokenList = mutableListOf<TokenWithText>()
    var i = 0
    while (i < text.length) {
        if (text[i] == ' ') {
            i++
        } else if (text[i].isLetter()) {
           var pos = i + 1
           while (pos < text.length && (text[pos].isLetter() || text[pos].isDigit())) pos++
           val identifier = text.substring(i, pos)
           if (false) {}
           else if (identifier == "b") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "a") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "koko") {tokenList.add(TokenWithText(Token.Term, identifier)) }
           else {
               tokenList.add(TokenWithText(Token.IDENTIFIER, identifier))
           }
           i = pos
        }
        else if (text.substring(i).startsWith("b")) {
            tokenList.add(TokenWithText(Token.LITERAL, "b"))
            i += "b".length
        }
        else if (text.substring(i).startsWith("a")) {
            tokenList.add(TokenWithText(Token.LITERAL, "a"))
            i += "a".length
        }
        else if (text.substring(i).startsWith("koko")) {
            tokenList.add(TokenWithText(Token.Term, "koko"))
            i += "koko".length
        }
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


class someNode_Node(parent: AnyNode?, val z:Int=0) : NonTerminalNode(parent) {

    var x: Int? =0
        private set

    var y: String? ="aba"
        private set


   fun setChildren(id : TerminalNode, sn : someNode_Node) {
       children = listOf(id, sn)
       this.x = 1 + sn.x!!; this.y = id.text + " " + sn.y!!; 
   }


   fun setChildren(arg0 : someOtherNode_Node, arg1 : TerminalNode) {
       children = listOf(arg0, arg1)
       x = -1; y = "undefined"; 
   }

}


class someOtherNode_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode) {
       children = listOf(arg0)

   }


   fun setChildren(arg0 : TerminalNode, arg1 : someOtherNode_Node) {
       children = listOf(arg0, arg1)

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


   private fun parse_someNode(parent: AnyNode?, z:Int=0): someNode_Node {
       val someNode = someNode_Node(parent, z)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.IDENTIFIER, "")) -> {
               val x0 = consumeToken(someNode, Token.IDENTIFIER)
               val x1 = parse_someNode(someNode, z=someNode.z+1)
                someNode.setChildren(x0, x1)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "b"), TokenWithText(Token.Term, ""), TokenWithText(Token.LITERAL, "a")) -> {
               val x0 = parse_someOtherNode(someNode)
               val x1 = consumeToken(someNode, Token.EOF)
                someNode.setChildren(x0, x1)
            }
           else -> throw Exception("unexpected token : ${curToken()}")
       }
       return someNode
    }

   private fun parse_someOtherNode(parent: AnyNode?): someOtherNode_Node {
       val someOtherNode = someOtherNode_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "b")) -> {
               val x0 = consumeLiteral(someOtherNode, "b")
                someOtherNode.setChildren(x0)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "a")) -> {
               val x0 = consumeLiteral(someOtherNode, "a")
               val x1 = parse_someOtherNode(someOtherNode)
                someOtherNode.setChildren(x0, x1)
            }
           in listOf<TokenWithText>(TokenWithText(Token.Term, "")) -> {
               val x0 = consumeToken(someOtherNode, Token.Term)
                someOtherNode.setChildren(x0)
            }
           else -> throw Exception("unexpected token : ${curToken()}")
       }
       return someOtherNode
    }

   fun parse() = parse_someNode(null)

}

fun main(args: Array<String>) {
    val node = Parser("input.txt").parse()
    println(node.treeView())
}

