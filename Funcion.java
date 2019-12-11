import java.util.*;
import java.io.*;

public class Funcion{


    private String nombre;
    private long nParametros;
    private long nDeclaraciones;
    private long llamadasFuncion;
    private long nOperadoresSimples;
    private long puntosTotales;
    private long lineasEfectivas = 6;

    public Funcion(){
        this.nParametros = 0;
        this.nDeclaraciones = 0;
        this.llamadasFuncion = 0;
        this.nOperadoresSimples = 0;
        this.puntosTotales = 0;
        this.lineasEfectivas = 0;
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

    public void printAttributes(){
        System.out.println("nombre: " + this.nombre);
        System.out.println("numero de parametros: " + this.nParametros);
        System.out.println("numero de declaraciones: " + this.nDeclaraciones);
        System.out.println("numero de llamadas a funcion: " + this.llamadasFuncion);
        System.out.println("numero de operadores simples: " + this.nOperadoresSimples);
        System.out.println("Puntos Funcion: " + this.puntosTotales);
        System.out.println("Lineas efectivas: " + this.lineasEfectivas);
    }

    public String writeHtml(){
      Writer output;
      String htmlLine = " \n <h2>" + this.nombre +"</h2>\n"
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
                      +"<li>Grafo de complejidad ciclomatica:</li>\n"
                      +"</ul>\n"
                      +"<hr />\n";
                      //<p><img src="grafo"+ num +.svg" width="100%"/> </p>

      return htmlLine;
    }
}
