package threadintro;

/**
 *
 * @author ahmed_ishraq
 */

class MyThread extends Thread{
    
    @Override
    public void run(){
        System.out.println("Hello World");
        System.out.println("Current Thread name is: "+ Thread.currentThread().getName());
    }
}

public class ThreadTest2 {
    public static void main(String [] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
