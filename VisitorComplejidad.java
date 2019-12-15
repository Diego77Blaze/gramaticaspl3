import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.*;




public class VisitorComplejidad extends ExprParserBaseVisitor{

    private TablaDeSimbolosComplejidad ts;
    private TablaDeSimbolos tsimbolos;
    

    public VisitorComplejidad(TablaDeSimbolosComplejidad ts,TablaDeSimbolos tsimbolos){
        this.ts = ts;
        this.tsimbolos=tsimbolos;
        

    }
    @Override
    public String visitAxioma(ExprParser.AxiomaContext ctx) {
        int numerofunciones=0,numeroAristas=0,numeroNodos=0;
        if (ctx.cuerpofuncion() != null){
            ArrayList<ExprParser.CuerpofuncionContext> funciones = new ArrayList<ExprParser.CuerpofuncionContext>(ctx.cuerpofuncion());

            for(ExprParser.CuerpofuncionContext funcion: funciones){
               
                try {
                    String nombreFuncion= (String)visit(funcion);
                    Funcion funcion1= tsimbolos.getHashMap().get(nombreFuncion);
                    funcion1.setNombreArchivo("complejidad"+numerofunciones);
                    String nombre = "complejidad"+numerofunciones;
                    
                    String ruta = nombre+".dot";
                   
                    String contenido = "digraph "+nombre + " {\n\t";
                    String cierreLlave="}";
                    Set<Integer> nodos=ts.getTablaSimbolosComplejidad().keySet();
                    numeroNodos=nodos.size();
                    File file = new File(ruta);
                    
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    Writer output;
                    output = new BufferedWriter(new FileWriter(ruta, false));
                    
                    output.append(contenido);
                    System.out.println(nodos);
                    for(Integer nodo : nodos ){
                        ArrayList<Integer> aristas = (ArrayList)ts.getTablaSimbolosComplejidad().get(nodo);
                        for(int i=0;i<aristas.size();i++){
                            output.append((nodo-1) +"->"+ (aristas.get(i)-1)+";\n\t");
                        }
                        numeroAristas+=aristas.size();
                    }
                    output.append(cierreLlave);
                    
                    output.close();
                    numerofunciones++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                funcion1.setComplejidad(numeroAristas,numeroNodos);
                ts.emptyTabla();
                
            }
        }
        return "";
        
    }

    
    @Override
    public String visitCabecerafuncion(ExprParser.CabecerafuncionContext ctx) {
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

        return nombreFuncion;

    }
    @Override
    public String visitCuerpofuncion(ExprParser.CuerpofuncionContext ctx) {

        ArrayList<Integer> valores;
        String nombreFuncion="";
        ts.addNewNode();
        if(ctx.codigo()!=null){nombreFuncion=(String)visit(ctx.cabecerafuncion());visit(ctx.codigo());}
        System.out.println(nombreFuncion);

        return nombreFuncion;
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
        Integer useless=0;
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
        Integer nodo2=ts.addNewNode();
        ts.addValor(nodo,nodo2);
        if(ctx.codigo()!=null){ 
            visit(ctx.codigo());
        }  
        Integer nodo3=ts.addNewNode();
        ts.addValor(nodo3-1,nodo3);
        ts.addValor(nodo3,nodo2);
        Integer nodo4= ts.addNewNode();
        ts.addValor(nodo2,nodo4);
        return 0;
        
    }   
    @Override
    public Integer visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        Integer useless=0;
        Integer nodo=ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        visit(ctx.codigo(0));
        Integer nodo2=ts.addNewNode();
        ts.addValor(nodo2-1,nodo2);
        if(ctx.codigo(1)!=null){
            Integer nodo3=ts.addNewNode();
            ts.addValor(nodo,nodo3);
            visit(ctx.codigo(1));
            System.out.println("me meto en el else");             
            Integer nodo4=ts.addNewNode();
            ts.addValor(nodo4-1,nodo4);
            ts.addValor(nodo2,nodo4);
            //ts.addValor(nodo3,nodo4);
            return 0;
        }
        else{
            Integer nodo3=ts.addNewNode();
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