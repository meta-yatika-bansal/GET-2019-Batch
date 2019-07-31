/*
 * Represents Queue
 */
public interface Queue {
	public void addToQueue(int item);
	public int deleteFromQueue();
	public boolean checkIfEmpty();
	public boolean checkIfFull();
}
