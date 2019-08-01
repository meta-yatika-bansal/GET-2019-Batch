/*
 * Represents circular implementation of queue
 * Elements in queue are assumed to be integers
 */
public class Queue {
	int SIZE = 10;
	Student[] queue = new Student[SIZE];
	int f = -1;
	int r = -1;

	/**
	 * Adds an item to the queue
	 * @param item is the item to be added
	 */
	public void addToQueue(Student student){
		if(f == -1 && r == -1){
			f = 0;
			r = 0;
			queue[r] = student;
		}else{
			if(checkIfFull()){
				System.out.println("Queue is full!");
			}
			if( r == SIZE-1 && f!=0){
				r = 0;
			}

			r++;
			queue[r] = student;
		}
	}

	/**
	 * Deletes an item from the queue
	 * @return deleted item
	 */
	public void deleteFromQueue() {
		Student student;
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

		student = queue[f];
		f++;
	}

	/**
	 * Checks whether the queue is empty
	 */
	public boolean checkIfEmpty() {
		if(f == -1 && r == -1){
			return true;
		}

		return false;
	}

	/**
	 * Checks whether the queue is full
	 */
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
	public Student[] showQueue(){
		return queue;
	}
	
	public int size(){
		return (r-f+1);
	}
}
