import java.util.*;
import java.io.*;

public class Funcion{


    private String nombre;
    private int nParametros;
    private long nDeclaraciones;
    private long llamadasFuncion;
    private long nOperadoresSimples;
    private long puntosTotales;
    private long lineasEfectivas = 6;
    private ArrayList<LlamadaFuncion> LlamadasFuncion;
    private String nombreArchivo;
    private long complejidad;
    private int nodoInicial;
    private int nodoFinal;

    public Funcion(){
        this.nombre = "";
        this.nParametros = 0;
        this.nDeclaraciones = 0;
        this.llamadasFuncion = 0;
        this.nOperadoresSimples = 0;
        this.puntosTotales = 0;
        this.lineasEfectivas = 0;
        this.LlamadasFuncion = new ArrayList<LlamadaFuncion>();
        this.nombreArchivo = "";
        this.complejidad = 0;
        this.nodoInicial=1;
        this.nodoFinal=1;
    }

    public ArrayList<LlamadaFuncion> getLlamadasFuncion(){
        return this.LlamadasFuncion;
    }
    public void addParametro(long puntos)
    {
        this.nParametros += puntos;
    }
    public void addDeclaraciones(long puntos)
    {
        this.nDeclaraciones += puntos;
    }
    public void addLlamadasFuncion(long puntos)
    {
        this.llamadasFuncion += puntos;
    }
    public void addOperadorSimple(long puntos)
    {
        this.nOperadoresSimples += puntos;
    }
    public void addLineaEfectiva(long puntos)
    {
        this.lineasEfectivas += puntos;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public void setPuntosFuncion(long puntos)
    {
        this.puntosTotales = puntos;
    }
    public long getLineasEfectivas()
    {
        return this.lineasEfectivas;
    }
    public long getPuntosFuncion()
    {
        return this.puntosTotales;
    }
    public void setNombreArchivo(String archivo1){
        this.nombreArchivo=archivo1;
    }
    public void setComplejidad(int aristas,int nodos){
        this.complejidad=aristas-nodos+2;
    }
    public void setNodoInicial(int nodo){
        this.nodoInicial=nodo;
    }
    public void setNodoFinal(int nodo){
        this.nodoFinal=nodo;
    }
    public int getNodoInicial(){
        return this.nodoInicial;
    }
    public int getNodoFinal(){
        return this.nodoFinal;
    }
    public int getNumParametros(){
        return this.nParametros;
    }

    public void printAttributes(){
        System.out.println("nombre: " + this.nombre);
        System.out.println("numero de parametros: " + this.nParametros);
        System.out.println("numero de declaraciones: " + this.nDeclaraciones);
        System.out.println("numero de llamadas a funcion: " + this.llamadasFuncion);
        System.out.println("numero de operadores simples: " + this.nOperadoresSimples);
        System.out.println("Puntos Funcion: " + this.puntosTotales);
        System.out.println("Lineas efectivas: " + this.lineasEfectivas);
        System.out.println("Lista de funciones llamadas: \n");
        System.out.println("Complejidad de la funcion: " + this.complejidad);
        for (LlamadaFuncion funcion : LlamadasFuncion){
            System.out.println("\t" + funcion.getNombre());
        }
    }
    public void convertirArchivos(){

        String[] command = {
        "cmd",
        };
        Process p;
        try{
            p = Runtime.getRuntime().exec(command);

            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("dot -Tsvg "+this.nombreArchivo+".dot -o "+this.nombreArchivo+".svg");


            stdin.close();
            p.waitFor();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String writeHtml(){
      Writer output;
      String htmlLine = "";
      if (!this.nombre.equals("")){

           htmlLine = " \n <h2>" + this.nombre +"</h2>\n"
                          +"<ul>\n"
                          +"<li>Complejidad ciclomatica V(G):" +" </li>\n"
                          +"<li>Puntos funcion:<strong>" + this.puntosTotales + "</strong> </li>\n"
                          +"<li>Resumen:"
                          +"<ul>\n"
                          +"<li>Variables declaradas:<strong> "+ this.nDeclaraciones + "</strong></li>\n"
                          +"<li>Lineas de codigo efectivas:<strong> " + this.lineasEfectivas + "</strong></li>\n"
                          +"<li>Numero de parametros esperados:<strong> " + this.nParametros +"</strong></li>\n"
                          +"<li>Numero de llamadas a funciones:<strong> " + this.llamadasFuncion + "</strong></li>\n"
                          +"</ul>\n"
                          +"</li>\n"
                          +"<li>Complejidad ciclomatica de la función:<strong> "+this.complejidad +"</strong></li>\n"
                          +"<li>Grafo de complejidad ciclomatica:</li>\n"
                          +"<p><img src="+this.nombreArchivo+".svg></p>"
                          +"</ul>\n"
                          +"<hr />\n";
                      //<p><img src="fichero.svg" width="100%"/> </p>
      }
      return htmlLine;
    }
    public void addFuncionLlamada(LlamadaFuncion llamadaNueva){
        boolean contiene = false;
        for(LlamadaFuncion llamadaArray : LlamadasFuncion){
            if (llamadaArray.getNombre().equals(llamadaNueva.getNombre()) && llamadaArray.getNumeroP() == llamadaNueva.getNumeroP()){
                contiene = true;
                break;
            }
        }
        if (!contiene){
            this.LlamadasFuncion.add(llamadaNueva);
        }
        //this.LlamadasFuncion.add(llamadaNueva);
    }

}
