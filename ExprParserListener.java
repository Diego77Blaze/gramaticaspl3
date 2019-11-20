// Generated from ExprParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#axioma}.
	 * @param ctx the parse tree
	 */
	void enterAxioma(ExprParser.AxiomaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#axioma}.
	 * @param ctx the parse tree
	 */
	void exitAxioma(ExprParser.AxiomaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#include_key}.
	 * @param ctx the parse tree
	 */
	void enterInclude_key(ExprParser.Include_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#include_key}.
	 * @param ctx the parse tree
	 */
	void exitInclude_key(ExprParser.Include_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#identificador_tok}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador_tok(ExprParser.Identificador_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#identificador_tok}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador_tok(ExprParser.Identificador_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#numero_key}.
	 * @param ctx the parse tree
	 */
	void enterNumero_key(ExprParser.Numero_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#numero_key}.
	 * @param ctx the parse tree
	 */
	void exitNumero_key(ExprParser.Numero_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cadena_key}.
	 * @param ctx the parse tree
	 */
	void enterCadena_key(ExprParser.Cadena_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cadena_key}.
	 * @param ctx the parse tree
	 */
	void exitCadena_key(ExprParser.Cadena_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#void_key}.
	 * @param ctx the parse tree
	 */
	void enterVoid_key(ExprParser.Void_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#void_key}.
	 * @param ctx the parse tree
	 */
	void exitVoid_key(ExprParser.Void_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#begin_key}.
	 * @param ctx the parse tree
	 */
	void enterBegin_key(ExprParser.Begin_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#begin_key}.
	 * @param ctx the parse tree
	 */
	void exitBegin_key(ExprParser.Begin_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#end_key}.
	 * @param ctx the parse tree
	 */
	void enterEnd_key(ExprParser.End_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#end_key}.
	 * @param ctx the parse tree
	 */
	void exitEnd_key(ExprParser.End_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#abrir_parentesis_tok}.
	 * @param ctx the parse tree
	 */
	void enterAbrir_parentesis_tok(ExprParser.Abrir_parentesis_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#abrir_parentesis_tok}.
	 * @param ctx the parse tree
	 */
	void exitAbrir_parentesis_tok(ExprParser.Abrir_parentesis_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cerrar_parentesis_tok}.
	 * @param ctx the parse tree
	 */
	void enterCerrar_parentesis_tok(ExprParser.Cerrar_parentesis_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cerrar_parentesis_tok}.
	 * @param ctx the parse tree
	 */
	void exitCerrar_parentesis_tok(ExprParser.Cerrar_parentesis_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#coma_tok}.
	 * @param ctx the parse tree
	 */
	void enterComa_tok(ExprParser.Coma_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#coma_tok}.
	 * @param ctx the parse tree
	 */
	void exitComa_tok(ExprParser.Coma_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#dospuntos_tok}.
	 * @param ctx the parse tree
	 */
	void enterDospuntos_tok(ExprParser.Dospuntos_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#dospuntos_tok}.
	 * @param ctx the parse tree
	 */
	void exitDospuntos_tok(ExprParser.Dospuntos_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcion_key}.
	 * @param ctx the parse tree
	 */
	void enterFuncion_key(ExprParser.Funcion_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcion_key}.
	 * @param ctx the parse tree
	 */
	void exitFuncion_key(ExprParser.Funcion_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#int_tok}.
	 * @param ctx the parse tree
	 */
	void enterInt_tok(ExprParser.Int_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#int_tok}.
	 * @param ctx the parse tree
	 */
	void exitInt_tok(ExprParser.Int_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#string_tok}.
	 * @param ctx the parse tree
	 */
	void enterString_tok(ExprParser.String_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#string_tok}.
	 * @param ctx the parse tree
	 */
	void exitString_tok(ExprParser.String_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#while_key}.
	 * @param ctx the parse tree
	 */
	void enterWhile_key(ExprParser.While_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#while_key}.
	 * @param ctx the parse tree
	 */
	void exitWhile_key(ExprParser.While_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#igualdeasignacion_tok}.
	 * @param ctx the parse tree
	 */
	void enterIgualdeasignacion_tok(ExprParser.Igualdeasignacion_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#igualdeasignacion_tok}.
	 * @param ctx the parse tree
	 */
	void exitIgualdeasignacion_tok(ExprParser.Igualdeasignacion_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#devolver_key}.
	 * @param ctx the parse tree
	 */
	void enterDevolver_key(ExprParser.Devolver_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#devolver_key}.
	 * @param ctx the parse tree
	 */
	void exitDevolver_key(ExprParser.Devolver_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#mult_tok}.
	 * @param ctx the parse tree
	 */
	void enterMult_tok(ExprParser.Mult_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#mult_tok}.
	 * @param ctx the parse tree
	 */
	void exitMult_tok(ExprParser.Mult_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#div_tok}.
	 * @param ctx the parse tree
	 */
	void enterDiv_tok(ExprParser.Div_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#div_tok}.
	 * @param ctx the parse tree
	 */
	void exitDiv_tok(ExprParser.Div_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#sum_tok}.
	 * @param ctx the parse tree
	 */
	void enterSum_tok(ExprParser.Sum_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#sum_tok}.
	 * @param ctx the parse tree
	 */
	void exitSum_tok(ExprParser.Sum_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#res_tok}.
	 * @param ctx the parse tree
	 */
	void enterRes_tok(ExprParser.Res_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#res_tok}.
	 * @param ctx the parse tree
	 */
	void exitRes_tok(ExprParser.Res_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#mayor_tok}.
	 * @param ctx the parse tree
	 */
	void enterMayor_tok(ExprParser.Mayor_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#mayor_tok}.
	 * @param ctx the parse tree
	 */
	void exitMayor_tok(ExprParser.Mayor_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#menor_tok}.
	 * @param ctx the parse tree
	 */
	void enterMenor_tok(ExprParser.Menor_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#menor_tok}.
	 * @param ctx the parse tree
	 */
	void exitMenor_tok(ExprParser.Menor_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#iguales_tok}.
	 * @param ctx the parse tree
	 */
	void enterIguales_tok(ExprParser.Iguales_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#iguales_tok}.
	 * @param ctx the parse tree
	 */
	void exitIguales_tok(ExprParser.Iguales_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#distinto_tok}.
	 * @param ctx the parse tree
	 */
	void enterDistinto_tok(ExprParser.Distinto_tokContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#distinto_tok}.
	 * @param ctx the parse tree
	 */
	void exitDistinto_tok(ExprParser.Distinto_tokContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switch_key}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_key(ExprParser.Switch_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switch_key}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_key(ExprParser.Switch_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#end_switch_key}.
	 * @param ctx the parse tree
	 */
	void enterEnd_switch_key(ExprParser.End_switch_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#end_switch_key}.
	 * @param ctx the parse tree
	 */
	void exitEnd_switch_key(ExprParser.End_switch_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#case_key}.
	 * @param ctx the parse tree
	 */
	void enterCase_key(ExprParser.Case_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#case_key}.
	 * @param ctx the parse tree
	 */
	void exitCase_key(ExprParser.Case_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#break_key}.
	 * @param ctx the parse tree
	 */
	void enterBreak_key(ExprParser.Break_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#break_key}.
	 * @param ctx the parse tree
	 */
	void exitBreak_key(ExprParser.Break_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#default_key}.
	 * @param ctx the parse tree
	 */
	void enterDefault_key(ExprParser.Default_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#default_key}.
	 * @param ctx the parse tree
	 */
	void exitDefault_key(ExprParser.Default_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#if_key}.
	 * @param ctx the parse tree
	 */
	void enterIf_key(ExprParser.If_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#if_key}.
	 * @param ctx the parse tree
	 */
	void exitIf_key(ExprParser.If_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#then_key}.
	 * @param ctx the parse tree
	 */
	void enterThen_key(ExprParser.Then_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#then_key}.
	 * @param ctx the parse tree
	 */
	void exitThen_key(ExprParser.Then_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#else_key}.
	 * @param ctx the parse tree
	 */
	void enterElse_key(ExprParser.Else_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#else_key}.
	 * @param ctx the parse tree
	 */
	void exitElse_key(ExprParser.Else_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#endif_key}.
	 * @param ctx the parse tree
	 */
	void enterEndif_key(ExprParser.Endif_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#endif_key}.
	 * @param ctx the parse tree
	 */
	void exitEndif_key(ExprParser.Endif_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#finaldelinea_key}.
	 * @param ctx the parse tree
	 */
	void enterFinaldelinea_key(ExprParser.Finaldelinea_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#finaldelinea_key}.
	 * @param ctx the parse tree
	 */
	void exitFinaldelinea_key(ExprParser.Finaldelinea_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#valordevuelto}.
	 * @param ctx the parse tree
	 */
	void enterValordevuelto(ExprParser.ValordevueltoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#valordevuelto}.
	 * @param ctx the parse tree
	 */
	void exitValordevuelto(ExprParser.ValordevueltoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(ExprParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(ExprParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(ExprParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(ExprParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 */
	void enterCuerpofuncion(ExprParser.CuerpofuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 */
	void exitCuerpofuncion(ExprParser.CuerpofuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#devolver}.
	 * @param ctx the parse tree
	 */
	void enterDevolver(ExprParser.DevolverContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#devolver}.
	 * @param ctx the parse tree
	 */
	void exitDevolver(ExprParser.DevolverContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#llamadafuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadafuncion(ExprParser.LlamadafuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#llamadafuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadafuncion(ExprParser.LlamadafuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cuerpoif}.
	 * @param ctx the parse tree
	 */
	void enterCuerpoif(ExprParser.CuerpoifContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cuerpoif}.
	 * @param ctx the parse tree
	 */
	void exitCuerpoif(ExprParser.CuerpoifContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cuerpobuclewhile}.
	 * @param ctx the parse tree
	 */
	void enterCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cuerpobuclewhile}.
	 * @param ctx the parse tree
	 */
	void exitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#forma_case}.
	 * @param ctx the parse tree
	 */
	void enterForma_case(ExprParser.Forma_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#forma_case}.
	 * @param ctx the parse tree
	 */
	void exitForma_case(ExprParser.Forma_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cuerposwitch}.
	 * @param ctx the parse tree
	 */
	void enterCuerposwitch(ExprParser.CuerposwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cuerposwitch}.
	 * @param ctx the parse tree
	 */
	void exitCuerposwitch(ExprParser.CuerposwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#codigo}.
	 * @param ctx the parse tree
	 */
	void enterCodigo(ExprParser.CodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#codigo}.
	 * @param ctx the parse tree
	 */
	void exitCodigo(ExprParser.CodigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(ExprParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(ExprParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(ExprParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(ExprParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comentario}.
	 * @param ctx the parse tree
	 */
	void enterComentario(ExprParser.ComentarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comentario}.
	 * @param ctx the parse tree
	 */
	void exitComentario(ExprParser.ComentarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#booleano}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(ExprParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#booleano}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(ExprParser.BooleanoContext ctx);
}