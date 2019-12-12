import java.util.*;

public class TablaDeSimbolos{

    private HashMap<String, Funcion> ts;
    //private HashMap<String, ArrayList<String>> grafoLlamadasFuncion;
    private long resumenPuntosFuncion;
    private long resumenLineasEfectivas;

    public TablaDeSimbolos(){
        this.ts = new HashMap<String, Funcion>();
        //this.grafoLlamadasFuncion = new HashMap<String, ArrayList<String>>();
        this.resumenPuntosFuncion = 0;
        this.resumenLineasEfectivas = 0;
    }
    public HashMap<String, Funcion> getHashMap(){
        return this.ts;
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

    public String printHashMapToHtml(){
        String textoHtml = "";
        for (Funcion funcion : ts.values()){
            textoHtml += funcion.writeHtml();
        }
        return textoHtml;
    }
    public void generarResumenFunciones(){
        for(Funcion funcion : ts.values()){
            resumenPuntosFuncion += funcion.getPuntosFuncion();
            resumenLineasEfectivas += funcion.getLineasEfectivas();
        }
    }

    public String conversionNombre(String nombreSimple){
        String nombreConvertido = null;
        for (String nombreComplejo : this.ts.keySet()){
            if (nombreComplejo.contains(nombreSimple)){
                nombreConvertido = nombreComplejo;
                break;
            }
        }
        return nombreConvertido;
    }
    public String nombreValido(String cadena){

        if (cadena.contains(" ")){
            cadena = cadena.replace(" ", "_");
        }
        if (cadena.contains("(")){
            cadena = cadena.replace("(", "_argumentos_");
        }
        if (cadena.contains(")")){
            cadena = cadena.replace(")", "_devuelve_");
        }
        if (cadena.contains(":")){
            cadena = cadena.replace(":", "_");
        }
        if (cadena.contains(",")){
            cadena = cadena.replace(",", "_");
        }
        return cadena;
    }

    public String generarGrafoLlamadasFuncion(String nombreFuncion, boolean nombreSimple){
        if (nombreSimple){                                                              //si es un nombre simple i.e main y la TDS contiene la
            if(this.ts.containsKey(conversionNombre(nombreFuncion))) {
                nombreFuncion = conversionNombre(nombreFuncion);                        //clave function main():void convierte el nombre simple
            }
            else{                                                                       //se convierte a nombrecomplejo para poder acceder a la clave
                this.ts.put(nombreFuncion, new Funcion());
            }                                                                           //si no, es una funcion del lenguaje y la añade vacia al HM
        }

        ArrayList<String>funcionesLlamadas = this.ts.get(nombreFuncion).getLlamadasFuncion();
        String capaGrafo = "";


        if (funcionesLlamadas.isEmpty() || funcionesLlamadas == null){
            return nombreFuncion;
        }
        else {
            for (String funcionLlamada : funcionesLlamadas){
                capaGrafo += nombreValido(nombreFuncion) + "->" + generarGrafoLlamadasFuncion(funcionLlamada, true) + "\n";
            }
            return capaGrafo;
        }

    }


}
