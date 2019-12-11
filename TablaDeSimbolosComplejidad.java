import java.util.*;

public class TablaDeSimbolosComplejidad{

    private HashMap<Integer, ArrayList<Integer>> tablaSimbolos;
    private ArrayList<Integer> valores;
    private Integer complejidad;
    
    public Integer addNewNode(){
        if(tablaSimbolos.isEmpty()){tablaSimbolos.put(1,valores);}
        tablaSimbolos.put(tablaSimbolos.size()+1,valores);
        return tablaSimbolos.size();


    }
    /*public Integer getLastNode(){
        tablaSimbolos.keySet().toArray();

    }*/
    public void addValor(Integer key, Integer valor){
        if(tablaSimbolos.get(key)!=null){
            tablaSimbolos.get(key).add(valor);
            valores=tablaSimbolos.get(key);
            tablaSimbolos.remove(key);
            tablaSimbolos.put(key,valores);
        }else {System.out.println("error");}
    }
    //TODO see codigo en visitorpropio por si hay varios hijos

}