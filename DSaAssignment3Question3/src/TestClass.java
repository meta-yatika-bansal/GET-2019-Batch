/*
 * Test Class
 */
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestClass {
	
	int NUMBER = 5;
	int QUOTA_VIRAT = 4;
	Heap heap = new Heap(5);
	
	@Test
	public void addTest(){
		Bowler[] bowler = new Bowler[5];
		bowler[0] = new Bowler("A", 1);
		bowler[0] = new Bowler("B", 2);
		bowler[0] = new Bowler("C", 3);
		bowler[0] = new Bowler("D", 4);
		bowler[0] = new Bowler("E", 1);
		heap.add(bowler);
	}
	
	@Test
	public void getBowlerWithMaxRunTest(){
		List<String> list = new ArrayList<String>();
		list.add("D");
		list.add("D");
		list.add("C");
		list.add("C");
		assertEquals(list, heap.removeMax(QUOTA_VIRAT));
	}
}
