package generator

import antlr.generated.LL1GrammarParser
import java.io.PrintWriter

internal class LexerVisitor(output: PrintWriter) : SkippingVisitor(output) {

    val uniqueTerminals = hashSetOf<String>()

    val textToToken = hashMapOf<String, String>()

    override fun visitRuleset(ctx: LL1GrammarParser.RulesetContext?) {
        output.println("" +
                "\n" +
                "import java.io.File\n" +
                "import java.io.IOException\n" +
                "\n"
        )
        output.println("" +
                "class TokenWithText(val token: Token, val text: String) {\n" +
                "   override fun equals(other: Any?) = other is TokenWithText && other.token == token && (other.token != Token.LITERAL || other.text == text)\n" +
                "}\n"
        )
        output.println("enum class Token {")
        output.println("    IDENTIFIER,")
        output.println("    EOF,")
        output.println("    LITERAL,")
        visitChildren(ctx)
        output.println("}\n\n")

        output.println(
            "" +
                    "fun applyLexer(fileName: String): List<TokenWithText> {\n" +
                    "    val text = File(fileName).readText()\n" +
                    "    val tokenList = mutableListOf<TokenWithText>()\n" +
                    "    var i = 0\n" +
                    "    while (i < text.length) {\n" +
                    "        if (text[i] == ' ') {\n" +
                    "            i++\n" +
                    "        } else if (text[i].isLetter()) {\n" +
                    "           var pos = i + 1\n" +
                    "           while (pos < text.length && (text[pos].isLetter() || text[pos].isDigit())) pos++\n" +
                    "           val identifier = text.substring(i, pos)\n" +
                    "           if (false) {}\n" +
                    /*       */ textToToken
                                    .map { (text, token) ->
                                        "           else if (identifier == $text) {tokenList.add(TokenWithText(Token.$token, identifier)) }\n"
                                    }
                                    .joinToString("") +
                    "           else {\n" +
                    "               tokenList.add(TokenWithText(Token.IDENTIFIER, identifier))\n" +
                    "           }\n" +
                    "           i = pos\n" +
                    "        }"
        )
        textToToken.forEach { text, token ->
            output.println(
                "" +
                        "        else if (text.substring(i).startsWith($text)) {\n" +
                        "            tokenList.add(TokenWithText(Token.$token, $text))\n" +
                        "            i += $text.length\n" +
                        "        }"
            )
        }
        output.println(
            "" +
                    "   }\n" +
                    "   tokenList.add(TokenWithText(Token.EOF, \"^\"))\n" +
                    "   return tokenList\n" +
                    "}\n\n"
        )

    }

    override fun visitTerminalRule(ctx: LL1GrammarParser.TerminalRuleContext?) {
        val terminal = ctx!!.terminal()!!.text
        if (terminal in uniqueTerminals) {
            throw Exception("Redefinition of lexer rule $terminal")
        }
        uniqueTerminals.add(terminal)
        output.println("    $terminal,")
        ctx.terminalOptionList()!!.terminalOption().forEach { option ->
            val text = option.text
            textToToken[text] = terminal
        }
    }

    override fun visitLiteral(ctx: LL1GrammarParser.LiteralContext?) {
        textToToken[ctx!!.text] = "LITERAL"
    }

}