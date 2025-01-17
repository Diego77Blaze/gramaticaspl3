import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.*;

public class VisitorComplejidad extends ExprParserBaseVisitor{

    private TablaDeSimbolosComplejidad ts;
    private TablaDeSimbolos tsimbolos;
    private String funcionactual="";
    private String funcionanterior="";
    private Boolean grafoGlobal=false;
    private int numeronodosgrafofinal=0;
    private ArrayList<Integer> nodosLlamada=new ArrayList<>();


    public VisitorComplejidad(TablaDeSimbolosComplejidad ts,TablaDeSimbolos tsimbolos){
        this.ts = ts;
        this.tsimbolos=tsimbolos;
    }
    @Override
    public String visitAxioma(ExprParser.AxiomaContext ctx) {
        int numerofunciones=0,numeroAristas=0,numeroNodos=0,primerNodo=0,ultimoNodo=0;

        if (ctx.cuerpofuncion() != null){
            ArrayList<ExprParser.CuerpofuncionContext> funciones = new ArrayList<ExprParser.CuerpofuncionContext>(ctx.cuerpofuncion());

            for(ExprParser.CuerpofuncionContext funcion: funciones){

                try {

                    String nombreFuncion= (String)visit(funcion);
                    funcionanterior=nombreFuncion;
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
                    funcion1.setNodoFinal(numeroNodos);
                    for(Integer nodo : nodos){
                        if(funcion1.getNodoInicial()<=nodo && funcion1.getNodoFinal()>=nodo){
                        ArrayList<Integer> aristas = (ArrayList)ts.getTablaSimbolosComplejidad().get(nodo);

                            for(int i=0;i<aristas.size();i++){
                                if(i==0 && nodo-1-funcion1.getNodoInicial()==1){
                                    output.append("I->"+(nodo-funcion1.getNodoInicial()-1)+";\n\t");
                                }
                                output.append((nodo-funcion1.getNodoInicial()) +"->"+ (aristas.get(i)-funcion1.getNodoInicial())+";\n\t");
                                if( nodo==funcion1.getNodoFinal()){
                                    output.append((funcion1.getNodoFinal()-funcion1.getNodoInicial()+1)+"->F;\n\t");
                                }
                            }
                            numeroAristas+=aristas.size();
                        }
                    }
                    output.append(cierreLlave);
                    ultimoNodo=numeroNodos;

                    output.close();
                    numerofunciones++;
                    funcion1.setComplejidad(numeroAristas,funcion1.getNodoFinal()-funcion1.getNodoInicial()+1);
                    numeroAristas=0;
                    numeronodosgrafofinal=numeroNodos;
                    numeroNodos=0;

                } catch (Exception e) {
                    e.printStackTrace();
                }




            }
        }
        grafoGlobal=true;
                    ArrayList<ExprParser.CuerpofuncionContext> funciones = new ArrayList<ExprParser.CuerpofuncionContext>(ctx.cuerpofuncion());
                    String auxiliar="";
                    for(ExprParser.CuerpofuncionContext funcio: funciones){

                        try {

                            visit(funcio);



                        } catch (Exception e) {
                            e.printStackTrace();
                        }}
                        try{
                            String nombrebase = "grafoCompleto";

                            String ruta2 = nombrebase+".dot";

                            String contenidobase = "digraph "+nombrebase + " {\n\t";
                            String cierreLlave="}";
                            Set<Integer> nodos=ts.getTablaSimbolosComplejidad().keySet();
                            numeroNodos=nodos.size();
                            File file2 = new File(ruta2);

                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                            Writer output2;
                            output2 = new BufferedWriter(new FileWriter(ruta2, false));

                            output2.append(contenidobase);
                            for(Integer nodo : nodos){

                                ArrayList<Integer> aristas = (ArrayList)ts.getTablaSimbolosComplejidad().get(nodo);

                                for(int i=0;i<aristas.size();i++){
                                    if(nodo==numeroNodos && aristas.get(i)-1!=nodo){
                                        output2.append(nodo +"->"+ (aristas.get(i)-1)+";\n\t");
                                    }else{
                                        output2.append(nodo-1 +"->"+ (aristas.get(i)-1)+";\n\t");
                                    }
                                }
                                numeroAristas+=aristas.size();

                            }
                            output2.append(cierreLlave);
                            output2.close();
                            ts.setComplejidadGlobal(numeroAristas-numeroNodos+2);
                        }

                        catch(Exception e){}


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
        String nombreFuncion="";


        if(ctx.codigo()!=null){
            nombreFuncion=(String)visit(ctx.cabecerafuncion());
            if(funcionanterior!=""){
                tsimbolos.getHashMap().get(nombreFuncion).setNodoInicial(tsimbolos.getHashMap().get(funcionanterior).getNodoFinal()+1);
            }
            if(!grafoGlobal){
            ts.addNewNode();}
            visit(ctx.codigo());}

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
        if(grafoGlobal){

        }
        else{
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
            Integer nodo3=ts.addNewNode();
            ts.addValor(nodo,nodo3);
            ts.addValor(nodo2,nodo);

        }
        return 0;
    }
    @Override
    public Integer visitBucle_for(ExprParser.Bucle_forContext ctx) {
        if(grafoGlobal){

        }
        else{
            Integer nodo= ts.addNewNode();
            ts.addValor(nodo-1,nodo);
            Integer nodo2=ts.addNewNode();
            ts.addValor(nodo,nodo2);
            if(ctx.codigo()!=null){
                visit(ctx.codigo());
            }
            Integer nodo3=ts.addNewNode();
            ts.addValor(nodo3-1,nodo3);

            Integer nodo4=ts.addNewNode();
            ts.addValor(nodo2,nodo4);
            ts.addValor(nodo3,nodo2);

        }
        return 0;
    }
    @Override
    public Integer visitCuerpoif(ExprParser.CuerpoifContext ctx) {
        if(grafoGlobal){

        }
        else{

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
                Integer nodo4=ts.addNewNode();
                ts.addValor(nodo4-1,nodo4);
                ts.addValor(nodo2,nodo4);
                return 0;
            }
            else{
                Integer nodo3=ts.addNewNode();
                ts.addValor(nodo,nodo3);
                ts.addValor(nodo2,nodo3);
            }

        }
        return 0;
    }



    @Override
    public Integer visitDevolver(ExprParser.DevolverContext ctx) {
        if (ctx.expr() != null){

                        visit(ctx.expr());

        }
        if(grafoGlobal){


        }
        else{
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);

        }
        return 0;
    }
    @Override
    public Integer visitDeclaracion(ExprParser.DeclaracionContext ctx) {
        if (ctx.expr() != null)
        {
            ArrayList<ExprParser.ExprContext> exprAsignadas = new ArrayList<>(ctx.expr());
            for (ExprParser.ExprContext exprAsignada : exprAsignadas)
            {
                visit(exprAsignada);
            }
        }
        if(grafoGlobal){


        }
        else{
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        }
        return 0;
    }
    @Override
    public Integer visitAsignacion(ExprParser.AsignacionContext ctx) {
        if (ctx.expr() != null)
        {

                visit(ctx.expr());

        }
        if(grafoGlobal){


        }
        else{
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        }
        return 0;
    }
    @Override
    public Integer visitLlamadafuncion(ExprParser.LlamadafuncionContext ctx) {
        if(grafoGlobal){



        String nombreFuncion ="function ";
        nombreFuncion += ctx.identificador_tok().IDENTIFICADOR().getText();
        Set<String> posiblefuncion =tsimbolos.getHashMap().keySet();
        String funcionSeleccionada="";
        for(String grafo : posiblefuncion){
            if(grafo.contains(nombreFuncion)){
                funcionSeleccionada=grafo;
            }
        }
        Integer nodo=nodosLlamada.get(0);
        nodosLlamada.remove(nodo);
        Funcion funcionElegida;
        if(tsimbolos.getHashMap().containsKey(funcionSeleccionada)){
            funcionElegida=tsimbolos.getHashMap().get(funcionSeleccionada);
            ts.addValor(nodo,funcionElegida.getNodoInicial()+1);
            Set <Integer> setdenodos=ts.getTablaSimbolosComplejidad().keySet();
            int finalisimo=setdenodos.size();
            if(finalisimo>=funcionElegida.getNodoFinal()+1){
                ts.addValor(funcionElegida.getNodoFinal()+1,nodo);
            }else {ts.addValor(funcionElegida.getNodoFinal(),nodo);}
        }



        }
        else{
        Integer nodo= ts.addNewNode();
        nodosLlamada.add(nodo-1);
        ts.addValor(nodo-1,nodo);
        }
        return 0;
    }
    @Override
    public Integer visitExprLlamadaFuncion(ExprParser.ExprLlamadaFuncionContext ctx) {
        visit(ctx.llamadafuncion());
        if(grafoGlobal){
              visit(ctx.llamadafuncion());
        }
        else{
        Integer nodo= ts.addNewNode();
        nodosLlamada.add(nodo);
        ts.addValor(nodo-1,nodo);
        }
        return 0;
    }

    @Override
    public Integer visitAsignacion_array(ExprParser.Asignacion_arrayContext ctx){
        if (ctx.expr() != null)
        {
            ArrayList<ExprParser.ExprContext> exprAsignadas = new ArrayList<>(ctx.expr());
            for (ExprParser.ExprContext exprAsignada : exprAsignadas)
            {
                visit(exprAsignada);
            }
        }
        if(grafoGlobal){


        }
        else{
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        }
        return 0;
    }

    @Override
    public Integer visitDeclaracion_array(ExprParser.Declaracion_arrayContext ctx){
        if (ctx.expr() != null)
        {
            ArrayList<ExprParser.ExprContext> exprAsignadas = new ArrayList<>(ctx.expr());
            for (ExprParser.ExprContext exprAsignada : exprAsignadas)
            {
                visit(exprAsignada);
            }
        }
        if(grafoGlobal){

        }
        else{
        Integer nodo= ts.addNewNode();
        ts.addValor(nodo-1,nodo);
        }
        return 0;

    }

    public Integer visitExpr(ExprParser.ExprContext ctx) {
        visitChildren(ctx);
        return 0;
    }
}
