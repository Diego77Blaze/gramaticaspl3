lexer grammar ExprLexer;
//keywords
FOR:'for';
FROM: 'from';
TO: 'to';
DO: 'do';
ENDDO: 'enddo';
STEP: 'step';
IF:'if';
THEN:'then';
ELSE:'else';
ENDIF:'endif';
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
DEFAULT:'default';
IDENTIFICADOR: [a-zA-Z_][a-zA-Z0-9_]*;
OPERACION: 'cos'|'sen'|'tan' ;
NEWLINE :[\r\n]+->skip;
TAB: [\t] -> skip;
INT :'-'?[0-9]+;
FLOTANTE: INT* '.' INT+;
STRING: '"' (ESC|.)*? '"';




MULT:'*';
DIV:'/';
SUM:'+';
RES:'-';
NOT: '!';
MENOR:'<';
MAYOR:'>';
DISTINTO:'!=';
IGUALES:'==';
IGUALDEASIGNACION:':=';
AND: '&&';
OR: '||';



DOSPUNTOS:':';
COMA: ',';
PUNTOYCOMA:';';
AB: '[';
CB: ']';
AP:'(';
CP:')';
ESC:'\\'[btnr"\\];
COMENTARIOLINEA: '//' .*? '\n' ->skip;
COMENTARIOBLOQUE: '/*' .*? '*/' ->skip;

WS: ' '+ ->skip;
