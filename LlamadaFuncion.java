public class LlamadaFuncion{
    private String nombre;
    private int numeroP;

    public LlamadaFuncion(){
        nombre = "";
        numeroP = 0;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNumeroP(int numP){
        this.numeroP = numP;
    }
    public int getNumeroP(){
        return this.numeroP;
    }
}
