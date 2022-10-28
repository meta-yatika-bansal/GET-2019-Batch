/*
 * Represents Node of Binary Search Tree
 */
public class Node {
	String key;
	String value;
	Node left;
	Node right;
	
	public Node(){}
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
