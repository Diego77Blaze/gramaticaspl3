import java.util.*;

public class TablaDeSimbolos{


//TODO ACCESO A FUNCION MAS CONSISTENTE
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
            if (!funcion.getNombre().equals("")){
                funcion.printAttributes();
                System.out.println();
            }
        }
    }

    public String printHashMapToHtml(){
        String textoHtml = "";
        for (Funcion funcion : ts.values()){
            if (!funcion.getNombre().equals("")){
                funcion.convertirArchivos();
                textoHtml += funcion.writeHtml();
            }
        }
        return textoHtml;
    }
    public void generarResumenFunciones(){
        for(Funcion funcion : ts.values()){
            resumenPuntosFuncion += funcion.getPuntosFuncion();
            resumenLineasEfectivas += funcion.getLineasEfectivas();
        }
    }

    public String conversionNombre(String nombreSimple){                            //RETOCAR LAS FUNCIONES QUE MANIPULAN EL NOMBRE DE FUNCIONES
        String nombreConvertido = null;                                             //PARA CONSEGUIR COMPARAR SI SON EXACTAMENTE IGUALES O NO
        for (String nombreComplejo : this.ts.keySet()){
            if(nombreComplejo.contains("(")){
                if (trocearNombreFuncionCompleto(nombreComplejo).equals(nombreSimple)){
                    nombreConvertido = nombreComplejo;
                    break;
                }
            }
        }
        return nombreConvertido;
    }
    public String trocearNombreFuncionCompleto(String nombreCompleto){
        String identificadorFuncion = "";
        int beginIndex = 9; //todos los nombres de funciones declaradas empiezan por function + espacio
        int endIndex = nombreCompleto.indexOf("("); //el identificador acabara cuando encontremos un abrir parentesis
        identificadorFuncion = nombreCompleto.substring(beginIndex, endIndex);

        return identificadorFuncion;

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
        HashMap<String, Funcion> copiaTDS = this.ts;

        if (nombreSimple){                                                              //si es un nombre simple i.e main y la TDS contiene la
            if(copiaTDS.containsKey(conversionNombre(nombreFuncion))) {
                nombreFuncion = conversionNombre(nombreFuncion);                        //clave function main():void convierte el nombre simple
            }
            else{                                                                       //se convierte a nombrecomplejo para poder acceder a la clave
                copiaTDS.put(nombreFuncion, new Funcion());
            }                                                                           //si no, es una funcion del lenguaje y la añade vacia al HM
        }

        ArrayList<String>funcionesLlamadas = copiaTDS.get(nombreFuncion).getLlamadasFuncion();
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
