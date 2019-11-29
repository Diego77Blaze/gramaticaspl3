
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EjecutableExpr{
    public static void main(String[] args) throws Exception{
        String inputFile=null;

        if(args.length>0){inputFile=args[0];}
        inputFile="PdL-PL2-Prueba01.prog";
        //inputFile="prueba1.prog";
        InputStream is = System.in;
        if(inputFile!=null){ is=new FileInputStream(inputFile);}
        limpiarArchivo();
        CharStream input = CharStreams.fromStream(is);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens =new CommonTokenStream(lexer);
        ExprParser parser =new ExprParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree=parser.axioma();

        VisitorPropio vp = new VisitorPropio();
        vp.visit().axioma;

        //System.out.println(lprop.ruta);
    }
    public static void limpiarArchivo(){File archivo=new File("esquemaarbol.txt");archivo.delete();}
}
