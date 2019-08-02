/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestClass {

	PriorityQueue queue = new PriorityQueue();
	PriorityQueue queueNegative = new PriorityQueue();
	
	@Before
	public void addToQueueTest(){
		queue.addToQueue(new Item(21, 1));
		queue.addToQueue(new Item(32, 2));
		queue.addToQueue(new Item(90, 6));
		queue.addToQueue(new Item(67, 4));
		queue.addToQueue(new Item(23, 9));
	}
	
	@Test
	public void deleteFromQueueTest(){
		assertEquals(23, queue.deleteFromQueue());
	}
	
	@Before
	public void addToQueueNegativeTest(){
		queueNegative.addToQueue(new Item(21, 1));
		queueNegative.addToQueue(new Item(32, 1));
		queueNegative.addToQueue(new Item(90, 6));
		queueNegative.addToQueue(new Item(67, 9));
		queueNegative.addToQueue(new Item(23, 9));
	}
	
	@Test
	public void deleteFromQueueNegativeTest(){
		assertEquals(67, queueNegative.deleteFromQueue());
	}
}
