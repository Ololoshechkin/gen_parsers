grammar LL1Grammar;

ruleset : ruleStatement* EOF;

ruleStatement: (nonTerminalRule | terminalRule) ';';

nonTerminalRule: simpleAttributes? nonTerminal inheritedAttributes? ARROW nonTerminalOptionList;

terminalRule: terminal ARROW terminalOptionList;

simpleAttributes: '(' attributeList ')';
inheritedAttributes: '(' attributeList ')';

attributeList: attribute (',' attribute)*;

attribute: varName ':' type initialValue?;

varName: identifier;

type: identifier;

initialValue: '=' ('0' | 'null' | STRING);

nonTerminal: NON_TERMINAL;
terminal: TERMINAL;

nonTerminalOptionList: nonTerminalOption (OR nonTerminalOption)*;

nonTerminalOption: sequence code?;

sequence: sequenceItem+;

sequenceItem: (nonTerminal | terminal | literal) namedArg? inheritedValues?;

namedArg: '[' varName ']';

inheritedValues: '(' initializer (',' initializer)* ')';

initializer: varName '=' varValue;

varValue
    : variable (OPERATOR varValue)? // value -> var OP? value?
    | variable '.' varValue // value -> var.value
    | identifier '(' varValue ')' ('.' varValue)? // value -> f(value).value?
    ;

variable: (NUMBER | 'null' | STRING | '$' identifier);

literal: STRING;

code: CODE;

terminalOptionList: terminalOption (OR terminalOption)*;

terminalOption
    : STRING
    | '_id_' // Identifier, hard-coded regex
    | REGEX; // UNSUPPORTED!!!

identifier: TERMINAL | NON_TERMINAL;

OR: '|';
ARROW: ':';
NON_TERMINAL: [a-z]([a-zA-Z0-9_])*;
TERMINAL: [A-Z]([a-zA-Z0-9_])*;
REGEX: 'reg' STRING;
STRING: '"' Schar* '"';
fragment
Schar: ~["\\\r\n] ;
CODE : '{' (~[{}]+ CODE?)* '}';
NUMBER : NONZERODIGIT (DIGIT)*;
fragment
NONZERODIGIT : [1-9];
fragment
DIGIT : [0-9];
OPERATOR: '+' | '-' | '*' | '/';

Whitespace:[ \t\n]+ -> skip;