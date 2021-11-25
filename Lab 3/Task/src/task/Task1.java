package task;
import java.util.Scanner;

/**
 *
 * @author ahmed_ishraq
 */


class CalculationThread extends Thread{
    
    static Scanner sc = new Scanner(System.in);
    
    private Thread t;
    private String operation;
    private int a;
    private int b;
    private int addition_rst = 0;
    private int subtraction_rst = 0;
    private int multiplication_rst = 0;
    
    public CalculationThread(String operation, int a, int b){
        this.operation = operation;
        this.a=a;
        this.b=b;
    }
    
    @Override
    public void start(){
        System.out.println("Calculation of "+operation+"\n");
        if(t == null){
            t = new Thread(this, operation);
            t.start();
        }
    }
    
    @Override
    public void run(){
        
    }
}



public class Task1 {
    public static void main(String [] args){
      
    }
}
