/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCase {

	@Test
	public void quickSortTest() {
		QuickSortLinkedList linkedList =  new QuickSortLinkedList();
		Node node1 = new Node(40);
		Node node2 = new Node(3);
		Node node3 = new Node(10);
		Node node4 = new Node(20);
		Node node5 = new Node(7);
		Node node6 = new Node(4);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		linkedList.setStart(node1);

		Node result = linkedList.quickSort(node1, node6);
		String stringRepresentation = linkedList.createStringRepresentation(result);
		assertEquals("3,4,7,10,20,40,", stringRepresentation);
	}
}