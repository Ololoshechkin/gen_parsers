package generator

import antlr.generated.LL1GrammarLexer
import antlr.generated.LL1GrammarParser
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

class Generator(inputFileName: String) {

    private val ruleSet =
        LL1GrammarParser(
            CommonTokenStream(LL1GrammarLexer(ANTLRInputStream(File(inputFileName).inputStream())))
        ).ruleset()!!

    fun generate(outputFileName: String) {
        File(outputFileName).printWriter().use { output ->
            val lexerVisitor = LexerVisitor(output)
            lexerVisitor.visit(ruleSet)
            GrammarClassDefVisitor(output).visit(ruleSet)
            ParserGenVisitor(output, lexerVisitor).visit(ruleSet)
        }
    }

}