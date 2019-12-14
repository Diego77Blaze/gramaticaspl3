
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EjecutableExpr{

    public static void main(String[] args) throws Exception{
        TablaDeSimbolos ts = new TablaDeSimbolos();
        TablaDeSimbolosComplejidad tsc = new TablaDeSimbolosComplejidad();
        String inputFile = null;
        long resumenPuntosFuncion  = 0;
        long resumenLineasEfectivas = 0;
        long puntosTotales;

        if(args.length>0){inputFile=args[0];}

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

        File archivo = new File("Resultado.html"); //Se hace en otro sitio y se le mete: <html> <head> <title>PECL3 Procesadores del lenguaje</title> </head><body> <h1>Resultados PECL3</h1>
        //Al final del archivo habrá que ponerle fin a body y a html con </body> y </html>

        VisitorPropio vp = new VisitorPropio(ts);
        vp.visit(tree);
        VisitorComplejidad vc = new VisitorComplejidad(tsc);
        vc.visit(tree);



        ts.generarResumenFunciones();
        resumenPuntosFuncion = ts.getResumenPuntosFuncion();
        resumenLineasEfectivas = ts.getResumenLineasEfectivas();
        //PRINT EN CONSOLA
        ts.printHashMap();
        System.out.println("El resumen de puntosFuncion del programa es: " + resumenPuntosFuncion + " puntos en total");
        System.out.println("El resumen de lineas efectivas del programa es: " + resumenLineasEfectivas + " lineas efectivas en total");


        //PRINT EN HTML
        Writer output;
        String htmlClose = "\n</body> </html>";
        String htmlResumen =  "<li>Resumen Puntos Funcion:<strong> " + ts.getResumenPuntosFuncion()+ "</strong></li>\n"
                              +"<li>Resumen Lineas Efectivas:<strong> " + ts.getResumenLineasEfectivas()+ "</strong></li>\n"
                              +"<li>Resumen Grafo de Llamadas a Funcion:<strong> " + "HAY QUE METER ALGO NINIO"+ "</strong></li>\n";
                              //+"<li>Resumen Puntos Funcion:<strong>" + HAY QUE COGELLA()+ "</strong></li>\n"
        String htmlLine = "<body> <html> \n";
        try{
          output = new BufferedWriter(new FileWriter("Resultado.html", false));
          output.append(htmlLine);
          output.append(ts.printHashMapToHtml());
          output.append(htmlResumen);
          output.append(htmlClose);

          output.close();
        } catch (IOException e){
          e.printStackTrace();
        }


        //System.out.println(lprop.ruta);
    }
    //public static void limpiarArchivo(){File archivo=new File("esquemaarbol.txt");archivo.delete();}
}
