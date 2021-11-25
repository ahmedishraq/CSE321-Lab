package task;
import java.util.Scanner;

/**
 *
 * @author ahmed_ishraq
 */

class MyThread implements Runnable{
    
    
//    public MyThread(String name){
//        super(name);
//    }
    
    @Override
    public void run(){
        //System.out.println("Hello World");
        System.out.println("Current Thread name is: "+ Thread.currentThread().getName()+" "+"Enter your input");
    }
}



public class Task1 {
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        
        //MyThread myThread1 = new MyThread("add");
//        MyThread myThread2 = new MyThread("sub");
//        MyThread myThread3 = new MyThread("mul");
//        MyThread myThread4 = new MyThread("div");
//        MyThread myThread5 = new MyThread("oth");

        Thread add = new Thread(new MyThread(){
            @Override
            public void run(){
            //System.out.println("HI");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int rst = a + b;
            System.out.println("Addition result is: "+rst);
            }
        });
        add.start();
        
        Thread sub = new Thread(new MyThread(){
            @Override
            public void run(){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int rst = a - b;
                System.out.println("Subtraction result is: "+rst);
            }
        });
        sub.start();
        //a = sc.nextInt();
        //b = sc.nextInt();
        
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();
    }
}
