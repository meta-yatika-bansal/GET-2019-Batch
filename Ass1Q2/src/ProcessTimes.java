
/**Calculates different times for each process*/
public class ProcessTimes {
	
	/**
	 * Defines id for each process
	 * @param numberOfProcess total number of processes.
	 * @return id for each process.
	 */
	public int[] ProcessId(int numberOfProcess){
		int processId[]= new int[numberOfProcess];
	    for(int i = 0 ; i < numberOfProcess ; i++){
	        processId[i] = i+1 ;
	    }
	    return processId;
	}
	
	/**
	 * Separates arrival time of each process from input array.
	 * @param numberOfProcess 
	 * @param processArray input array passed.
	 * @return arrival time of each process.
	 */
	public int[] ArrivalTime(int[][]processArray,int numberOfProcess ){
		int arrivalTime[]= new int[numberOfProcess];
		for(int i=0;i<numberOfProcess;i++){
			arrivalTime[i] = processArray[i][0];
		}
		return arrivalTime;
	}
	
	/**
	 * Separates burst time of each process from input array.
	 * @param numberOfProcess 
	 * @param processArray
	 * @return burst time of each process.
	 */
	public int[] BurstTime(int[][]processArray,int numberOfProcess ){
		int burstTime[]= new int[numberOfProcess];
		for(int i=0;i<numberOfProcess;i++){
			burstTime[i] = processArray[i][1];
		}
		return burstTime;
	}
	
	/**
	 * Sorts burst time and id in order of arrival time.
	 * @param arrivalTime 
	 * @param burstTime 
	 * @param processId 
	 * @param numberOfProcess 
	 */
	public void Sort(int[] arrivalTime,int[] burstTime,int[]processId,int numberOfProcess){
		for(int i=0;i<numberOfProcess-1;i++){
			for(int j = 0;j<numberOfProcess-i-1;j++){
				if(arrivalTime[j] > arrivalTime[j+1]){
					Swap(arrivalTime[j] , arrivalTime[j+1]);
					Swap(burstTime[j] , burstTime[j+1]);
					Swap(processId[j] , processId[j+1]);
				}
			}
		}
	}
	
	/**
	 * Function to swap
	 * @param swapVariable1 
	 * @param swapVariable2
	 */
	public void Swap(int swapVariable1 , int swapVariable2){
	    int swapVariable = swapVariable1;
	    swapVariable1 = swapVariable2;
	    swapVariable2 = swapVariable;
	}
	
	/**
	 * Finds the completion time for each process.
	 * @param arrivalTime 
	 * @param burstTime
	 * @param numberOfProcess
	 * @return completion time for each process.
	 */
    public int[] CompletionTime(int[]arrivalTime,int[]burstTime,int numberOfProcess){
    	int[]completionTime=new int[numberOfProcess];
    	for(int i=0;i<numberOfProcess;i++){
    		if(i == 0) {
    			completionTime[0] = burstTime[0]+arrivalTime[0];
    		}
    		else {
    		    if(arrivalTime[i]<= completionTime[i-1]){
    		        completionTime[i] = completionTime[i-1]+burstTime[i]+arrivalTime[0];	
    		    }else{
    			    completionTime[i] = arrivalTime[i]+burstTime[i];
    		    }
    	    }
        }
    	return completionTime;
    }
    
    /**
     * Finds Turn Around time for each process
     * @param completionTime
     * @param arrivalTime
     * @param numberOfProcess
     * @return Turn Around time for each process.
     */
    public int[] TurnAroundTime(int[]completionTime,int[] arrivalTime,int numberOfProcess){
    	int[] turnAroundTime=new int[numberOfProcess];
    	for(int i=0;i<numberOfProcess;i++){
    		turnAroundTime[i] = completionTime[i] - arrivalTime[i];
    	}
    	return turnAroundTime;
    }
    
    /**
     * Finds waiting time for each process.
     * @param turnAroundTime
     * @param burstTime
     * @param numberOfProcess
     * @return waiting time for each process
     */
    public int[] WaitingTime(int[]turnAroundTime,int[] burstTime,int numberOfProcess){
    	int[] waitingTime=new int[numberOfProcess];
    	for(int i=0;i<numberOfProcess;i++){
    		waitingTime[i] = turnAroundTime[i] - burstTime[i];
    	}
    	return waitingTime;
    }
    
    /**
     * Finds average waiting time of processes.
     * @param waitingTime
     * @param numberOfProcess
     * @return average waiting time of processes.
     */
    public int AverageWaitingTime(int[] waitingTime,int numberOfProcess){
    	int sumWaitingTime = 0;
    	int averageWaitingTime;
    	for(int i=0;i<numberOfProcess;i++){
    		sumWaitingTime += waitingTime[i];
    	}
    	averageWaitingTime = (sumWaitingTime/numberOfProcess) ;
    	return averageWaitingTime;
    }
    
    /**
     * Finds maximum waiting time among all processes.
     * @param waitingTime
     * @param numberOfProcess
     * @return maximum waiting time.
     */
    public int MaximumWaitingTime(int[] waitingTime,int numberOfProcess){
    	int[] wt= new int[numberOfProcess];
    	wt=waitingTime;
    	int assumedMaxTime = waitingTime[0];
    	for(int i =0;i<numberOfProcess;i++){
    	    if(wt[i] > assumedMaxTime){
    	    	assumedMaxTime=wt[i];
    	    }
         }
    	return assumedMaxTime;
     }
}