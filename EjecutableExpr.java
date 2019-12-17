
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EjecutableExpr{
        private static TablaDeSimbolos ts = new TablaDeSimbolos();
        private static TablaDeSimbolosComplejidad tsc = new TablaDeSimbolosComplejidad();

        public static void main(String[] args) throws Exception{
            String funcionArg = "";
            String nombreHtml = "";
            String inputFile = null;
            long resumenPuntosFuncion  = 0;
            long resumenLineasEfectivas = 0;
            long puntosTotales;

            if(args.length>0){inputFile=args[0];}
            if(args.length>1){funcionArg = args[1];}
            if(args.length>2){nombreHtml = args[2];}
            InputStream is = System.in;
            if(inputFile!=null){ is=new FileInputStream(inputFile);}


            CharStream input = CharStreams.fromStream(is);
            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens =new CommonTokenStream(lexer);
            ExprParser parser =new ExprParser(tokens);
            parser.setBuildParseTree(true);
            ParseTree tree=parser.axioma();

            File archivo = new File(nombreHtml);
            File dot = new File("DiagramaLlamadas.dot");


            VisitorPropio vp = new VisitorPropio(ts);
            vp.visit(tree);
            VisitorComplejidad vc= new VisitorComplejidad(tsc,ts);
            vc.visit(tree);



            ts.generarResumenFunciones();
            resumenPuntosFuncion = ts.getResumenPuntosFuncion();
            resumenLineasEfectivas = ts.getResumenLineasEfectivas();


            LlamadaFuncion funcionArgumento = new LlamadaFuncion();
            funcionArgumento.setNombre(funcionArg);
            funcionArgumento.setNumeroP(ts.get(ts.conversionNombreFuncionArgumento(funcionArg)).getNumParametros());
            generarDot(ts.generarGrafoLlamadasFuncion(funcionArgumento, true), funcionArg);


            Writer output;
            String htmlClose = "\n</body> </html>";
            String htmlResumen =  "<li>Resumen Puntos Funcion:<strong> " + ts.getResumenPuntosFuncion()+ "</strong></li>\n"
                                  +"<li>Resumen Lineas Efectivas:<strong> " + ts.getResumenLineasEfectivas()+ "</strong></li>\n"
                                  +"<li>Resumen Grafo de Llamadas a Funcion: <strong>" + funcionArg + "</strong></li>\n"
                                  +"<p><img src="+"DiagramaLlamadas.svg"+" width="+"100%"+"/></p>"
                                  +"<hr><li>Grafo completo del programa: </li>\n"
                                  +"<p><img src="+"grafoCompleto.svg"+"></p>";
            String htmlLine = "<body> <html> \n";
            try{
              output = new BufferedWriter(new FileWriter(nombreHtml, false));
              output.append(htmlLine);
              output.append(ts.printHashMapToHtml());
              output.append(htmlResumen);
              output.append(htmlClose);

              output.close();
            } catch (IOException e){
              e.printStackTrace();
            }

            String[] command = {
            "cmd",
            };
            Process p;
            try{
                p = Runtime.getRuntime().exec(command);

                new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                stdin.println("dot -Tsvg DiagramaLlamadas.dot -o DiagramaLlamadas.svg");
                stdin.println("dot -Tsvg grafoCompleto.dot -o grafoCompleto.svg");
                stdin.close();
                p.waitFor();

            }catch(Exception e){
                e.printStackTrace();
            }

    }

    public static void generarDot(String cuerpoCodigo, String nombreFuncion){
        String archivoDot = "";
        String cabecera = "digraph " + nombreFuncion + "{\n\n";
        String cierreLlave = "}";
            archivoDot += cabecera + cuerpoCodigo + cierreLlave;
        Writer output;
        try{
          output = new BufferedWriter(new FileWriter("DiagramaLlamadas.dot", false));
          output.append(archivoDot);
          output.close();
        } catch (IOException e){
          e.printStackTrace();
        }
    }


}
