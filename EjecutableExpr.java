
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EjecutableExpr{

    public static void main(String[] args) throws Exception{
        TablaDeSimbolos ts = new TablaDeSimbolos();
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



        ts.generarResumenFunciones();
        resumenPuntosFuncion = ts.getResumenPuntosFuncion();
        resumenLineasEfectivas = ts.getResumenLineasEfectivas();
        //PRINT EN CONSOLA
        ts.printHashMap();
        System.out.println("El resumen de puntosFuncion del programa es: " + resumenPuntosFuncion + " puntos en total");
        System.out.println("El resumen de lineas efectivas del programa es: " + resumenLineasEfectivas + " lineas efectivas en total");


        //PRINT EN HTML
        Writer output;
        String htmlLine = "</body> </html>";
        try{
          output = new BufferedWriter(new FileWriter("Resultado.html", false));
          output.append(htmlLine);
          output.close();
        } catch (IOException e){
          e.printStackTrace();
        }
        ts.printHashMapToHtml();

        //System.out.println(lprop.ruta);
    }
    //public static void limpiarArchivo(){File archivo=new File("esquemaarbol.txt");archivo.delete();}
}
