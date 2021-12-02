/**
 *
 * @author ahmed_ishraq
 */
import java.util.Scanner;

public class Task_1 {
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        
        int total_process = sc.nextInt();
        int pid [] = new int [total_process];
        int arrival_time [] = new int [total_process];
        int brust_time [] = new int [total_process];
        int rem_brust_time [] = new int [total_process];
        int start_time [] = new int [total_process];
        int finish_time [] = new int [total_process];
        int response_time [] = new int [total_process];
        int turnaround_time [] = new int [total_process];
        int waiting_time [] = new int [total_process];
        int flag [] = new int [total_process];
        
        int s_time = 0;
        int tot_time= 0;
        float avg_waiting_time = 0;
        float avg_turnaround_time = 0;
        
        for(int i=0;i<total_process;i++){
            pid[i] = i+1;
            arrival_time[i] = sc.nextInt();
            brust_time[i] = sc.nextInt();
            rem_brust_time[i] = brust_time[i];
            flag[i] = 0;
        }
        
        while(true){
            int min = 999;
            int check = total_process;
            if(tot_time == 0){
                break;
            }
            for(int i=0;i<total_process;i++){
                if(arrival_time[i] <= s_time && flag[i] == 0 && rem_brust_time[i] < min){
                    min = rem_brust_time[i];
                    check = i;
                }
            }
            if(check == total_process){
                s_time++;
            }
            else{
                rem_brust_time[check] --;
                s_time++;
                if(rem_brust_time[check] == 0){
                    finish_time[check] = s_time;
                    flag[check] = 1;
                    tot_time++;
                }
            }
        }
//        for(int i=0;i<total_process;i++){
//            System.out.println("avgtime: "+waiting_time[i]);
//        }
    }
}
