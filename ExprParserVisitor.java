// Generated from ExprParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#axioma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxioma(ExprParser.AxiomaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(ExprParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(ExprParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cabecerafuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecerafuncion(ExprParser.CabecerafuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#devolver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevolver(ExprParser.DevolverContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#llamadafuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cuerpoif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpoif(ExprParser.CuerpoifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cuerpobuclewhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#bucle_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucle_for(ExprParser.Bucle_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cabecera_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera_for(ExprParser.Cabecera_forContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprEntreParentesis}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntreParentesis(ExprParser.ExprEntreParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminalInt}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalInt(ExprParser.TerminalIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(ExprParser.MultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNegacion}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegacion(ExprParser.ExprNegacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumRest}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumRest(ExprParser.SumRestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminalBool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalBool(ExprParser.TerminalBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprId}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprId(ExprParser.ExprIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLlamadaFuncion}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminalString}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalString(ExprParser.TerminalStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArray}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArray(ExprParser.ExprArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBooleana}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBooleana(ExprParser.ExprBooleanaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_array(ExprParser.Expr_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodigo(ExprParser.CodigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#sentencia_unica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_unica(ExprParser.Sentencia_unicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(ExprParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#declaracion_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_array(ExprParser.Declaracion_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(ExprParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#asignacion_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion_array(ExprParser.Asignacion_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#booleano}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleano(ExprParser.BooleanoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#for_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_key(ExprParser.For_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#from_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_key(ExprParser.From_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#to_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo_key(ExprParser.To_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#do_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_key(ExprParser.Do_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#enddo_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnddo_key(ExprParser.Enddo_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#step_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep_key(ExprParser.Step_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#include_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude_key(ExprParser.Include_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#identificador_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador_tok(ExprParser.Identificador_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#numero_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_key(ExprParser.Numero_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cadena_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCadena_key(ExprParser.Cadena_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#void_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid_key(ExprParser.Void_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#begin_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_key(ExprParser.Begin_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#end_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_key(ExprParser.End_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#coma_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComa_tok(ExprParser.Coma_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#dospuntos_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDospuntos_tok(ExprParser.Dospuntos_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcion_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion_key(ExprParser.Funcion_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#int_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_tok(ExprParser.Int_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#string_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_tok(ExprParser.String_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#while_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_key(ExprParser.While_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#igualdeasignacion_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualdeasignacion_tok(ExprParser.Igualdeasignacion_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#devolver_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevolver_key(ExprParser.Devolver_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mult_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_tok(ExprParser.Mult_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#div_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv_tok(ExprParser.Div_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#sum_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum_tok(ExprParser.Sum_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#res_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRes_tok(ExprParser.Res_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#not_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_tok(ExprParser.Not_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mayor_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayor_tok(ExprParser.Mayor_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#menor_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenor_tok(ExprParser.Menor_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#iguales_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIguales_tok(ExprParser.Iguales_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#distinto_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinto_tok(ExprParser.Distinto_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#and_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_tok(ExprParser.And_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#or_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_tok(ExprParser.Or_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#if_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_key(ExprParser.If_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#then_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen_key(ExprParser.Then_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#else_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_key(ExprParser.Else_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#endif_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndif_key(ExprParser.Endif_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#abrir_bracket_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbrir_bracket_tok(ExprParser.Abrir_bracket_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cerrar_bracket_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCerrar_bracket_tok(ExprParser.Cerrar_bracket_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#abrir_parentesis_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbrir_parentesis_tok(ExprParser.Abrir_parentesis_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cerrar_parentesis_tok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCerrar_parentesis_tok(ExprParser.Cerrar_parentesis_tokContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#finaldelinea_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinaldelinea_key(ExprParser.Finaldelinea_keyContext ctx);
}