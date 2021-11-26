package task;

/**
 *
 * @author ahmed_ishraq
 */
class CustomThread extends Thread {

    private Thread t;
    private String check;
    private int mean = 0;
    private int sum = 0;
    //private long arr [] = new long[51];
    int arr[] = new int [50];

    public void fib() {
        //int arr[] = new int[50];
        int n = 50, first = 0, next = 1;
        System.out.print("The first " + n + " Fibonacci numbers are: ");
        arr[0] = 0;
        arr[1] = 1;
        int j = 2;
        for (int i = 1; i <= n - 2; ++i) {
            int sum = first + next;
            first = next;
            next = sum;
            arr[j] = sum;
            j++;
        }

        for (int i = 0; i < 50; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // private int n = 50;
//    public CustomThread(String check){
//        this.check = check;
//    }
    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this, check);
            t.start();
        }
    }
    
    public void first(){
        for(int i=1;i<50;i=i+2){
            sum += arr[i];
        }
        mean = sum/(arr.length/2);
        System.out.println("mean:"+ mean);
    }

    @Override
    public void run() {
        if(check == "first"){
            
        }
    }
}

public class Task3 {

    public static void main(String[] args) {
        CustomThread c1 = new CustomThread();
        c1.fib();
        c1.first();

    }
}
