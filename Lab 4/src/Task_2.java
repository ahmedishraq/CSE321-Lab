
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
        int arrival_time[] = new int[total_process];
        int brust_time[] = new int[total_process];
        int rem_brust_time[] = new int[total_process];
        int priority[] = new int[total_process+1];
        int start_time[] = new int[total_process];
        int finish_time[] = new int[total_process];
        int response_time[] = new int[total_process];
        int turnaround_time[] = new int[total_process];
        int waiting_time[] = new int[total_process];
         int i, j, smallest, count = 0, time, end;
        float avg = 0;
        float tt = 0;
        
        for (i = 0; i < pid.length; i++) {
            pid[i] = i + 1;
            System.out.print("Process " + pid[i] + " Arival Time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Process " + pid[i] + " Burst Time: ");
            brust_time[i] = sc.nextInt();
            rem_brust_time[i] = brust_time[i];
            System.out.print("Process " + pid[i] + " Priority: ");
            priority[i] = sc.nextInt();
        }
        System.out.println("yessssssss"+ priority[3]);

        priority[total_process] = 10000;
        for (time = 0; count != total_process; time++) {
            smallest = total_process;
            for (i = 0; i < total_process; i++) {
                if (arrival_time[i] <= time && priority[i] < priority[smallest] && brust_time[i] > 0) {
                    smallest = i;
                }
            }
            brust_time[smallest] --;
            if (brust_time[smallest] == 0) {
                count++;
                end = time + 1;
                finish_time[smallest] = end;
                waiting_time[smallest] = end - arrival_time[smallest] - rem_brust_time[smallest];
                turnaround_time[smallest] = end - arrival_time[smallest];
            }
        }
        
        for(i=0;i<total_process;i++){
            avg += waiting_time[i];
            tt += turnaround_time[i];
        }

        System.out.println("");
        System.out.println("pid  arrival  brust  priority  finish  turn  waiting");
        for (i = 0; i < total_process; i++) {
            System.out.println(pid[i] + "\t" + arrival_time[i] + "\t" + rem_brust_time[i] + "\t"+ priority[i] +"\t"+ finish_time[i] +"\t" + turnaround_time[i] + "\t" + waiting_time[i]);
        }
        System.out.println("");
        System.out.println("Average Waiting Time: " + (float) avg / total_process);
        System.out.println("Average Turnaround Time: " + (float) tt / total_process);
    }
}
