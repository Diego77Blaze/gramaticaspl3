parser grammar ExprParser;

options{tokenVocab=ExprLexer;language=Java;}
axioma: (/*NEWLINE*/(include|cuerpofuncion|declaracion)*);




tipo: numero_key
                |cadena_key
                |void_key
                ;



include: include_key identificador_tok finaldelinea_key;

cabecerafuncion:funcion_key identificador_tok abrir_parentesis_tok (tipo (identificador_tok(coma_tok (tipo (identificador_tok)))*))? cerrar_parentesis_tok dospuntos_tok tipo;

cuerpofuncion: cabecerafuncion
    begin_key
    (codigo|cuerpofuncion*)
    end_key
    ;

devolver: devolver_key abrir_parentesis_tok expr cerrar_parentesis_tok finaldelinea_key;
llamadafuncion: identificador_tok abrir_parentesis_tok ((expr(coma_tok expr)*)?) cerrar_parentesis_tok finaldelinea_key?;
cuerpoif:if_key abrir_parentesis_tok expr cerrar_parentesis_tok then_key
        (codigo)
        (else_key (codigo))?
        endif_key;


cuerpobuclewhile: while_key abrir_parentesis_tok (expr) cerrar_parentesis_tok
            //(asignacion|cuerpobuclewhile|llamadafuncion|declaracion|cuerpoif)+
            (sentencia_unica
            |(begin_key*
            codigo
            end_key*))
            ;


bucle_for: cabecera_for
           (codigo|(begin_key+ codigo end_key+))
           enddo_key
           ;

cabecera_for: for_key identificador_tok from_key expr to_key expr (step_key expr)? do_key;




expr : expr (mult_tok|div_tok) expr #multDiv
    |   expr (sum_tok|res_tok) expr #sumRest
    |   expr (menor_tok|mayor_tok|iguales_tok|distinto_tok|and_tok|or_tok) expr #exprBooleana
    |   not_tok expr #exprNegacion
    |   int_tok #terminalInt
    |   abrir_parentesis_tok expr cerrar_parentesis_tok #exprEntreParentesis
    |   identificador_tok #exprId
    |   booleano #terminalBool
    |   string_tok #terminalString
    |   llamadafuncion #exprLlamadaFuncion
    |   expr_array #exprArray
    //TODO expresiones array?
    ;

expr_array: identificador_tok abrir_bracket_tok expr cerrar_bracket_tok finaldelinea_key;
codigo:sentencia_unica*;
sentencia_unica: (begin_key (asignacion|cuerpobuclewhile|llamadafuncion|declaracion|cuerpoif|devolver|bucle_for|declaracion_array|asignacion_array)? end_key)|(asignacion|cuerpobuclewhile|llamadafuncion|declaracion|cuerpoif|devolver|bucle_for|declaracion_array|asignacion_array);
declaracion:tipo identificador_tok (igualdeasignacion_tok expr)?(coma_tok identificador_tok (igualdeasignacion_tok expr)?)*finaldelinea_key;
declaracion_array: tipo identificador_tok abrir_bracket_tok expr cerrar_bracket_tok
                   ((igualdeasignacion_tok abrir_parentesis_tok expr (coma_tok expr)* cerrar_parentesis_tok finaldelinea_key)|finaldelinea_key);
asignacion: identificador_tok igualdeasignacion_tok expr finaldelinea_key;
asignacion_array: identificador_tok abrir_bracket_tok expr cerrar_bracket_tok igualdeasignacion_tok expr finaldelinea_key;
booleano:TRUE|FALSE;



for_key: FOR;
from_key: FROM;
to_key: TO;
do_key: DO;
enddo_key: ENDDO;
step_key: STEP;
include_key:INCLUDE;
identificador_tok:IDENTIFICADOR;
numero_key:NUMERO;
cadena_key:CADENA;
void_key:VOID;
begin_key:BEGIN;
end_key:END;
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
not_tok: NOT;
mayor_tok:MAYOR;
menor_tok:MENOR;
iguales_tok:IGUALES;
distinto_tok:DISTINTO;
and_tok: AND;
or_tok: OR;

//switch_key:SWITCH;
//end_switch_key:END_SWITCH;
//case_key:CASE;
//break_key:BREAK;
//default_key:DEFAULT;

if_key:IF;
then_key:THEN;
else_key:ELSE;
endif_key:ENDIF;


abrir_bracket_tok:AB;
cerrar_bracket_tok:CB;
abrir_parentesis_tok:AP;
cerrar_parentesis_tok:CP;
finaldelinea_key:PUNTOYCOMA;
