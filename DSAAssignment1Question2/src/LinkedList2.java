/*
 * Represents Linked list 
 * Elements are assumed to be Integers
 */
public class LinkedList2 {
	Node head = new Node(0);

	/**
	 * Adds a node to list
	 * @param node is the node to be added
	 */
	public void add(Node node){
		try{
			Node n;

			if(head == null){
				head.next = node;
			}else{
				for(n = head ; n.next != null ; n = n.next){}
				n.next = node;
			}	
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Checks whether loop exists in given list or not
	 * @return true or false accordingly
	 */
	public boolean loopExists(){
		try{
			Node n = head;
			Node n1 = n;
			Node n2 = n;

			while (n2.next != null){
				n1 = n1.next;
				n2 = n2.next.next;
				if(n1.value == n2.value){
					return true;
				}
			}

			return false;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}