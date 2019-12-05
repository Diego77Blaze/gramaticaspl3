import java.util.*;
import java.io.*;

public class Funcion{


    private String nombre;
    private int nParametros;
    private int nDeclaraciones;
    private int llamadasFuncion;
    private int nOperadoresSimples;
    private int puntosTotales;
    private int lineasEfectivas;

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
      File archivo = new File("Resultado.html"); //Se hace en otro sitio y se le mete: <html> <head> <title>PECL3 Procesadores del lenguaje</title> </head><body> <h1>Resultados PECL3</h1>
      //Al final del archivo habrá que ponerle fin a body y a html con </body> y </html>
      Writer output;
      String html = " <h1>Resultados PECL3</h1>
                      <h2>" + this.nombre +"</h2>
                      <ul>
                      <li>Complejidad ciclomatica V(G):"+  +" </li>
                      <li>Puntos funcion:<strong>"+ this.puntosTotales +"</strong> </li>
                      <li>Resumen:
                      <ul>
                      <li>Variables declaradas:<strong>"+ this.nDeclaraciones +"</strong></li>
                      <li>Lineas de codigo efectivas:<strong>"+ this.lineasEfectivas +"</strong></li>
                      <li>Numero de parametros esperados:<strong>"+ this.nParametros +"</strong></li>
                      <li>Numero de llamadas a funciones:<strong>"+ this.llamadasFuncion +"</strong></li>
                      </ul>
                      </li>
                      <li>Grafico de complejidad ciclomatica:</li>
                      </ul>
                      <p><img src="fichero.svg" width="100%"/> </p>
                      <hr />";
      try{
        output = new BufferedWriter(new FileWriter("Resultado.html", true));
        output.append(html);
        output.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
}
