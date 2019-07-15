/*
 * Scheduling of jobs in FCFS manner. 
 * Input is the number jobs,arrival time and burst time.
 * Output is completion time,turn around time and waiting time of process.
 */

import java.util.*;

/**Responsible for reading input and printing output*/
public class JobScheduler {

	public static void main(String[] args) {
		int totalProcess;
		int[][] inputArray;
		Scanner sc= new Scanner(System.in);
		ProcessTimes process=new ProcessTimes();

		try {
			System.out.println("Please Enter the number of processes for scheduling");
			totalProcess = sc.nextInt();
			if(totalProcess>0) {

				inputArray = new int[totalProcess][2];
				System.out.println("Enter the Arrival Time and Burst Time of processes ");
				for(int i=0 ; i< totalProcess ; i++){
					for(int j=0 ; j< 2 ; j++){
						inputArray[i][j] = sc.nextInt();
					}
				}
				sc.close();

				for(int i=0 ; i< totalProcess ; i++){
					for(int j=0 ; j< 2 ; j++){
						if(inputArray[i][j]<0) {
							throw new Exception();
						}
					}
				}

				int[] processId = process.ProcessId(totalProcess);
				int[] arrivalTime = process.ArrivalTime(inputArray, totalProcess);
				int[] burstTime = process.BurstTime(inputArray, totalProcess);
				process.Sort(arrivalTime, burstTime, processId, totalProcess);
				int[] completionTime = process.CompletionTime(arrivalTime, burstTime, totalProcess);
				int[] turnAroundTime=process.TurnAroundTime(completionTime, arrivalTime, totalProcess);
				int[] waitingTime = process.WaitingTime(turnAroundTime, burstTime, totalProcess);
				int averageWaitingTime = process.AverageWaitingTime(waitingTime, totalProcess);
				int maximumWaitingTime= process.MaximumWaitingTime(waitingTime, totalProcess);

				for(int i = 0;i<totalProcess;i++) {
					System.out.println("Process "+processId[i]);
					System.out.println("Completion Time "+completionTime[i]);
					System.out.println("TurnAround Time "+turnAroundTime[i]);
					System.out.println("Waiting Time "+waitingTime[i]);
				}
				System.out.println("Average Waiting Time "+averageWaitingTime);
				System.out.println("Maximum Waiting Time "+maximumWaitingTime);
			}else {
				System.out.println("Enter a positive integer");
			}
		}catch(Exception e) {
			System.out.println("Enter a positive integer");
		}
	}
}