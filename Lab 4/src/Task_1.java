/**
 *
 * @author ahmed_ishraq
 */
import java.util.Scanner;

public class Task_1 {
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Total number of Process: ");
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
        float avg_response_time = 0;
        
        for(int i=0;i<total_process;i++){
            pid[i] = i+1;
            System.out.print("Process "+pid[i]+" Arival Time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Process "+pid[i]+" Burst Time: ");
            System.out.println("");
            brust_time[i] = sc.nextInt();
            rem_brust_time[i] = brust_time[i];
            flag[i] = 0;
        }
        
        while(true){
            int min = 999;
            int check = total_process;
            if(tot_time == total_process){
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
            // calculation starting time for each process 
            if( check != total_process){
                if(rem_brust_time[check] == brust_time[check]-1){
                     start_time[check] = s_time - 1;
                }
            }
        }
        for(int i=0;i<total_process;i++){
            turnaround_time[i] = finish_time[i] - arrival_time[i];
            waiting_time[i] = turnaround_time[i] - brust_time[i];
            response_time[i] = start_time[i] - arrival_time[i];
            avg_waiting_time += waiting_time[i];
            avg_turnaround_time += turnaround_time[i];
            avg_response_time += response_time[i];
        }
        System.out.println("pid  arrival  brust  start  finish  response  turn  waiting");
        for(int i=0;i<total_process;i++){
            System.out.println(pid[i]+"\t"+arrival_time[i]+"\t"+brust_time[i]+"\t"+start_time[i]+"\t"+finish_time[i]+"\t"+response_time[i]+"\t"+turnaround_time[i]+"\t"+waiting_time[i]);
        }
        System.out.println("");
        System.out.println("Average Waiting Time: "+(float)avg_waiting_time/total_process);
        System.out.println("Average Turnaround Time: "+(float)avg_turnaround_time/total_process);
        System.out.println("Average Response Time: "+(float)avg_response_time/total_process);
    }
}
