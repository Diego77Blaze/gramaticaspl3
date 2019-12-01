import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;





public class VisitorPropio extends ExprParserBaseVisitor{

    private Funcion funcionVisitada;
    private TablaDeSimbolos ts;
    private int puntosFuncion;

    public VisitorPropio(TablaDeSimbolos ts){
        this.ts = ts;
        puntosFuncion = 0;

    }


    @Override
    public Integer visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx) {
        funcionVisitada = new Funcion();
        puntosFuncion = 0;
        puntosFuncion += (Integer)visit(ctx.cabecerafuncion());

        puntosFuncion += (Integer)visit(ctx.codigo());
        funcionVisitada.setPuntosFuncion(puntosFuncion);
        ts.addFuncion(funcionVisitada);
        return puntosFuncion;
    }

    @Override
    public Integer visitCabecerafuncion(ExprParser.CabecerafuncionContext ctx) {

        ArrayList<ExprParser.Identificador_tokContext> listaId = new ArrayList<ExprParser.Identificador_tokContext>(ctx.identificador_tok());
        String nombreFuncion = listaId.get(0).IDENTIFICADOR().getText();
        int puntosParam = (listaId.size()-1) * 2;


        funcionVisitada.setNombre(nombreFuncion);
        funcionVisitada.addParametro(puntosParam/2);
        return  puntosParam;
    }

    @Override
    public Integer visitCodigo(ExprParser.CodigoContext ctx) {
        int puntosCodigo = 0;
        if (ctx.sentencia_unica() != null){
            ArrayList<ExprParser.Sentencia_unicaContext> lineas = new ArrayList<ExprParser.Sentencia_unicaContext>(ctx.sentencia_unica());

            for(ExprParser.Sentencia_unicaContext linea: lineas){
                puntosCodigo += (Integer)visit(linea);
            }
        }
        return puntosCodigo;
    }

    @Override
    public Integer visitSentencia_unica(ExprParser.Sentencia_unicaContext ctx) {
        int puntosSentencia = 0;
        puntosSentencia += (Integer)visitChildren(ctx);
        return puntosSentencia;
    }
    @Override
    public Integer visitDevolver(ExprParser.DevolverContext ctx) {
        return (Integer)visit(ctx.expr());
    }
    @Override
    public Integer visitDeclaracion(ExprParser.DeclaracionContext ctx) {
        if (ctx.expr() != null){
            funcionVisitada.addDeclaraciones(1);
            return 1 + (Integer)visit(ctx.expr());
        }
        return 1;
    }

    @Override
    public Integer visitAsignacion(ExprParser.AsignacionContext ctx) {
        return (Integer)visit(ctx.expr());
    }
    @Override
    public Integer visitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx) {
        int puntosBucle = 0;

        puntosBucle += (Integer)visit(ctx.expr());
        if (ctx.sentencia_unica() != null) puntosBucle += (Integer)visit(ctx.sentencia_unica());
        else if(ctx.codigo() != null)puntosBucle += (Integer)visit(ctx.codigo());
        puntosBucle = (int)Math.pow(puntosBucle, 2);
        return puntosBucle;
    }
    @Override
    public Integer visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx) {
        int puntosLlamadaF = 2; //hemos llegado a una llamada a funcion a si que como minimo su puntuacion sera 2

        if(ctx.expr() != null){
            ArrayList<ExprParser.ExprContext> parametrosLlamadaF = new ArrayList<ExprParser.ExprContext>(ctx.expr());
            puntosLlamadaF += parametrosLlamadaF.size(); //al valor minimo de 2 se le sumara 1 por cada parametro que use la funcion
            for(ExprParser.ExprContext parametro : parametrosLlamadaF){
                puntosLlamadaF += (Integer)visit(parametro); //como un argumento puede ser una expr y estas pueden ser elementos puntos funcion tenemos que visitar cada una
            }

        funcionVisitada.addLlamadasFuncion(1);
        return puntosLlamadaF;
        }
        return puntosLlamadaF;
    }
    @Override
    public Integer visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        int puntosIf = 0;
        puntosIf += Math.pow((Integer) visit(ctx.expr()), 2);

        if(ctx.codigo() != null){
            ArrayList<ExprParser.CodigoContext> bloquesCodigo = new ArrayList<ExprParser.CodigoContext>(ctx.codigo());

            for(ExprParser.CodigoContext bloque : bloquesCodigo){
                puntosIf += (int) Math.pow((Integer)visit(bloque), 2);
            }
        }
        return puntosIf;
    }
    @Override
    public Integer visitCuerposwitch(ExprParser.CuerposwitchContext ctx) {
        int puntosSw = 0;
        puntosSw += Math.pow((Integer)visit(ctx.expr()), 2);

        if(ctx.codigo() != null){
            ArrayList<ExprParser.CodigoContext> bloquesCodigo = new ArrayList<ExprParser.CodigoContext>(ctx.codigo());

            for(ExprParser.CodigoContext bloque: bloquesCodigo){
                puntosSw += Math.pow((Integer)visit(bloque), 2);
            }
        }
        return puntosSw;
    }

    @Override
    public Integer visitMultDiv(ExprParser.MultDivContext ctx) {
        funcionVisitada.addOperadorSimple(1);

        return 1 + ((Integer)visit(ctx.expr(0)) + (Integer)visit(ctx.expr(1)));
    }

    @Override
    public Integer visitSumRest(ExprParser.SumRestContext ctx) {
        funcionVisitada.addOperadorSimple(1);
        return 1 + ((Integer)visit(ctx.expr(0)) + (Integer)visit(ctx.expr(1)));
    }
    @Override
    public Integer visitExprBooleana(ExprParser.ExprBooleanaContext ctx) {
        funcionVisitada.addOperadorSimple(1);
        return 1 + ((Integer)visit(ctx.expr(0)) + (Integer)visit(ctx.expr(1)));
    }
    @Override
    public Integer visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx) {
        return (Integer)visit(ctx.llamadafuncion());
    }
    @Override public Integer visitTerminalBool(ExprParser.TerminalBoolContext ctx) { return 0; }
    @Override public Integer visitTerminalInt(ExprParser.TerminalIntContext ctx) { return 0; }
    @Override public Integer visitExprEntreParentesis(ExprParser.ExprEntreParentesisContext ctx) { return 0; }
    @Override public Integer visitExprId(ExprParser.ExprIdContext ctx) { return 0; }
    @Override public Integer visitTerminalString(ExprParser.TerminalStringContext ctx) { return 0; }
}
