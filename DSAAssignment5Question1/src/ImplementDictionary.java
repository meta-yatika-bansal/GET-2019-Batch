/*
 * Implements Dictionary as Binary Search Tree
 */
import java.util.*;

public class ImplementDictionary implements Dictionary {

	Node root ;
	Node current;
	List<Node> list = new ArrayList<Node>();

	public ImplementDictionary(Map<String, String> input){
		for(Map.Entry<String, String> m : input.entrySet()) {
			add(m.getKey(), m.getValue());
		}
	}

	/**
	 * Adds a pair to dictionary
	 * @param key of pair
	 * @param value of pair
	 */
	@Override
	public void add(String key, String value){
		root = addRec(key, value, root);
	}
	
	/**
	 * Adds a pair to dictionary
	 * @param key of pair
	 * @param value of pair
	 * @param current is the current node
	 * @return Node
	 */
	private Node addRec(String key, String value, Node current) {
		if(current == null) {
			current = new Node(key, value);
			System.out.println(current.key + " " + current.value);
			return current;
		}else {
			if(key.compareTo(current.key) < 0) {
				System.out.println("left" +key);
				current = current.left;
			}else {
				System.out.println("right" +key);
				current = current.right;
			}

			return addRec(key, value, current);
		}
	}

	/**
	 * Deletes a pair from dictionary
	 * @param key of pair to be deleted
	 * @return true or false accordingly
	 */
	@Override
	public boolean delete(String key) {
		Node node = search(root, key);
		if(node != null){
			node = node.right.left;
			node.right.left = null;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Gets Value of a given key
	 * @param key of pair
	 * @return value corresponding to key
	 */
	@Override
	public String getValue(String key) {
		if(search(root, key) != null) {
			return search(root, key).value;
		}

		return null;
	}

	/**
	 * Sorts the list
	 * @return sorted list
	 */
	@Override
	public List<Node> sort() {
		traversal(root);
		return list;
	}

	/**
	 * Sorts SubList 
	 * @param K1 is the first index;
	 * @param K2 is the last index;
	 * @return sorted SubList
	 */
	@Override
	public List<Node> sortSublist(String K1, String K2) {
		List<Node> sublist = new ArrayList<Node>();
		traversal(root);
		int i = 0;
		if(list.get(i).key == K1) {
			while(K2.compareTo(list.get(i).key) >= 0) {
				sublist.add(list.get(i));
				i++;
			}
		}else {
			i++;
		}

		return sublist;
	}

	/**
	 * Searches given pair
	 * @param search is the node
	 * @param key to be searched
	 * @return resultant node
	 */
	private Node search(Node search ,String key) {
		if(search == null) {
			return null;
		}else if(search.key == key) {
			return search;
		}else {
			if(key.compareTo(search.key) > 0) {
				search = search.right;
			}else {
				search = search.left;
			}

			return search(search, key);
		}
	}

	/**
	 * Traverses the list
	 * @param node is the starting node i.e root
	 */
	private void traversal(Node node) {
		if(node == null) {
			return;
		}else{
			traversal(node.left);
			list.add(node);
			traversal(node.right);
			return;
		}
	}
}
