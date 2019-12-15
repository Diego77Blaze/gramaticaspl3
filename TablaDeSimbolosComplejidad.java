import java.util.*;

public class TablaDeSimbolosComplejidad{

    private HashMap<Integer, ArrayList<Integer>> tablaSimbolos;
    
    private Integer complejidad;
    
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
            System.out.println("nodo 1 creado");
            return tablaSimbolos.size();
        }else{
            int valor=tablaSimbolos.size()+1;
        tablaSimbolos.put(valor,valores);
        System.out.println("nodo "+(tablaSimbolos.size()+1)+" creado");}
        return tablaSimbolos.size()+1;


    }
    
    public void addValor(Integer key, Integer valor){
        ArrayList<Integer> valores=new ArrayList<>();
        if(tablaSimbolos.get(key)!=null){
            
            valores=tablaSimbolos.get(key);
            tablaSimbolos.remove(key);
            valores.add(valor);
            tablaSimbolos.put(key,valores);
            //System.out.println("actualizada entrada");
        }/*else {            
            valores.add(valor);
            this.tablaSimbolos.put(key,valores);
            //System.out.println("nueva entrada");
        }*/
    }
    public HashMap getTablaSimbolosComplejidad(){

        return this.tablaSimbolos;
    }

}