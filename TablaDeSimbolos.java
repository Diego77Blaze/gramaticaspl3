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
    public Funcion get(String clave){
        return ts.get(clave);
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

    public String conversionNombre(LlamadaFuncion lf){                            //RETOCAR LAS FUNCIONES QUE MANIPULAN EL NOMBRE DE FUNCIONES
        String nombreConvertido = null;
        String nombreSimple = lf.getNombre();                                        //PARA CONSEGUIR COMPARAR SI SON EXACTAMENTE IGUALES O NO
        int numParametrosFcompleja = 0;
        int numParametrosFllamada = lf.getNumeroP();
        for (String nombreComplejo : this.ts.keySet()){
            numParametrosFcompleja = ts.get(nombreComplejo).getNumParametros();
            if(nombreComplejo.contains("(")){
                if (trocearNombreFuncionCompleto(nombreComplejo).equals(nombreSimple) && numParametrosFllamada == numParametrosFcompleja){
                    nombreConvertido = nombreComplejo;
                    break;
                }
            }
        }
        return nombreConvertido;
    }
    public String trocearNombreFuncionCompleto(String nombreCompleto){
        String identificadorFuncion = "";
        if(nombreCompleto.contains("(")){
            int beginIndex = 9; //todos los nombres de funciones declaradas empiezan por function + espacio
            int endIndex = nombreCompleto.indexOf("("); //el identificador acabara cuando encontremos un abrir parentesis
            identificadorFuncion = nombreCompleto.substring(beginIndex, endIndex);
        }else{
            identificadorFuncion = nombreCompleto;
        }

        return identificadorFuncion;

    }
    public String conversionNombreFuncionArgumento(String nombreFuncionSimple){
        String nombreSimpleClave = "";
        for (String key : ts.keySet()){
            nombreSimpleClave = trocearNombreFuncionCompleto(key);
            if (nombreFuncionSimple.equals(nombreSimpleClave)){
                return key;
            }
        }
        return nombreSimpleClave;
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

    public String generarGrafoLlamadasFuncion(LlamadaFuncion lf, boolean nombreSimple){
        HashMap<String, Funcion> copiaTDS = this.ts;
        String nombreFuncion = lf.getNombre();

        if (nombreSimple){                                                              //si es un nombre simple i.e main y la TDS contiene la
            if(copiaTDS.containsKey(conversionNombre(lf))) {
                nombreFuncion = conversionNombre(lf);                        //clave function main():void convierte el nombre simple
            }
            else{                                                                       //se convierte a nombrecomplejo para poder acceder a la clave
                copiaTDS.put(nombreFuncion, new Funcion());
            }                                                                           //si no, es una funcion del lenguaje y la añade vacia al HM
        }

        ArrayList<LlamadaFuncion>funcionesLlamadas = copiaTDS.get(nombreFuncion).getLlamadasFuncion();
        String capaGrafo = "";


        if (funcionesLlamadas.isEmpty() || funcionesLlamadas == null){
            return nombreValido(nombreFuncion);
        }
        else {
            for (LlamadaFuncion funcionLlamada : funcionesLlamadas){
                capaGrafo += nombreValido(nombreFuncion) + "->" + generarGrafoLlamadasFuncion(funcionLlamada, true) + "\n";
            }
            return capaGrafo;
        }

    }


}
