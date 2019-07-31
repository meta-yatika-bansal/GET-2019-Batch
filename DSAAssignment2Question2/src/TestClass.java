/*
 * Test Class
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestClass {

	CircularQueue queue = new CircularQueue();
	CircularQueue queue1 = new CircularQueue();
	
	@Before
	public void addTest(){
		int[] array = {2, 3, 4, 5, 6};
		queue.addToQueue(2);
		queue.addToQueue(3);
		queue.addToQueue(4);
		queue.addToQueue(5);
		queue.addToQueue(6);
		assertArrayEquals(array, queue.showQueue());
		assertEquals(true, queue.checkIfFull());
	}
	
	@Test
	public void deleteTest(){
		assertEquals(2, queue.deleteFromQueue());
	}
	
	@Test
	public void checkIfEmpty(){
		assertEquals(true, queue1.checkIfEmpty());
	}
}
