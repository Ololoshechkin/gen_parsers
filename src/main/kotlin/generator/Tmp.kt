
import java.io.File


data class TokenWithText(val token: Token, val text: String)

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
            else if (identifier == "a") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
            else if (identifier == "koko") {tokenList.add(TokenWithText(Token.Term, identifier)) }
            else {
                tokenList.add(TokenWithText(Token.IDENTIFIER, identifier))
            }
            i = pos
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


    fun setChildren(arg0 : someOtherNode_Node) {
        children = listOf(arg0)
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
    private val tokens = applyLexer(fileName)
    private var pos = 0

    private fun curToken() = tokens[pos].text
    private fun nextToken() {
        pos++
    }
    private fun satisfies(cur: String, text: String) : Boolean {
        if (text == "[B@67117f44") {
            return cur.all { it.isLetterOrDigit() || it == '_' } && cur.length != 0 && cur[0].isLetter()
        }
        return cur == text
    }
    private fun consume(parent: AnyNode?, text: String) : TerminalNode {
        if (!satisfies(curToken(), text)) {
            throw Exception("Expected ${text.takeIf { it != "[B@67117f44" }?.let { "\"$it\"" } ?: "IDENTIFIER" } instead of \"${curToken()}\"")
        }
        nextToken()
        return TerminalNode(parent, text)
    }
    private fun consumeAny(parent: AnyNode?, texts: List<String>) : TerminalNode {
        val matchedText = texts.find { satisfies(curToken(), it) } ?: throw Exception("Expected ${ texts.map{ it.takeIf { it != "[B@67117f44" } ?: "IDENTIFIER" } } instead of \"${curToken()}\"")
        nextToken()
        return TerminalNode(parent, matchedText)
    }


    private fun parse_someNode(parent: AnyNode?, z: Int = 0): someNode_Node {
        val someNode = someNode_Node(parent)
        when {
            listOf<String>("[B@67117f44").any { satisfies(curToken(), it) } -> {
                val x0 = consumeAny(someNode, listOf("[B@67117f44"))
                val x1 = parse_someNode(someNode, z=someNode.z+1)
                someNode.setChildren(x0, x1)
            }
            listOf<String>("a", "koko").any { satisfies(curToken(), it) } -> {
                val x0 = parse_someOtherNode(someNode)
                someNode.setChildren(x0)
            }
            else -> throw Exception("unexpected token : ${curToken()}")
        }
        return someNode
    }

    private fun parse_someOtherNode(parent: AnyNode?, z: Int = 0): someOtherNode_Node {
        val someOtherNode = someOtherNode_Node(parent)
        when {
            listOf<String>("a").any { satisfies(curToken(), it) } -> {
                val x0 = consume(someOtherNode, "a")
                someOtherNode.setChildren(x0)
            }
            listOf<String>("a").any { satisfies(curToken(), it) } -> {
                val x0 = consume(someOtherNode, "a")
                val x1 = parse_someOtherNode(someOtherNode)
                someOtherNode.setChildren(x0, x1)
            }
            listOf<String>("koko").any { satisfies(curToken(), it) } -> {
                val x0 = consumeAny(someOtherNode, listOf("koko"))
                someOtherNode.setChildren(x0)
            }
            else -> throw Exception("unexpected token : ${curToken()}")
        }
        return someOtherNode
    }

    fun parse() = parse_someNode(null)

}
