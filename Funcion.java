import java.util.*;
import java.io.*;

public class Funcion{


    private String nombre;
    private int nParametros;
    private int nDeclaraciones;
    private int llamadasFuncion;
    private int nOperadoresSimples;
    private int puntosTotales;
    private int lineasEfectivas = 6;

    public Funcion(){
        this.nParametros = 0;
        this.nDeclaraciones = 0;
        this.llamadasFuncion = 0;
        this.nOperadoresSimples = 0;
        this.puntosTotales = 0;
        this.lineasEfectivas = 0;
    }

    public void addParametro(int puntos)
    {
        this.nParametros += puntos;
    }
    public void addDeclaraciones(int puntos)
    {
        this.nDeclaraciones += puntos;
    }
    public void addLlamadasFuncion(int puntos)
    {
        this.llamadasFuncion += puntos;
    }
    public void addOperadorSimple(int puntos)
    {
        this.nOperadoresSimples += puntos;
    }
    public void addLineaEfectiva(int puntos)
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
    public void setPuntosFuncion(int puntos)
    {
        this.puntosTotales = puntos;
    }
    public int getLineasEfectivas()
    {
        return this.lineasEfectivas;
    }
    public int getPuntosFuncion()
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

    public void writeHtml(){
      Writer output;
      String htmlLine = " <h2>" + this.nombre +"</h2>\n"
                      +"<ul>\n"
                      +"<li>Complejidad ciclomatica V(G):" +" </li>\n"
                      +"<li>Puntos funcion:<strong>" + this.puntosTotales + "</strong> </li>\n"
                      +"<li>Resumen:"
                      +"<ul>\n"
                      +"<li>Variables declaradas:<strong> "+ this.nDeclaraciones + "</strong></li>\n"
                      +"<li>Lineas de codigo efectivas:<strong>" + this.lineasEfectivas + "</strong></li>\n"
                      +"<li>Numero de parametros esperados:<strong>" + this.nParametros +"</strong></li>\n"
                      +"<li>Numero de llamadas a funciones:<strong>" + this.llamadasFuncion + "</strong></li>\n"
                      +"</ul>\n"
                      +"</li>\n"
                      +"<li>Grafico de complejidad ciclomatica:</li>\n"
                      +"</ul>\n"

                      +"<hr />\n";//<p><img src="fichero.svg" width="100%"/> </p>
      try{
        output = new BufferedWriter(new FileWriter("Resultado.html", true));
        output.append(htmlLine);
        output.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
}
