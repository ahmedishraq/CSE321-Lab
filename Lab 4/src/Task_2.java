
/**
 *
 * @author ahmed_ishraq
 */

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Process: ");
        int total_process = sc.nextInt();
        int pid[] = new int[total_process];
        int brust_time[] = new int[total_process];
        int priority[] = new int[total_process];
        int start_time[] = new int[total_process];
        int finish_time[] = new int[total_process];
        int response_time[] = new int[total_process];
        int turnaround_time[] = new int[total_process];
        int waiting_time[] = new int[total_process];
        int flag[] = new int[total_process];
        
        float sum_waiting_time = 0;
        float avg_waiting_time = 0;

        for (int i = 0; i < pid.length; i++) {
            pid[i] = sc.nextInt();
            brust_time[i] = sc.nextInt();
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
        
        for(int i=1;i<total_process;i++){
            start_time[i] = finish_time[i-1];
            finish_time[i] = finish_time[i-1] + brust_time[i];
            response_time[i] = start_time[i];
            turnaround_time[i] = finish_time[i];
            waiting_time[i] = turnaround_time[i] - brust_time[i];
            sum_waiting_time += waiting_time[i];
        }
        avg_waiting_time = sum_waiting_time/total_process;
        System.out.println("Avarage waiting time: "+ avg_waiting_time);
        

//        for (int i = 0; i < total_process; i++) {
//            System.out.println(pid[i] + " " + brust_time[i] + " " + priority[i] + " " + start_time[i] + " " + finish_time[i]);
//        }
    }
}
