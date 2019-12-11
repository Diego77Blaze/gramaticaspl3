import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;





public class VisitorComplejidad extends ExprParserBaseVisitor{

    private TablaDeSimbolosComplejidad ts;
    

    public VisitorComplejidad(TablaDeSimbolosComplejidad ts){
        this.ts = ts;
        

    }
    @Override
    public void visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx) {
        ArrayList<Integer> valores;
        ts.addNewNode();
        if(ctx.codigo()!=null){visit(ctx.codigo());}
        if(ctx.cuerpofuncion()!=null){visit(ctx.cuerpofuncion());}

        
    }
    @Override
    public void visitCodigo(ExprParser.CodigoContext ctx) {if(ctx.sentencia_unica()!=null){visit(ctx.sentencia_unica);}}
    @Override
    public void visitSentencia_unica(ExprParser.Sentencia_unicaContext ctx) {visitChildren(ctx);  }
    
    @Override
    public void visitCuerpobuclewhile(ExprParser.CuerpobuclewhileContext ctx) {
        Integer nodo= ts.addNewNode();
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


    }
    @Override
    public void visitBucle_for(ExprParser.Bucle_forContext ctx) {
        Integer nodo= ts.addNewNode();
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
    }   
    @Override
    public void visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        Integer nodo=ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        if(ctx.codigo()!=null){visit(ctx.codigo());}
        if(ctx.else_key()!=null){ 
            Integer nodo2=ts.addNewNode();
            Integer nodo3=ts.addNewNode();
            Integer nodo4=ts.addNewNode();
        }
        else{
            Integer nodo2=ts.addNewNode();
            Integer nodo3=ts.addNewNode();
            Integer nodo4=ts.addNewNode();
        }

    }   
    
    @Override
    public void visitElse_key(ExprParser.Else_keyContext ctx) {}

    

    @Override
    public void visitDevolver(ExprParser.DevolverContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
    }
    @Override
    public void visitDeclaracion(ExprParser.DeclaracionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
    }
    @Override
    public void visitAsignacion(ExprParser.AsignacionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
    }
    @Override
    public void visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
    }
    @Override
    public void visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx) {
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
    }
}