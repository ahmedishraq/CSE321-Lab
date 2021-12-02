
/**
 *
 * @author ahmed_ishraq
 */

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total number of Process: ");
        int total_process = sc.nextInt();
        int pid[] = new int[total_process];
        int arrival_time []= new int[total_process];
        int brust_time[] = new int[total_process];
        int rem_brust_time [] = new int [total_process];
        int priority[] = new int[total_process];
        int start_time[] = new int[total_process];
        int finish_time[] = new int[total_process];
        int response_time[] = new int[total_process];
        int turnaround_time[] = new int[total_process];
        int waiting_time[] = new int[total_process];
        
        float sum_waiting_time = 0;
        float sum_turnaround_time = 0;
        float avg_waiting_time = 0;
        float avg_turnaround_time = 0;

        for (int i = 0; i < pid.length; i++) {
            pid[i] = i+1;
            System.out.print("Process "+pid[i]+" Arival Time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Process "+pid[i]+" Burst Time: ");
            brust_time[i] = sc.nextInt();
            rem_brust_time[i] = brust_time[i];
            System.out.print("Process "+pid[i]+" Priority: ");
            priority[i] = sc.nextInt();
        }
        for (int i = 0; i < total_process - 1; i++) {
            for (int j = i + 1; j < total_process; j++) {
                if (priority[i] > priority[j]) {
                    // sorting priority 
                    int tmp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = tmp;
                    // sorting brust time
                    tmp = brust_time[i];
                    brust_time[i] = brust_time[j];
                    brust_time[j] = tmp;
                    // sorting process id
                    tmp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = tmp;
                    finish_time[i] = start_time[i] + brust_time[i];
                }
            }
        }
       
        start_time[0] = 0;
        finish_time [0] = brust_time[0];
        response_time[0] = start_time[0];
        turnaround_time[0] = finish_time[0];
        waiting_time[0] = turnaround_time[0] - brust_time[0];
       
         System.out.println("[Process: P"+pid[0]+"]: "+ "CT: "+finish_time[0]+" TAT: "+turnaround_time[0]+" WT: "+waiting_time[0]);
        
        for(int i=1;i<total_process;i++){
            start_time[i] = finish_time[i-1];
            finish_time[i] = finish_time[i-1] + brust_time[i];
            response_time[i] = start_time[i];
            turnaround_time[i] = finish_time[i];
            waiting_time[i] = turnaround_time[i] - brust_time[i];
            sum_waiting_time += waiting_time[i];
            sum_turnaround_time += turnaround_time[i];
             System.out.println("[Process: P"+pid[i]+"]: "+ "CT: "+finish_time[i]+" TAT: "+turnaround_time[i]+" WT: "+waiting_time[i]);
        }
        avg_waiting_time = sum_waiting_time/total_process;
        avg_turnaround_time = sum_turnaround_time/total_process;
        System.out.println("Avarage waiting time: "+ avg_waiting_time);
        System.out.println("Avarage trunaround time: "+ avg_turnaround_time);
    }
}
