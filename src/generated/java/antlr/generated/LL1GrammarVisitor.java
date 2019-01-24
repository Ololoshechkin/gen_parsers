// Generated from LL1Grammar.g4 by ANTLR 4.5.3
package antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LL1GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LL1GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(LL1GrammarParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#ruleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleStatement(LL1GrammarParser.RuleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#nonTerminalRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminalRule(LL1GrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalRule(LL1GrammarParser.TerminalRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#simpleAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAttributes(LL1GrammarParser.SimpleAttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#inheritedAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritedAttributes(LL1GrammarParser.InheritedAttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(LL1GrammarParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(LL1GrammarParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(LL1GrammarParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LL1GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#initialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialValue(LL1GrammarParser.InitialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#nonTerminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminal(LL1GrammarParser.NonTerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminal(LL1GrammarParser.TerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#nonTerminalOptionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminalOptionList(LL1GrammarParser.NonTerminalOptionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#nonTerminalOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminalOption(LL1GrammarParser.NonTerminalOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(LL1GrammarParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#sequenceItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceItem(LL1GrammarParser.SequenceItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#namedArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArg(LL1GrammarParser.NamedArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#inheritedValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritedValues(LL1GrammarParser.InheritedValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(LL1GrammarParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#varValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarValue(LL1GrammarParser.VarValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LL1GrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LL1GrammarParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(LL1GrammarParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#terminalOptionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalOptionList(LL1GrammarParser.TerminalOptionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#terminalOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalOption(LL1GrammarParser.TerminalOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LL1GrammarParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(LL1GrammarParser.IdentifierContext ctx);
}