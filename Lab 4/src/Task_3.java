
/**
 *
 * @author ahmed_ishraq
 */
import java.util.Scanner;

public class Task_3 {

// Java program to implement Round Robin 
// Scheduling with different arrival time 
    public static void roundRobin(int p[], int a[], int b[], int q) {
        // result of average times 
        float avg_waiting_time = 0;
        float avg_turnaround_time = 0;
        float avg_ft = 0;

        // for sequence storage 
        String seq = new String();

        // copy the burst array and arrival array 
        // for not effecting the actual array 
        int rem_burst_time[] = new int[b.length];
        int rem_arrival_time[] = new int[a.length];

        for (int i = 0; i < rem_burst_time.length; i++) {
            rem_burst_time[i] = b[i];
            rem_arrival_time[i] = a[i];
        }
        
        //testing 
        int ft [] = new int[p.length];

        // critical time of system 
        int t = 0;

        // for store the waiting time 
        int waiting_time[] = new int[p.length];

        // for store the Completion time 
        int finish_time[] = new int[p.length];

        while (true) {
            boolean flag = true;
            for (int i = 0; i < p.length; i++) {

                // these condition for if 
                // arrival is not on zero 
                // check that if there come before qtime 
                if (rem_arrival_time[i] <= t) {
                    if (rem_arrival_time[i] <= q) {
                        if (rem_burst_time[i] > 0) {
                            flag = false;
                            if (rem_burst_time[i] > q) {

                                // make decrease the b time 
                                t = t + q;
                                rem_burst_time[i] = rem_burst_time[i] - q;
                                rem_arrival_time[i] = rem_arrival_time[i] + q;
                                //seq += "->" + p[i];
                            } else {

                                // for last time 
                                t = t + rem_burst_time[i];

                                // store comp time 
                                finish_time[i] = t - a[i];

                                // store wait time 
                                waiting_time[i] = t - b[i] - a[i];
                                rem_burst_time[i] = 0;

                                // add sequence 
                                //seq += "->" + p[i];
                            }
                        }
                    } else if (rem_arrival_time[i] > q) {

                        // is any have less arrival time 
                        // the coming process then execute them 
                        for (int j = 0; j < p.length; j++) {

                            // compare 
                            if (rem_arrival_time[j] < rem_arrival_time[i]) {
                                if (rem_burst_time[j] > 0) {
                                    flag = false;
                                    if (rem_burst_time[j] > q) {
                                        t = t + q;
                                        rem_burst_time[j] = rem_burst_time[j] - q;
                                        rem_arrival_time[j] = rem_arrival_time[j] + q;
                                        seq += "->" + p[j];
                                    } else {
                                        t = t + rem_burst_time[j];
                                        finish_time[j] = t - a[j];
                                        waiting_time[j] = t - b[j] - a[j];
                                        rem_burst_time[j] = 0;
                                        //seq += "->" + p[j];
                                    }
                                }
                            }
                        }

                        // now the previous porcess according to 
                        // ith is process 
                        if (rem_burst_time[i] > 0) {
                            flag = false;

                            // Check for greaters 
                            if (rem_burst_time[i] > q) {
                                t = t + q;
                                rem_burst_time[i] = rem_burst_time[i] - q;
                                rem_arrival_time[i] = rem_arrival_time[i] + q;
                                seq += "->" + p[i];
                            } else {
                                t = t + rem_burst_time[i];
                                finish_time[i] = t - a[i];
                                waiting_time[i] = t - b[i] - a[i];
                                rem_burst_time[i] = 0;
                               // seq += "->" + p[i];
                            }
                        }
                    }
                } // if no process is come on thse critical 
                else if (rem_arrival_time[i] > t) {
                    t++;
                    i--;
                }
            }
            // for exit the while loop 
            if (flag) {
                break;
            }
        }
                
        // testing 
        for(int i=0;i<p.length;i++){
            ft[i] =finish_time[i] + a[i]; 
        }
        //

        System.out.println("pid  arrival  brust  finish  turn  waiting");
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]+"\t"+a[i]+"\t"+b[i]+"\t"+ft[i]+"\t"+finish_time[i]+"\t"+waiting_time[i]);
            avg_waiting_time += waiting_time[i];
            avg_turnaround_time += finish_time[i];
            avg_ft += ft[i];
        }

         System.out.println("");
        System.out.println("Average waiting time is "
                + (float) avg_waiting_time / p.length);
         System.out.println("Average turnaround  time is "
                + (float) avg_turnaround_time / p.length);
        System.out.println("Average finish  time is "
                + (float) avg_ft / p.length);
        System.out.println("Sequence is like that " + seq);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nimber of process: ");
        int total_process = sc.nextInt();
        // name of the process 
        int pid[] = new int [total_process];

        // arrival for every process 
        int arrival_time[] = new int [total_process];

        // burst time for every process 
        int burst_time[] = new int [total_process];
        
        // taking  all input
        for(int i=0;i<total_process;i++){
            pid[i] = i+1;
            System.out.print("Process "+pid[i]+" Arival Time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Process "+pid[i]+" Burst Time: ");
            burst_time[i] = sc.nextInt();
        }

        // quantum time of each process 
        System.out.print("Time Quantum: ");
        int time_quantum = sc.nextInt();
        System.out.println("");

        // cal the function for output 
        roundRobin(pid, arrival_time, burst_time, time_quantum);
    }
}
