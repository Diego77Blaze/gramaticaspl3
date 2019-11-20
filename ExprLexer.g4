lexer grammar ExprLexer;
//keywords
IF:'if';
THEN:'then';
ELSE:'else';
ENDIF:'endif';
AP:'(';
CP:')';
FUNCION:'function';
VOID:'void';
INCLUDE:'include';
BEGIN:'begin';
END:'end';
NUMERO:'numero';
CADENA: 'cadena';
WHILE:'while';
TRUE:'true';
FALSE:'false';
DEVOLVER:'devolver';
SWITCH:'switch';
END_SWITCH:'endswitch';
BREAK:'break';
CASE:'case';
DEFAULT:'default';
IDENTIFICADOR: [a-zA-Z_][a-zA-Z0-9_]*;
OPERACION: 'cos'|'sen'|'tan' ;
NEWLINE :[\r\n]+->skip;
INT :[0-9]+;
FLOTANTE: INT* '.' INT+;  
STRING: '"' (ESC|.)*? '"';



PUNTOYCOMA:';';
MULT:'*';
DIV:'/';
SUM:'+';
RES:'-';
MENOR:'<';
MAYOR:'>';
DISTINTO:'!=';
IGUALES:'==';
IGUALDEASIGNACION:':=';
DOSPUNTOS:':';
COMA: ',';
ESC:'\\'[btnr"\\];
COMENTARIOLINEA: '//' .*? '\n' ->skip;
COMENTARIOBLOQUE: '/*' .*? '*/' ->skip; 

WS: ' '+ ->skip;

