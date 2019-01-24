package generator

import antlr.generated.LL1GrammarParser
import antlr.generated.LL1GrammarVisitor
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode
import java.io.PrintWriter

internal open class SkippingVisitor(protected val output: PrintWriter) : LL1GrammarVisitor<Unit> {

    override fun visitVariable(ctx: LL1GrammarParser.VariableContext?) {
        visitChildren(ctx)
    }

    override fun visitNamedArg(ctx: LL1GrammarParser.NamedArgContext?) {
        visitChildren(ctx)
    }

    override fun visitIdentifier(ctx: LL1GrammarParser.IdentifierContext?) {
        visitChildren(ctx)
    }

    override fun visitInheritedValues(ctx: LL1GrammarParser.InheritedValuesContext?) {
        visitChildren(ctx)
    }

    override fun visitInitializer(ctx: LL1GrammarParser.InitializerContext?) {
        visitChildren(ctx)
    }

    override fun visitVarValue(ctx: LL1GrammarParser.VarValueContext?) {
        visitChildren(ctx)
    }

    override fun visitSimpleAttributes(ctx: LL1GrammarParser.SimpleAttributesContext?) {
        visitChildren(ctx)
    }

    override fun visitInheritedAttributes(ctx: LL1GrammarParser.InheritedAttributesContext?) {
        visitChildren(ctx)
    }

    override fun visitRuleset(ctx: LL1GrammarParser.RulesetContext?) {
        visitChildren(ctx)
    }

    override fun visitRuleStatement(ctx: LL1GrammarParser.RuleStatementContext?) {
        visitChildren(ctx)
    }

    override fun visitNonTerminalRule(ctx: LL1GrammarParser.NonTerminalRuleContext?) {
        visitChildren(ctx)
    }

    override fun visitTerminalRule(ctx: LL1GrammarParser.TerminalRuleContext?) {
        visitChildren(ctx)
    }

    override fun visitAttribute(ctx: LL1GrammarParser.AttributeContext?) {
        visitChildren(ctx)
    }

    override fun visitVarName(ctx: LL1GrammarParser.VarNameContext?) {
        visitChildren(ctx)
    }

    override fun visitType(ctx: LL1GrammarParser.TypeContext?) {
        visitChildren(ctx)
    }

    override fun visitInitialValue(ctx: LL1GrammarParser.InitialValueContext?) {
        visitChildren(ctx)
    }

    override fun visitNonTerminal(ctx: LL1GrammarParser.NonTerminalContext?) {
        visitChildren(ctx)
    }

    override fun visitTerminal(ctx: LL1GrammarParser.TerminalContext?) {
        visitChildren(ctx)
    }

    override fun visitNonTerminalOptionList(ctx: LL1GrammarParser.NonTerminalOptionListContext?) {
        visitChildren(ctx)
    }

    override fun visitNonTerminalOption(ctx: LL1GrammarParser.NonTerminalOptionContext?) {
        visitChildren(ctx)
    }

    override fun visitLiteral(ctx: LL1GrammarParser.LiteralContext?) {
        visitChildren(ctx)
    }

    override fun visitAttributeList(ctx: LL1GrammarParser.AttributeListContext?) {
        visitChildren(ctx)
    }

    override fun visit(p0: ParseTree?) {
        p0?.accept(this)
    }

    override fun visitCode(ctx: LL1GrammarParser.CodeContext?) {
        visitChildren(ctx)
    }

    override fun visitTerminalOptionList(ctx: LL1GrammarParser.TerminalOptionListContext?) {
        visitChildren(ctx)
    }

    override fun visitSequence(ctx: LL1GrammarParser.SequenceContext?) {
        visitChildren(ctx)
    }

    override fun visitSequenceItem(ctx: LL1GrammarParser.SequenceItemContext?) {
        visitChildren(ctx)
    }

    override fun visitTerminalOption(ctx: LL1GrammarParser.TerminalOptionContext?) {
        visitChildren(ctx)
    }

    override fun visitChildren(p0: RuleNode?) {
        (0 until p0!!.childCount).forEach { visit(p0.getChild(it)) }
    }

    override fun visitErrorNode(p0: ErrorNode?) {
        throw Exception(p0!!.text)
    }

    override fun visitTerminal(p0: TerminalNode?) {
        // do nothing
    }

}