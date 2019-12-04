import java.util.*;

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
}
