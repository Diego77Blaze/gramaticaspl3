import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;









public class VisitorPropio extends ExprParserBaseVisitor{

    private Funcion funcionVisitada;
    private TablaDeSimbolos ts;
    private long puntosFuncion;

    public VisitorPropio(TablaDeSimbolos ts1){
        this.ts = ts1;
        puntosFuncion = 0L;

    }


    @Override
    public Long visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx) {
        funcionVisitada = new Funcion();
        puntosFuncion = 0L;
        puntosFuncion += (Long)visit(ctx.cabecerafuncion());

        puntosFuncion += (Long)visit(ctx.codigo());
        funcionVisitada.setPuntosFuncion(puntosFuncion);
        ts.addFuncion(funcionVisitada);
        return puntosFuncion;
    }

    @Override
    public Long visitCabecerafuncion(ExprParser.CabecerafuncionContext ctx) {

        ArrayList<ExprParser.Identificador_tokContext> listaId = new ArrayList<ExprParser.Identificador_tokContext>(ctx.identificador_tok());
        long puntosParam = (long)(listaId.size()-1) * 2;

        String nombreFuncion = ctx.funcion_key().FUNCION().getText() + " ";
        nombreFuncion += listaId.get(0).IDENTIFICADOR().getText();
        nombreFuncion += "(";
        for(int i = 1; i < listaId.size(); i++){

            nombreFuncion  += listaId.get(i).IDENTIFICADOR().getText();

            if (i != listaId.size()-1)
            {
                nombreFuncion += ",";
            }
        }
        nombreFuncion += "):";
        ArrayList<ExprParser.TipoContext> tipos = new ArrayList<>(ctx.tipo());
        nombreFuncion += tipos.get(tipos.size() - 1).getText();

        funcionVisitada.setNombre(nombreFuncion);
        funcionVisitada.addParametro(puntosParam/2);
        funcionVisitada.addLineaEfectiva(1);

        return  puntosParam;
    }

    @Override
    public Long visitCodigo(ExprParser.CodigoContext ctx) {
        long puntosCodigo = 0L;
        if (ctx.sentencia_unica() != null){
            ArrayList<ExprParser.Sentencia_unicaContext> lineas = new ArrayList<ExprParser.Sentencia_unicaContext>(ctx.sentencia_unica());

            for(ExprParser.Sentencia_unicaContext linea: lineas){
                puntosCodigo += (Long)visit(linea);
            }
        }
        return puntosCodigo;
    }

    @Override
    public Long visitSentencia_unica(ExprParser.Sentencia_unicaContext ctx) {
        long puntosSentencia = 0L;
        if (ctx.begin_key() != null){
            if (ctx.getChildCount() == 3){

                puntosSentencia += (Long)visit(ctx.getChild(1));
                funcionVisitada.addLineaEfectiva(1);
            }
        }
        else{
            puntosSentencia += (Long)visitChildren(ctx);
            funcionVisitada.addLineaEfectiva(1);
        }
        return puntosSentencia;
    }
    @Override
    public Long visitDevolver(ExprParser.DevolverContext ctx) {
        return (Long)visit(ctx.expr());
    }
    @Override
    public Long visitDeclaracion(ExprParser.DeclaracionContext ctx) {

        long puntosDeclaracion = 0L;

        ArrayList<ExprParser.Identificador_tokContext> variables = new ArrayList<>(ctx.identificador_tok());

        puntosDeclaracion += variables.size();
        funcionVisitada.addLineaEfectiva(variables.size());
        if (ctx.igualdeasignacion_tok() != null)
        {
            ArrayList<ExprParser.Igualdeasignacion_tokContext> asignaciones = new ArrayList<>(ctx.igualdeasignacion_tok());
            for (ExprParser.Igualdeasignacion_tokContext igual : asignaciones)
            {
                puntosDeclaracion += (Long) visit(igual);
            }
            this.funcionVisitada.addOperadorSimple(asignaciones.size());
            funcionVisitada.addLineaEfectiva(1);
        }

        if (ctx.expr() != null)
        {
            ArrayList<ExprParser.ExprContext> exprAsignadas = new ArrayList<>(ctx.expr());
            for (ExprParser.ExprContext exprAsignada : exprAsignadas)
            {
                puntosDeclaracion += (Long)visit(exprAsignada);
            }
        }

        funcionVisitada.addDeclaraciones(variables.size());
        return puntosDeclaracion;
    }
    @Override
    public Long visitDeclaracion_array(ExprParser.Declaracion_arrayContext ctx) {
        long puntosDeclaracionArray = 1L;
        puntosDeclaracionArray += (Long)visit(ctx.expr(0));

        if (ctx.igualdeasignacion_tok() != null){
            puntosDeclaracionArray += (Long)visit(ctx.igualdeasignacion_tok());
            for (int i = 1; i < ctx.expr().size(); i++){
                puntosDeclaracionArray += (Long) visit(ctx.expr(i));
            }
            funcionVisitada.addLineaEfectiva(1);;
        }
        funcionVisitada.addDeclaraciones(1);
        return puntosDeclaracionArray;
    }

    @Override
    public Long visitAsignacion(ExprParser.AsignacionContext ctx) {

        return (Long)visit(ctx.expr()) + (Long)visit(ctx.igualdeasignacion_tok());
    }
    @Override
    public Long visitAsignacion_array(ExprParser.Asignacion_arrayContext ctx) {
        return (Long) visit(ctx.igualdeasignacion_tok()) + (Long) visit(ctx.expr(0)) + (Long) visit(ctx.expr(1));
    }
    @Override
    public Long visitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx) {
        long puntosBucle = 0L;

        puntosBucle += (Long)visit(ctx.expr());
        if(ctx.codigo() != null)puntosBucle += (long)Math.pow((Long)visit(ctx.codigo()), 2);
        else if (ctx.sentencia_unica() != null) puntosBucle += (long)Math.pow((Long)visit(ctx.sentencia_unica()), 2);
        //puntosBucle = (long) Math.pow(puntosBucle, 2);


        return puntosBucle;
    }
    @Override
    public Long visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx) {
        LlamadaFuncion lf = new LlamadaFuncion();
        long puntosLlamadaF = 2L; //hemos llegado a una llamada a funcion a si que como minimo su puntuacion sera 2
        String nombreFuncionLlamada = ctx.identificador_tok().IDENTIFICADOR().getText();
        int numParametros = 0;
        lf.setNumeroP(numParametros);
        lf.setNombre(nombreFuncionLlamada);
        if(ctx.expr() != null){
            ArrayList<ExprParser.ExprContext> parametrosLlamadaF = new ArrayList<ExprParser.ExprContext>(ctx.expr());
            puntosLlamadaF += parametrosLlamadaF.size(); //al valor minimo de 2 se le sumara 1 por cada parametro que use la funcion
            numParametros = parametrosLlamadaF.size();
            lf.setNumeroP(numParametros);
            for(ExprParser.ExprContext parametro : parametrosLlamadaF){
                puntosLlamadaF += (Long)visit(parametro); //como un argumento puede ser una expr y estas pueden ser elementos puntos funcion tenemos que visitar cada una
            }
            funcionVisitada.addLlamadasFuncion(1);
        }
        funcionVisitada.addFuncionLlamada(lf);

        return puntosLlamadaF;
    }
    @Override
    public Long visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        long puntosIf = 0L;

        puntosIf += (Long)visit(ctx.expr());
        if(ctx.codigo() != null){
            ArrayList<ExprParser.CodigoContext> bloquesCodigo = new ArrayList<ExprParser.CodigoContext>(ctx.codigo());

            for(ExprParser.CodigoContext bloque : bloquesCodigo){
                puntosIf += (long) Math.pow((Long)visit(bloque), 2);
            }
        }
        return puntosIf;
    }
    /*@Override
    public Long visitCuerposwitch(ExprParser.CuerposwitchContext ctx) {
        long puntosSw = 0;


        if(ctx.codigo() != null){
            ArrayList<ExprParser.CodigoContext> bloquesCodigo = new ArrayList<ExprParser.CodigoContext>(ctx.codigo());

            for(ExprParser.CodigoContext bloque: bloquesCodigo){
                puntosSw += Math.pow((Long)visit(bloque), 2);
            }
        }

        return puntosSw;
    }*/

    @Override
    public Long visitMultDiv(ExprParser.MultDivContext ctx) {
        funcionVisitada.addOperadorSimple(1);

        return 1L + ((Long)visit(ctx.expr(0)) + (Long)visit(ctx.expr(1)));
    }

    @Override
    public Long visitSumRest(ExprParser.SumRestContext ctx) {
        funcionVisitada.addOperadorSimple(1);
        return 1L + ((Long)visit(ctx.expr(0)) + (Long)visit(ctx.expr(1)));
    }
    @Override
    public Long visitExprBooleana(ExprParser.ExprBooleanaContext ctx) {
        funcionVisitada.addOperadorSimple(1L);
        return 1L + ((Long)visit(ctx.expr(0)) + (Long)visit(ctx.expr(1)));
    }
    @Override
    public Long visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx) {
        return (Long)visit(ctx.llamadafuncion());
    }
    @Override
    public Long visitExprArray(ExprParser.ExprArrayContext ctx) {
         return (Long) visit(ctx.expr_array());
    }
    @Override
    public Long visitExpr_array(ExprParser.Expr_arrayContext ctx) {
        return (Long) visit(ctx.expr());
    }
    @Override public Long visitTerminalBool(ExprParser.TerminalBoolContext ctx) { return 0L; }
    @Override public Long visitTerminalInt(ExprParser.TerminalIntContext ctx) { return 0L; }
    @Override public Long visitExprId(ExprParser.ExprIdContext ctx) { return 0L; }
    @Override public Long visitTerminalString(ExprParser.TerminalStringContext ctx) { return 0L; }
    @Override public Long visitExprEntreParentesis(ExprParser.ExprEntreParentesisContext ctx) {
        return (Long)visit(ctx.expr());
    }
    @Override
    public Long visitIgualdeasignacion_tok(ExprParser.Igualdeasignacion_tokContext ctx) {
        funcionVisitada.addOperadorSimple(1L);
        return 1L;
    }




    @Override
    public Long visitBucle_for(ExprParser.Bucle_forContext ctx) {
        long puntosFor = 3L;//visitando un bucle for, automaticamente hay una declaracion, una asignacion y un if con un operador.
        funcionVisitada.addDeclaraciones(1L);
        funcionVisitada.addOperadorSimple(2L);//Se añade un operador por el igual de asignacion y otro por el if
        funcionVisitada.addLineaEfectiva(2L); //la declaración de for incluye 3 lineas efectivas, declaracion asignacion e if,
                                              //una esta añadida por llamada a sentencia unica, aqui se añaden las 2 restantes
        if (ctx.codigo() != null){
            puntosFor += (long)Math.pow((Long)visit(ctx.codigo()), 2);
        }
        //puntosFor = (long) Math.pow(puntosFor, 2);
        return puntosFor;
    }
    @Override
    public Long visitExprNegacion(ExprParser.ExprNegacionContext ctx) {
        funcionVisitada.addOperadorSimple(1);
        return 1L + (Long)visit(ctx.expr());
    }


}
