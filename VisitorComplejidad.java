import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;





public class VisitorComplejidad extends ExprParserBaseVisitor{

    private TablaDeSimbolosComplejidad ts;
    

    public VisitorComplejidad(TablaDeSimbolosComplejidad ts){
        this.ts = ts;
        

    }
    @Override
    public Integer visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx) {
        ArrayList<Integer> valores;
        ts.addNewNode();
        if(ctx.codigo()!=null){visit(ctx.codigo());}

        return 0;
    }
    @Override
    public Integer visitCodigo(ExprParser.CodigoContext ctx) {
        Integer useless=0;
        if(ctx.sentencia_unica()!=null){
            ArrayList<ExprParser.Sentencia_unicaContext> sentencias = new ArrayList<ExprParser.Sentencia_unicaContext>(ctx.sentencia_unica());
        
            for(ExprParser.Sentencia_unicaContext linea: sentencias){
                useless += (Integer)visit(linea);
            }
        }
        return 0;
    }
    @Override
    public Integer visitSentencia_unica(ExprParser.Sentencia_unicaContext ctx) {visitChildren(ctx);  return 0;}
    
    @Override
    public Integer visitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        if(ctx.sentencia_unica()!=null){
            visit(ctx.sentencia_unica());
        
        }
        if(ctx.codigo()!=null){ 
            visit(ctx.codigo());
        
        }
        Integer nodo2=ts.addNewNode();
        ts.addValor(nodo2-1,nodo2);
        ts.addValor(nodo2,nodo);
        Integer nodo3=ts.addNewNode();
        ts.addValor(nodo,nodo3);
        return 0;

    }
    @Override
    public Integer visitBucle_for(ExprParser.Bucle_forContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        if(ctx.codigo()!=null){        
            visit(ctx.codigo());
        
        }
        Integer nodo2=ts.addNewNode();
        ts.addValor(nodo2-1,nodo2);
        ts.addValor(nodo2,nodo);
        Integer nodo3=ts.addNewNode();
        ts.addValor(nodo,nodo3);
        return 0;
        
    }   
    @Override
    public Integer visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        Integer useless=0;
        Integer nodo=ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        if(ctx.codigo()!=null){
            
                ArrayList<ExprParser.CodigoContext> sentencias = new ArrayList<ExprParser.CodigoContext>(ctx.codigo());
            
            for(ExprParser.CodigoContext linea: sentencias){
                useless += (Integer)visit(linea);
            }
        }
        if(ctx.else_key()!=null){ 
            Integer nodo2=ts.addNewNode();
            Integer nodo3=ts.addNewNode();
            Integer nodo4=ts.addNewNode();
            ts.addValor(nodo,nodo2);
            ts.addValor(nodo,nodo3);
            ts.addValor(nodo2,nodo4);
            ts.addValor(nodo3,nodo4);
            return 0;
        }
        else{
            Integer nodo2=ts.addNewNode();
            Integer nodo3=ts.addNewNode();
            ts.addValor(nodo,nodo2);
            ts.addValor(nodo,nodo3);
            ts.addValor(nodo2,nodo3);
        }
        return 0;

    }   

    

    @Override
    public Integer visitDevolver(ExprParser.DevolverContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        return 0;
    }
    @Override
    public Integer visitDeclaracion(ExprParser.DeclaracionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        return 0;
    }
    @Override
    public Integer visitAsignacion(ExprParser.AsignacionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        return 0;
    }
    @Override
    public Integer visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        return 0;
    }
    @Override
    public Integer visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        return 0;
    }
}