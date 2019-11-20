
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.io.*;

import java.util.*;

public class ListenerPropio extends ExprParserBaseListener{
    public ArrayList<String> ruta=new ArrayList<>();
    @Override
    public void enterEveryRule(ParserRuleContext ctx){
        ruta.add(ExprParser.ruleNames[ctx.getRuleIndex()]);
        escribirArchivo();
        if(ctx.getChildCount()==1){
            ruta.add(ctx.getRuleContext().getText());
            escribirArchivoToken();
            ruta.remove(ruta.size()-1);
        }
        
    }
    public void exitEveryRule(ParserRuleContext ctx){
       ruta.remove(ruta.size()-1);
    }
    
    public void escribirArchivo(){
        FileWriter archivo = null;
        PrintWriter pw;
        try {
            archivo = new FileWriter("esquemaarbol.txt", true);
            pw = new PrintWriter(archivo);
            //pw.println("Ruta:");
            for (int i = 0; i < ruta.size(); i++) {
                pw.print("/"+ruta.get(i));
                
            }
            pw.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e) {
            }
        }

    }
    public void escribirArchivoToken(){
        FileWriter archivo = null;
        PrintWriter pw;
        try {
            archivo = new FileWriter("esquemaarbol.txt", true);
            pw = new PrintWriter(archivo);
            for (int i = 0; i <ruta.size(); i++) {
                if (i==ruta.size()-1){pw.print(":"+ruta.get(i));}
                else{pw.print("/"+ruta.get(i));}               
                
            }
            pw.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e) {
            }
        }

    }
}