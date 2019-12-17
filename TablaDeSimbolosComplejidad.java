import java.util.*;

public class TablaDeSimbolosComplejidad{

    private HashMap<Integer, ArrayList<Integer>> tablaSimbolos;
    private TablaDeSimbolos ts;

    public TablaDeSimbolosComplejidad(){

        this.tablaSimbolos= new HashMap<Integer, ArrayList<Integer>>();
    }
    public void emptyTabla(){
        this.tablaSimbolos.clear();
    }

    public Integer addNewNode(){
        ArrayList<Integer> valores=new ArrayList<>();
        if(tablaSimbolos.isEmpty()){
            tablaSimbolos.put(1,valores);
            return tablaSimbolos.size();
        }else{
            int valor=tablaSimbolos.size()+1;
            tablaSimbolos.put(valor,valores);}
            return tablaSimbolos.size()+1;
    }

    public void addValor(Integer key, Integer valor){
        ArrayList<Integer> valores=new ArrayList<>();
            valores=tablaSimbolos.get(key);
            tablaSimbolos.remove(key);
            valores.add(valor);
            tablaSimbolos.put(key,valores);
    }
    public HashMap getTablaSimbolosComplejidad(){

        return this.tablaSimbolos;
    }

}
