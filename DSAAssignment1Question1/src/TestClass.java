/*
 * Test Class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestClass {
	
	LinkedList list = new LinkedList();

	@Before
	public void addTest(){
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
	}

	@Test
	public void rotateSublistPositiveTest(){
		int[] array = {2, 5, 6, 3, 4, 7};
		assertArrayEquals(array, list.rotateSublist(2, 5, 2));
	}
	
	@Test
	public void rotateSublistNegativeTest(){
		assertArrayEquals(null, list.rotateSublist(10, 5, 2));
	}
}
