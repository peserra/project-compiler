grammar LangDef;

prog : 'program' bloco 'endprog';
bloco: (cmd)+;
cmd: cmdRead | cmdWrite | cmdAttr;
cmdRead: 'read' OPEN_PARENTHESIS ID CLOSE_PARENTHESIS SEMI_COLON;
cmdWrite: 'write' OPEN_PARENTHESIS ID  CLOSE_PARENTHESIS SEMI_COLON;
cmdAttr: ID ATTR expr SEMI_COLON;

expr : term (OPERATOR term)*;

term : ID | NUMBER;

OPEN_PARENTHESIS: '(';
CLOSE_PARENTHESIS: ')';
SEMI_COLON: ';';
OPERATOR : '+' | '-' | '*' | '/';
ATTR : '=';
ID: ([a-z]|[A-Z]) ([a-z]|[A-Z]|[0-9])*;
NUMBER: [0-9]+('.' [0-9]+)?; 
WHITE_SPACE: (' ' | '\t' | '\n' | '\r') -> skip;