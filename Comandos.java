import java.io.*;
public class Comandos{
    public static void main(String[] args){
        String[] command = {
            "cmd",
        };
        Process p;
        try{
            p = Runtime.getRuntime().exec(command);

            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("dot -Tsvg grafo"+ num +".dot -o myDemo_dot.svg");

            stdin.close();
            p.waitFor();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
