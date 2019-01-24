// Generated from LL1Grammar.g4 by ANTLR 4.5.3
package antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LL1GrammarParser}.
 */
public interface LL1GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void enterRuleset(LL1GrammarParser.RulesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void exitRuleset(LL1GrammarParser.RulesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#ruleStatement}.
	 * @param ctx the parse tree
	 */
	void enterRuleStatement(LL1GrammarParser.RuleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#ruleStatement}.
	 * @param ctx the parse tree
	 */
	void exitRuleStatement(LL1GrammarParser.RuleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#nonTerminalRule}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalRule(LL1GrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#nonTerminalRule}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalRule(LL1GrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void enterTerminalRule(LL1GrammarParser.TerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void exitTerminalRule(LL1GrammarParser.TerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#simpleAttributes}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAttributes(LL1GrammarParser.SimpleAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#simpleAttributes}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAttributes(LL1GrammarParser.SimpleAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#inheritedAttributes}.
	 * @param ctx the parse tree
	 */
	void enterInheritedAttributes(LL1GrammarParser.InheritedAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#inheritedAttributes}.
	 * @param ctx the parse tree
	 */
	void exitInheritedAttributes(LL1GrammarParser.InheritedAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(LL1GrammarParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(LL1GrammarParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(LL1GrammarParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(LL1GrammarParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(LL1GrammarParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(LL1GrammarParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LL1GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LL1GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(LL1GrammarParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(LL1GrammarParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#nonTerminal}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminal(LL1GrammarParser.NonTerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#nonTerminal}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminal(LL1GrammarParser.NonTerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(LL1GrammarParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(LL1GrammarParser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#nonTerminalOptionList}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalOptionList(LL1GrammarParser.NonTerminalOptionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#nonTerminalOptionList}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalOptionList(LL1GrammarParser.NonTerminalOptionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#nonTerminalOption}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalOption(LL1GrammarParser.NonTerminalOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#nonTerminalOption}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalOption(LL1GrammarParser.NonTerminalOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(LL1GrammarParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(LL1GrammarParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#sequenceItem}.
	 * @param ctx the parse tree
	 */
	void enterSequenceItem(LL1GrammarParser.SequenceItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#sequenceItem}.
	 * @param ctx the parse tree
	 */
	void exitSequenceItem(LL1GrammarParser.SequenceItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#namedArg}.
	 * @param ctx the parse tree
	 */
	void enterNamedArg(LL1GrammarParser.NamedArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#namedArg}.
	 * @param ctx the parse tree
	 */
	void exitNamedArg(LL1GrammarParser.NamedArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#inheritedValues}.
	 * @param ctx the parse tree
	 */
	void enterInheritedValues(LL1GrammarParser.InheritedValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#inheritedValues}.
	 * @param ctx the parse tree
	 */
	void exitInheritedValues(LL1GrammarParser.InheritedValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(LL1GrammarParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(LL1GrammarParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(LL1GrammarParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(LL1GrammarParser.VarValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LL1GrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LL1GrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LL1GrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LL1GrammarParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(LL1GrammarParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(LL1GrammarParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#terminalOptionList}.
	 * @param ctx the parse tree
	 */
	void enterTerminalOptionList(LL1GrammarParser.TerminalOptionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#terminalOptionList}.
	 * @param ctx the parse tree
	 */
	void exitTerminalOptionList(LL1GrammarParser.TerminalOptionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#terminalOption}.
	 * @param ctx the parse tree
	 */
	void enterTerminalOption(LL1GrammarParser.TerminalOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#terminalOption}.
	 * @param ctx the parse tree
	 */
	void exitTerminalOption(LL1GrammarParser.TerminalOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LL1GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LL1GrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LL1GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LL1GrammarParser.IdentifierContext ctx);
}