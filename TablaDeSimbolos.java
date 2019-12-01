import java.util.*;

public class TablaDeSimbolos{

    private HashMap<String, Funcion> ts;

    public TablaDeSimbolos(){
        this.ts = new HashMap<String, Funcion>();
    }
    public void addFuncion(Funcion funcion){ts.put(funcion.getNombre(), funcion);}
    public void printHashMap(){
        for (Funcion funcion : ts.values()){
            funcion.printAttributes();
            System.out.println();
        }
    }
}
