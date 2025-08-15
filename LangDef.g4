grammar LangDef;

start: expression;
expression   : term (( '+' | '-' ) term)* ;
term   : factor (( '*' | '/' ) factor)* ;
factor : NUMBER  | OP expression CP;

OP : '(';
CP : ')';
NUMBER: [0-9]+('.' [0-9]+)?; 
WHITE_SPACE: (' ' | '\t' | '\n' | '\r') -> skip;