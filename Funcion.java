import java.util.*;

public class Funcion{

    private int nParametros;
    /**
    Encontramos una variable en asignacion o declaracion
    si su nombre(valor) se encuentra como clave en la tabla hash
    no se añade nada, si acaso podriamos poner un atributo que contabilice el numero de veces que aparece.
    Si no aparece lo añadiremos y le pondremos el tipo como valor
    */
    private HashMap<String, Tipo> variables;
    private HashMap<String, LlamadaFuncion> llamadasFuncion; //parametros y veces que se utiliza (o numero de parametros) quiza puntuacion
    private HashMap<Integer, String> operadores;
    private int puntuacion = 0;

    public Funcion(){}

    public void setNumParametros(int cantidad){
        nParametros = cantidad;
    }
}
