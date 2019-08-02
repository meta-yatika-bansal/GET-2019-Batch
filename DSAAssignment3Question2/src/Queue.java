/*
 * Represents Queue
 */
public interface Queue {
	public void addToQueue(Item item);
	public int deleteFromQueue();
	public boolean checkIfEmpty();
	public boolean checkIfFull();
}
