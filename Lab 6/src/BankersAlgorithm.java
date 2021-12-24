/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;
import java.util.*;

public class BankersAlgorithm {
    public static void main(String [] args)throws Exception{
        BufferedReader b = new BufferedReader(new FileReader("bankers.txt"));
        int row = Integer.parseInt(b.readLine());
        int column = Integer.parseInt(b.readLine());
        String [] process = new String [row];
        int [][] max = new int [row][column];
        int [][] allocation = new int [row][column];
        int [][] need = new int [row][column];
        int [][] available = new int[row+1][column];
        
        LinkedList<Integer> track = new LinkedList<Integer>();
    }
}
