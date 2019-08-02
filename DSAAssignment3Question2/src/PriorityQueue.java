/*
 * Represents implementation of priority queue
 */
public class PriorityQueue implements Queue {
	int SIZE = 5;
	Item[] queue = new Item[SIZE];
	int f = -1;
	int r = -1;

	/**
	 * Adds an item to the queue
	 * @param item is the item to be added
	 */
	@Override
	public void addToQueue(Item element){
		if(f == -1 && r == -1){
			f = 0;
			r = 0;
			queue[r] = element;
		}else{
			if(checkIfFull()){
				System.out.println("Queue is full!");
			}

			r++;
			queue[r] = element;
		}
	}

	/**
	 * Deletes an item from the queue
	 * @return deleted item
	 */
	@Override
	public int deleteFromQueue() {
		Item item;
		int index;
		int i;
		if(checkIfEmpty()){
			System.out.println("Queue is empty!");
			return -1;
		}
		if(f == r){
			f = -1;
			r = -1;
		}
		index = search();
		item = queue[index];
		i = index;
		while(i != f){
			queue[i] = queue[i-1];
			i--;
		}
		
		return item.item;
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
		if(f == 0 && r == SIZE -1){
			return true;
		}

		return false;
	}

	/**
	 * Displays the queue
	 * @return queue
	 */
	public Item[] showQueue(){
		return queue;
	}

	/**
	 * Searches an element in queue
	 * @return index of element
	 */
	private int search(){
		int max = f;
		for(int i = f ; i <= r ; i++){
			if(queue[i].priority > queue[max].priority){
				max = i;
			}
		}

		return max;
	}
}
