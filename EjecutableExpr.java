
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

            //TablaDeSimbolos ts = new TablaDeSimbolos();
            String inputFile = null;
            long resumenPuntosFuncion  = 0;
            long resumenLineasEfectivas = 0;
            long puntosTotales;

            if(args.length>0){inputFile=args[0];}
            if(args.length>1){funcionArg = args[1];}
            if(args.length>2){nombreHtml = args[2];}
            //inputFile="prueba1.prog";
            InputStream is = System.in;
            if(inputFile!=null){ is=new FileInputStream(inputFile);}
        //    limpiarArchivo();


            CharStream input = CharStreams.fromStream(is);
            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens =new CommonTokenStream(lexer);
            ExprParser parser =new ExprParser(tokens);
            parser.setBuildParseTree(true);
            ParseTree tree=parser.axioma();

            File archivo = new File(nombreHtml);
            File dot = new File("DiagramaLlamadas.dot"); //Se hace en otro sitio y se le mete: <html> <head> <title>PECL3 Procesadores del lenguaje</title> </head><body> <h1>Resultados PECL3</h1>
            //Al final del archivo habrá que ponerle fin a body y a html con </body> y </html>

            VisitorPropio vp = new VisitorPropio(ts);
            vp.visit(tree);
            VisitorComplejidad vc= new VisitorComplejidad(tsc);
            vc.visit(tree);



            ts.generarResumenFunciones();
            resumenPuntosFuncion = ts.getResumenPuntosFuncion();
            resumenLineasEfectivas = ts.getResumenLineasEfectivas();
            //PRINT EN CONSOLA
            ts.printHashMap();
            System.out.println("El resumen de puntosFuncion del programa es: " + resumenPuntosFuncion + " puntos en total");
            System.out.println("El resumen de lineas efectivas del programa es: " + resumenLineasEfectivas + " lineas efectivas en total");


            //System.out.println( // EL ARGUMENTO DE generarDot con ese argumento DEVUELVE EL STRING CON EL CODIGO
            generarDot(ts.generarGrafoLlamadasFuncion(funcionArg, true), funcionArg);


            //PRINT EN HTML
            Writer output;
            String htmlClose = "\n</body> </html>";
            String htmlResumen =  "<li>Resumen Puntos Funcion:<strong> " + ts.getResumenPuntosFuncion()+ "</strong></li>\n"
                                  +"<li>Resumen Lineas Efectivas:<strong> " + ts.getResumenLineasEfectivas()+ "</strong></li>\n"
                                  +"<li>Resumen Grafo de Llamadas a Funcion: <strong>" + funcionArg + "</strong></li>\n"
                                  +"<p><img src="+"DiagramaLlamadas.svg"+" width="+"100%"+"/></p>";
                                  //+"<li>Resumen Puntos Funcion:<strong>" + HAY QUE COGELLA()+ "</strong></li>\n"
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
                //stdin.println("dot -Tsvg "+num +".dot -o "+num+".svg");

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
