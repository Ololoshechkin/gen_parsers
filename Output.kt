
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
    INT,
    STRING,
    BOOL,
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
           else if (identifier == "Int") {tokenList.add(TokenWithText(Token.INT, identifier)) }
           else if (identifier == ",") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "String") {tokenList.add(TokenWithText(Token.STRING, identifier)) }
           else if (identifier == "fun") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == ":") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == ")") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "var") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "(") {tokenList.add(TokenWithText(Token.LITERAL, identifier)) }
           else if (identifier == "Boolean") {tokenList.add(TokenWithText(Token.BOOL, identifier)) }
           else {
               tokenList.add(TokenWithText(Token.IDENTIFIER, identifier))
           }
           i = pos
        }
        else if (text.substring(i).startsWith("Int")) {
            tokenList.add(TokenWithText(Token.INT, "Int"))
            i += "Int".length
        }
        else if (text.substring(i).startsWith(",")) {
            tokenList.add(TokenWithText(Token.LITERAL, ","))
            i += ",".length
        }
        else if (text.substring(i).startsWith("String")) {
            tokenList.add(TokenWithText(Token.STRING, "String"))
            i += "String".length
        }
        else if (text.substring(i).startsWith("fun")) {
            tokenList.add(TokenWithText(Token.LITERAL, "fun"))
            i += "fun".length
        }
        else if (text.substring(i).startsWith(":")) {
            tokenList.add(TokenWithText(Token.LITERAL, ":"))
            i += ":".length
        }
        else if (text.substring(i).startsWith(")")) {
            tokenList.add(TokenWithText(Token.LITERAL, ")"))
            i += ")".length
        }
        else if (text.substring(i).startsWith("var")) {
            tokenList.add(TokenWithText(Token.LITERAL, "var"))
            i += "var".length
        }
        else if (text.substring(i).startsWith("(")) {
            tokenList.add(TokenWithText(Token.LITERAL, "("))
            i += "(".length
        }
        else if (text.substring(i).startsWith("Boolean")) {
            tokenList.add(TokenWithText(Token.BOOL, "Boolean"))
            i += "Boolean".length
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


class translationUnit_Node(parent: AnyNode?, val prevDeclarations:String="") : NonTerminalNode(parent) {

    var funCount: Int? =0
        private set

    var varCount: Int? =0
        private set


   fun setChildren(decl : declaration_Node, tu : translationUnit_Node) {
       children = listOf(decl, tu)
      
                  this.funCount = tu.funCount!! + decl.funCount!!;
                  this.varCount = tu.varCount!! + decl.varCount!!;
              
   }


   fun setChildren(arg0 : TerminalNode) {
       children = listOf(arg0)

   }

}


class declaration_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var funCount: Int? =0
        private set

    var varCount: Int? =0
        private set

    var name: String?  = null
        private set


   fun setChildren(fn : funDecl_Node) {
       children = listOf(fn)
       this.funCount = 1; this.name = fn.name!!
   }


   fun setChildren(vr : varDecl_Node) {
       children = listOf(vr)
       this.varCount = 1;  this.name = vr.name!! 
   }

}


class funDecl_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var name: String?  = null
        private set


   fun setChildren(arg0 : TerminalNode, id : TerminalNode, arg2 : TerminalNode, arg3 : argList_Node, arg4 : TerminalNode, arg5 : typeSuffix_Node) {
       children = listOf(arg0, id, arg2, arg3, arg4, arg5)
       this.name = id.text 
   }

}


class argList_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode) {
       children = listOf(arg0)

   }


   fun setChildren(arg0 : arg_Node, arg1 : argListSuffix_Node) {
       children = listOf(arg0, arg1)

   }

}


class argListSuffix_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode) {
       children = listOf(arg0)

   }


   fun setChildren(arg0 : TerminalNode, arg1 : argList_Node) {
       children = listOf(arg0, arg1)

   }

}


class arg_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode, arg1 : typeSuffix_Node) {
       children = listOf(arg0, arg1)

   }

}


class typeSuffix_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode, arg1 : type_Node) {
       children = listOf(arg0, arg1)

   }

}


class type_Node(parent: AnyNode?) : NonTerminalNode(parent) {


   fun setChildren(arg0 : TerminalNode) {
       children = listOf(arg0)

   }

}


class varDecl_Node(parent: AnyNode?) : NonTerminalNode(parent) {

    var name: String?  = null
        private set


   fun setChildren(arg0 : TerminalNode, id : TerminalNode, arg2 : typeSuffix_Node) {
       children = listOf(arg0, id, arg2)
       this.name = id.text 
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


   private fun parse_translationUnit(parent: AnyNode?, prevDeclarations:String=""): translationUnit_Node {
       val translationUnit = translationUnit_Node(parent, prevDeclarations)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "var"), TokenWithText(Token.LITERAL, "fun")) -> {
               val decl = parse_declaration(translationUnit)
               val tu = parse_translationUnit(translationUnit, prevDeclarations=decl.name+", "+prevDeclarations)
                translationUnit.setChildren(decl, tu)
            }
           in listOf<TokenWithText>(TokenWithText(Token.EOF, "")) -> {
               val _x0 = consumeToken(translationUnit, Token.EOF)
                translationUnit.setChildren(_x0)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return translationUnit
    }

   private fun parse_declaration(parent: AnyNode?): declaration_Node {
       val declaration = declaration_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "fun")) -> {
               val fn = parse_funDecl(declaration)
                declaration.setChildren(fn)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "var")) -> {
               val vr = parse_varDecl(declaration)
                declaration.setChildren(vr)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return declaration
    }

   private fun parse_funDecl(parent: AnyNode?): funDecl_Node {
       val funDecl = funDecl_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "fun")) -> {
               val _x0 = consumeLiteral(funDecl, "fun")
               val id = consumeToken(funDecl, Token.IDENTIFIER)
               val _x2 = consumeLiteral(funDecl, "(")
               val _x3 = parse_argList(funDecl)
               val _x4 = consumeLiteral(funDecl, ")")
               val _x5 = parse_typeSuffix(funDecl)
                funDecl.setChildren(_x0, id, _x2, _x3, _x4, _x5)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return funDecl
    }

   private fun parse_argList(parent: AnyNode?): argList_Node {
       val argList = argList_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>() -> {
               val _x0 = consumeToken(argList, Token.EPS)
                argList.setChildren(_x0)
            }
           in listOf<TokenWithText>(TokenWithText(Token.IDENTIFIER, "")) -> {
               val _x0 = parse_arg(argList)
               val _x1 = parse_argListSuffix(argList)
                argList.setChildren(_x0, _x1)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, ")")) -> {
               argList.setChildren(TerminalNode(argList, ""))
           }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return argList
    }

   private fun parse_argListSuffix(parent: AnyNode?): argListSuffix_Node {
       val argListSuffix = argListSuffix_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>() -> {
               val _x0 = consumeToken(argListSuffix, Token.EPS)
                argListSuffix.setChildren(_x0)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, ",")) -> {
               val _x0 = consumeLiteral(argListSuffix, ",")
               val _x1 = parse_argList(argListSuffix)
                argListSuffix.setChildren(_x0, _x1)
            }
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, ")")) -> {
               argListSuffix.setChildren(TerminalNode(argListSuffix, ""))
           }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return argListSuffix
    }

   private fun parse_arg(parent: AnyNode?): arg_Node {
       val arg = arg_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.IDENTIFIER, "")) -> {
               val _x0 = consumeToken(arg, Token.IDENTIFIER)
               val _x1 = parse_typeSuffix(arg)
                arg.setChildren(_x0, _x1)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return arg
    }

   private fun parse_typeSuffix(parent: AnyNode?): typeSuffix_Node {
       val typeSuffix = typeSuffix_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, ":")) -> {
               val _x0 = consumeLiteral(typeSuffix, ":")
               val _x1 = parse_type(typeSuffix)
                typeSuffix.setChildren(_x0, _x1)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return typeSuffix
    }

   private fun parse_type(parent: AnyNode?): type_Node {
       val type = type_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.INT, "")) -> {
               val _x0 = consumeToken(type, Token.INT)
                type.setChildren(_x0)
            }
           in listOf<TokenWithText>(TokenWithText(Token.STRING, "")) -> {
               val _x0 = consumeToken(type, Token.STRING)
                type.setChildren(_x0)
            }
           in listOf<TokenWithText>(TokenWithText(Token.BOOL, "")) -> {
               val _x0 = consumeToken(type, Token.BOOL)
                type.setChildren(_x0)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return type
    }

   private fun parse_varDecl(parent: AnyNode?): varDecl_Node {
       val varDecl = varDecl_Node(parent)
       when (curToken()) {
           in listOf<TokenWithText>(TokenWithText(Token.LITERAL, "var")) -> {
               val _x0 = consumeLiteral(varDecl, "var")
               val id = consumeToken(varDecl, Token.IDENTIFIER)
               val _x2 = parse_typeSuffix(varDecl)
                varDecl.setChildren(_x0, id, _x2)
            }
           else -> throw Exception("unexpected token : ${curToken().token} (\"${curToken().text}\")")
       }
       return varDecl
    }

   fun parse() = parse_translationUnit(null)

}

fun main(args: Array<String>) {
    val node = Parser("input.txt").parse()
    println(node.treeView())
}

