package task;

import java.util.Scanner;

/**
 *
 * @author ahmed_ishraq
 */
class CalculationThread extends Thread {

    static Scanner sc = new Scanner(System.in);

    private Thread t;
    private String operation;
    private int a;
    private int b;
    private int addition_rst = 0;
    private int subtraction_rst = 0;
    private int multiplication_rst = 0;
    private int division_rst = 0;

    public CalculationThread(String operation) {
        this.operation = operation;
    }

    @Override
    public void start() {
        try{
        if (t == null) {
            Thread.sleep(500);
            System.out.println("User Input for operation: ");
            a = sc.nextInt();
            b = sc.nextInt();
            t = new Thread(this, operation);
            t.start();
        }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (operation == "add") {
            addition_rst = a + b;
            System.out.println("Calculation: " + operation + " of " + a + " + " + b + " = " + addition_rst + "\n");
        } else if (operation == "sub") {
            subtraction_rst = a - b;
            System.out.println("Calculation: " + operation + " of " + a + " - " + b + " = " + subtraction_rst + "\n");
        } else if (operation == "mul") {
            multiplication_rst = a * b;
            System.out.println("Calculation: " + operation + " of " + a + " * " + b + " = " + multiplication_rst + "\n");
        } else if (operation == "div") {
            division_rst = a / b;
            System.out.println("Calculation: " + operation + " of " + a + " / " + b + " = " + division_rst + "\n");
        } else {
            System.out.println("No valid operation");
        }
    }
}

public class Task1 {

    public static void main(String[] args) {
        CalculationThread add = new CalculationThread("add");
        CalculationThread sub = new CalculationThread("sub");
        CalculationThread mul = new CalculationThread("mul");
        CalculationThread div = new CalculationThread("div");
        CalculationThread oth = new CalculationThread("oth");

        add.start();
        sub.start();
        mul.start();
        div.start();
        oth.start();
    }
}
