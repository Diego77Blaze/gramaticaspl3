
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EjecutableExpr{
    public static void main(String[] args) throws Exception{
        TablaDeSimbolos ts = new TablaDeSimbolos();
        String inputFile=null;

        int puntosTotales;

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

        VisitorPropio vp = new VisitorPropio(ts);
        vp.visit(tree);

        ts.printHashMap();

        //System.out.println(lprop.ruta);
    }
    //public static void limpiarArchivo(){File archivo=new File("esquemaarbol.txt");archivo.delete();}
}
