/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class  TestClass {

	ReadListOfPair pair = new ReadListOfPair();
	ImplementDictionary dictionary = new ImplementDictionary(pair.readListOfPair());
	
	@Test
	public void addToDictionaryTest() {
		dictionary.add("3", "me");
	}
	
	@Test
	public void deleteFromDictionaryTest() {
		assertEquals(true, dictionary.delete("0"));
		assertEquals(false, dictionary.delete("3"));
	}
	
	@Test
	public void getValueTest() {
		assertEquals("true", dictionary.getValue("1"));
		assertEquals("null", dictionary.getValue("3"));
	}
	
	@Test
	public void sortedListTest() {
		List<Node> list = new ArrayList<Node>();
		list.add(new Node("-1", "exception"));
		list.add(new Node("0", "false"));
		list.add(new Node("1", "true"));
		list.add(new Node("2", "even"));
		assertEquals(list, dictionary.sort());
	}
	
	@Test
	public void sortedSubListTest() {
		List<Node> list = new ArrayList<Node>();
		list.add(new Node("0", "false"));
		list.add(new Node("1", "true"));
		list.add(new Node("2", "even"));
		assertEquals(list, dictionary.sortSublist("0", "2"));		
	}
}
