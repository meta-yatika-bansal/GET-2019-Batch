/*
 * Represents circular implementation of queue
 * Elements in queue are assumed to be integers
 */
public class CircularQueue implements Queue {
	int SIZE = 5;
	int[] queue = new int[SIZE];
	int f = -1;
	int r = -1;

	/**
	 * Adds an item to the queue
	 * @param item is the item to be added
	 */
	@Override
	public void addToQueue(int item){
		if(f == -1 && r == -1){
			f = 0;
			r = 0;
			queue[r] = item;
		}else{
			if(checkIfFull()){
				System.out.println("Queue is full!");
			}
			if( r == SIZE-1 && f!=0){
				r = 0;
			}

			r++;
			queue[r] = item;
		}
	}

	/**
	 * Deletes an item from the queue
	 * @return deleted item
	 */
	@Override
	public int deleteFromQueue() {
		int item;
		if(checkIfEmpty()){
			System.out.println("Queue is empty!");
		}
		if(f == SIZE-1){
			f = 0;
		}
		if(f == r){
			f = -1;
			r = -1;
		}

		item = queue[f];
		f++;
		return item;
	}

	/**
	 * Checks whether the queue is empty
	 */
	@Override
	public boolean checkIfEmpty() {
		if(f == -1 && r == -1){
			return true;
		}

		return false;
	}

	/**
	 * Checks whether the queue is full
	 */
	@Override
	public boolean checkIfFull() {
		if((f == 0 && r == SIZE -1) || r == (f-1)%(SIZE-1)){
			return true;
		}

		return false;
	}
	
	/**
	 * Displays the queue
	 * @return queue
	 */
	public int[] showQueue(){
		return queue;
	}
}
