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
        
        String s3 = b.readLine();
        StringTokenizer st3 = new StringTokenizer(s3," ");
        int n = 0;
        while(st3.hasMoreTokens()){
            process[n] = st3.nextToken();
            n++;
        }
        for(int i=0;i<row;i++){
            String s = b.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            for(int j=0;j<column;j++){
                max[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
