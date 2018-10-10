import java.util.Scanner;
class ColaDoble{   
    public static void main(String[] args) {
        
    }

}

/**
 * Metodos
 */
public class Metodos {
    int [] queue=new int[5];

    public int push(int in, int ou, int val) {
        if(in!=ou){
            queue[ou]=val;
            in++;
            return in;
        }else{
            System.out.println("    COLA LLENA...");
            return in;
        }
    }
    
}