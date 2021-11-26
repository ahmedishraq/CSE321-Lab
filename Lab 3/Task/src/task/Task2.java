package task;

/**
 *
 * @author ahmed_ishraq
 */

class CheckThread extends Thread{
   // private String name;
    
    public CheckThread(String name){
    super(name);
    }
    
    @Override
    public void run(){
        System.out.println("The house is: "+Thread.currentThread().getName());
    }
}


public class Task2 {
    public static void main(String [] args){
        CheckThread hs = new CheckThread("House Stark");
        CheckThread ht = new CheckThread("House Targaryen");
        CheckThread hl = new CheckThread("House Lannister");
        CheckThread hb = new CheckThread("House Bolton");
        CheckThread htl = new CheckThread("House Tyrell");
        
        hs.setPriority(Thread.MAX_PRIORITY);
        hb.setPriority(Thread.MIN_PRIORITY);
        
        hs.run();
        ht.run();
        hl.run();
        hb.run();
        
        hs.start();
        htl.start();
        hl.start();
        hb.start();
        
        try{
        hs.join();
        hl.join();
        hb.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
        if(hs.isAlive()){
            System.out.println("Not Today!");
        }
        if(!hb.isAlive()){
            System.out.println("You know nothing!");
        }
        
    }
}
