parser grammar ExprParser;

options{tokenVocab=ExprLexer;language=Java;}
axioma: (/*NEWLINE*/(comentario|include|cuerpofuncion|declaracion)*);

include_key:INCLUDE;
identificador_tok:IDENTIFICADOR;
numero_key:NUMERO;
cadena_key:CADENA;
void_key:VOID;
begin_key:BEGIN;
end_key:END;
abrir_parentesis_tok:AP;
cerrar_parentesis_tok:CP;
coma_tok:COMA;
dospuntos_tok:DOSPUNTOS;
funcion_key:FUNCION;
int_tok:INT;
string_tok:STRING;
while_key:WHILE;
igualdeasignacion_tok:IGUALDEASIGNACION;
devolver_key:DEVOLVER;
mult_tok:MULT;
div_tok:DIV;
sum_tok:SUM;
res_tok:RES;
mayor_tok:MAYOR;
menor_tok:MENOR;
iguales_tok:IGUALES;
distinto_tok:DISTINTO;

switch_key:SWITCH;
end_switch_key:END_SWITCH;
case_key:CASE;
break_key:BREAK;
default_key:DEFAULT;

if_key:IF;
then_key:THEN;
else_key:ELSE;
endif_key:ENDIF;

finaldelinea_key:PUNTOYCOMA;


tipo: numero_key  
                |cadena_key  
                |void_key   
                ;



include: include_key identificador_tok finaldelinea_key;

cuerpofuncion: funcion_key identificador_tok abrir_parentesis_tok (tipo (identificador_tok(coma_tok (tipo (identificador_tok)))*))? cerrar_parentesis_tok dospuntos_tok tipo 
    begin_key* 
    ((codigo|cuerpofuncion))*
    end_key*
    ;

devolver: devolver_key abrir_parentesis_tok expr cerrar_parentesis_tok finaldelinea_key;
llamadafuncion: identificador_tok abrir_parentesis_tok ((expr(coma_tok expr)*)?) cerrar_parentesis_tok finaldelinea_key?;
cuerpoif:if_key abrir_parentesis_tok expr cerrar_parentesis_tok then_key
        (codigo)*
        (else_key (codigo)*)?
        endif_key;


cuerpobuclewhile: while_key abrir_parentesis_tok (expr) cerrar_parentesis_tok 
            //(asignacion|cuerpobuclewhile|llamadafuncion|declaracion|cuerpoif)+
            (codigo
            |(begin_key*
            codigo*
            end_key*))
;
forma_case: case_key expr dospuntos_tok;
cuerposwitch: switch_key abrir_parentesis_tok expr cerrar_parentesis_tok
                (forma_case begin_key? codigo* (break_key finaldelinea_key)?)+
                (default_key dospuntos_tok begin_key? codigo* (break_key finaldelinea_key)?)?
                end_switch_key;

expr : expr (mult_tok|div_tok) expr
    |   expr (sum_tok|res_tok) expr
    |   expr (menor_tok|mayor_tok|iguales_tok|distinto_tok) expr
    |   int_tok
    |   abrir_parentesis_tok expr cerrar_parentesis_tok
    |   OPERACION abrir_parentesis_tok (expr(coma_tok expr)*)? cerrar_parentesis_tok
    |   identificador_tok
    |   booleano
    |   string_tok 
    |   llamadafuncion
 
    
    ;
codigo:(asignacion|cuerpobuclewhile|llamadafuncion|declaracion|cuerpoif|cuerposwitch);
declaracion:tipo identificador_tok (igualdeasignacion_tok expr  finaldelinea_key|finaldelinea_key);
asignacion: identificador_tok igualdeasignacion_tok expr finaldelinea_key;
comentario: COMENTARIOBLOQUE|COMENTARIOLINEA;
booleano:TRUE|FALSE;
