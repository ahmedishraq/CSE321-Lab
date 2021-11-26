package task;

/**
 *
 * @author ahmed_ishraq
 */
class CustomThread extends Thread {

    private Thread t;
    private String check;
    private int f_odd_mean = 0;
    private int f_odd_sum = 0;
    private int f_even_mean = 0;
    private int f_even_sum = 0;
    private int s_odd_mean = 0;
    private int s_odd_sum = 0;
    private int s_even_mean = 0;
    private int s_even_sum = 0;
    private int avg = 0;
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

    public CustomThread(String check){
        this.check = check;
   }
    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this, check);
            t.start();
        }
    }
    
    public void first(){
        for(int i=1;i<25;i=i+2){
            f_odd_sum += arr[i];
        }
        f_odd_mean = f_odd_sum/25;
        //System.out.println("mean:"+ mean);
    }
    
    public void second(){
        for(int i=0;i<25;i=i+2){
            f_even_sum += arr[i];
        }
        f_even_mean = f_even_sum/25;
        //System.out.println("mean:"+ mean);
    }
    
    public void third(){
        for(int i=26;i<50;i=i+2){
            s_odd_sum += arr[i];
        }
        s_odd_mean = s_odd_sum/25;
        //System.out.println("mean:"+ mean);
    }
    
    public void four(){
        for(int i=26;i<50;i=i+2){
            s_even_sum += arr[i];
        }
        s_even_mean = s_even_sum/25;
        //System.out.println("mean:"+ mean);
    }
    
    public void five(){
        avg = f_odd_mean + f_even_mean + s_odd_mean + s_even_mean;
        avg = avg/4;
        System.out.println(avg);
    }

    @Override
    public void run() {
        if(check == "first"){
            first();
        }
        else if(check == "second"){
            second();
        }
        else if(check == "third"){
            third();
        }
        else if(check == "four"){
            four();
        }
        else if(check == "five"){
            five();
        }
    }
}

public class Task3 {

    public static void main(String[] args) {
        CustomThread c1 = new CustomThread("first");
        CustomThread c2 = new CustomThread("second");
        CustomThread c3 = new CustomThread("third");
        CustomThread c4 = new CustomThread("four");
        CustomThread c5 = new CustomThread("five");
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

    }
}
