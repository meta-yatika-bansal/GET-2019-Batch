/*
 * Represents Tree
 */
import java.util.*;

public class Tree {
	String indicator = "R:";
	Node root = new Node("R");
	Node current = root;
	Node searchedNode;

	/**
	 * Adds directory to tree
	 * @param name of the directory
	 */
	public void addNode(String name){
		try{
			if(search(root, name)){
				System.out.println("Directory already exists!");
			}else{
				Node n = new Node(name);
				current.children.add(n);
				n.parent = current;
				n.ts = new java.sql.Timestamp(new Date().getTime());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Changes the directory
	 * @param name of the directory
	 */
	public void changeCurrent(String name){
		try{
			if(search(root, name)){
				indicator = indicator + "\\" + name ;
				current = searchedNode;
			}else{
				System.out.println("Directory doesn't exist!");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Finds a directory
	 * @param name of the directory
	 */
	public void find(String name){
		try{
			Node node = current;
			if(search(node, name)){
				String string = searchedNode.name;
				searchedNode = searchedNode.parent;
				string = searchedNode.name + "\\" + string;
				System.out.println(string);
			}else{
				System.out.println("Directory doesn't exist!");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Searches a directory
	 * @param node is the current directory
	 * @param name of the directory
	 * @return true or false accordingly
	 */
	public boolean search( Node node, String name){
		try{
			if("null".equals(node.children)){
				return false;
			}
			for(Node i : node.children){
				if(name.equals(i.name)){
					searchedNode = i;
					return true;   
				}else{
					if(search(i, name)){
						return true;
					}
				}
			}

			return false;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Traversal of tree
	 * @param node is the root directory
	 */
	public void breadthFirstTraversal(Node node){
		try{
			System.out.printf("  ");
			if("null".equals(node.children)){
				System.out.println();
				return;
			}
			for(Node i : node.children){
				System.out.println("\u2514" + i.name);
				breadthFirstTraversal(i);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Moves back to parent
	 */
	public void moveToParent(){
		try{
			indicator = indicator.replaceFirst(current.name, "");
			current = current.parent;
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Displays list of all subdirectory
	 */
	public void listOfAllChildren(){
		try{
			if("null".equals(current.children)){
				System.out.println(0);
			}
			System.out.println(current.children.size());
			for(Node n : current.children){
				System.out.println(n.name + " " + n.ts);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
