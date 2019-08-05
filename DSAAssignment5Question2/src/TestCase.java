/*
 * Test Class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestCase {
	
	ListOfEmployee list = new ListOfEmployee();
	List<String> sortedList = new ArrayList<String>();

	@Before
	public void addToListTest() {
		list.addEmployee("A", 200, 30);
		list.addEmployee("B", 500, 50);
		list.addEmployee("C", 200, 40);
	}
	
	@Test
	public void sortTest(){
		list.sort();
		sortedList.add("B");
		sortedList.add("A");
		sortedList.add("C");
		assertEquals(sortedList, list.display());
	}
}
