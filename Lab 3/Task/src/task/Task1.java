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
    private int a = 10;
    private int b = 5;
    private int addition_rst = 0;
    private int subtraction_rst = 0;
    private int multiplication_rst = 0;

    public CalculationThread(String operation) {
        this.operation = operation;
        //this.a=a;
        //this.b=b;
    }

    @Override
    public void start() {
        System.out.println("Calculation of " + operation + "\n");
        if (t == null) {
            t = new Thread(this, operation);
            t.start();
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
        }
    }
}

public class Task1 {

    public static void main(String[] args) {
        CalculationThread add = new CalculationThread("add");
        CalculationThread sub = new CalculationThread("sub");
        CalculationThread mul = new CalculationThread("mul");
        
        add.start();
        sub.start();
        mul.start();
    }
}
