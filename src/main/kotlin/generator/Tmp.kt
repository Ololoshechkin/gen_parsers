import java.io.File


data class TokenWithText(val token: Token, val text: String)

enum class Token {
    _ID_,
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
            if (false) {
            } else {
                tokenList.add(TokenWithText(Token._ID_, identifier))
            }
            i = pos
        }
    }
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


class someNode_Node(parent: AnyNode?, val z: Int = 0) : NonTerminalNode(parent) {

    var x: Int? = 0
        private set

    var y: String? = "aba"
        private set


    fun setChildren(id: TerminalNode) {
        children = listOf(id)
        this.y = id.text;
    }


    fun setChildren(id: TerminalNode, sn: someNode_Node) {
        children = listOf(id, sn)
        this.x = 1 + sn.x!!; this.y = id.text + " " + sn.y!!;
    }


    fun setChildren(arg0: someOtherNode_Node) {
        children = listOf(arg0)
        x = -1; y = "undefined";
    }

}


class someOtherNode_Node(parent: AnyNode?) : NonTerminalNode(parent) {


    fun setChildren(arg0: TerminalNode) {
        children = listOf(arg0)

    }


    fun setChildren(arg0: TerminalNode, arg1: someOtherNode_Node) {
        children = listOf(arg0, arg1)

    }

}


