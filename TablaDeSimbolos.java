import java.util.*;

public class TablaDeSimbolos{

    private HashMap<String, Funcion> ts;
    private long resumenPuntosFuncion;
    private long resumenLineasEfectivas;

    public TablaDeSimbolos(){
        this.ts = new HashMap<String, Funcion>();
        this.resumenPuntosFuncion = 0;
        this.resumenLineasEfectivas = 0;
    }

    public long getResumenPuntosFuncion()
    {
        return this.resumenPuntosFuncion;
    }
    public long getResumenLineasEfectivas()
    {
        return this.resumenLineasEfectivas;
    }
    public void addFuncion(Funcion funcion){
        ts.put(funcion.getNombre(), funcion);
    }

    public void printHashMap(){
        for (Funcion funcion : ts.values()){
            funcion.printAttributes();
            System.out.println();
        }
    }

    public void printHashMapToHtml(){
        for (Funcion funcion : ts.values()){
            funcion.writeHtml();
        }
    }
    public void generarResumenFunciones(){
        for(Funcion funcion : ts.values()){
            resumenPuntosFuncion += funcion.getPuntosFuncion();
            resumenLineasEfectivas += funcion.getLineasEfectivas();
        }
    }

}
