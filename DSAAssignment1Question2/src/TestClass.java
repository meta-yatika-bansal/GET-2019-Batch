/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestClass {

	LinkedList2 list = new LinkedList2();
	LinkedList2 list2 = new LinkedList2();

	@Before
	public void addTestLoop(){
		Node n = new Node(4);
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(n);
		list.add(new Node(5));
		list.add(new Node(6));
		list.add(new Node(7));
		list.add(n);
	}
	
	@Before
	public void addTestNoLoop(){
		list2.add(new Node(2));
		list2.add(new Node(3));
		list2.add(new Node(4));
		list2.add(new Node(5));
		list2.add(new Node(6));
		list2.add(new Node(7));
	}
	
	@Test
	public void loopExistTest(){
		assertEquals(true, list.loopExists());
	}
	
	@Test
	public void loopNotExistTest2(){
		assertEquals(false, list2.loopExists());
	}
}
