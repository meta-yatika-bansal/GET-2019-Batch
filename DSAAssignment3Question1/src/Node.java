/*
 * Represents element of a tree
 */
import java.util.*;

public class Node {
	String name;
	List<Node> children = new ArrayList<Node>();
	Node parent;
	java.sql.Timestamp ts;
	
	public Node(String name){
		this.name = name;
	}
}
