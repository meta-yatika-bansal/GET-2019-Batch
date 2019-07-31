/*
 * Represents Linked list 
 * Elements are assumed to be Integers
 */
public class LinkedList {
	int size = 0;
	Node head = new Node();

	/**
	 * Adds a new node to list
	 * @param value is the value of new node
	 */
	public void add(int value){
		try{
			size++;
			Node node = new Node();
			Node n;
			node.value = value;

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
	 * Rotates given Sublist in a List
	 * @param l is the leftmost position of sublist
	 * @param r is the rightmost position of sublist
	 * @param n is the number of steps
	 * @return modified list
	 */
	public int[] rotateSublist(int l, int r, int n){
		try{
			if(l > r || l < 0 || r < 0 || l > size || r > size){
				return null;
			}

			Node node;
			int number = 1;
			while(number <= n){
				int count = 0;
				for(node = head ; node.next != null ; node = node.next){
					count++;
					if(count == l){
						break;
					}
				}

				node = node.next;
				while(count != r){
					int swap ;

					swap = node.value;
					node.value = node.next.value;
					node.next.value = swap;

					node = node.next;
					count++;
				}

				number++;
			}

			return display();
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}  

	/**
	 * Displays list as array
	 * @return list as array
	 */
	private int[] display(){
		try{
			int[] array = new int[size];
			int i = 0;
			for(Node n = head ; n.next != null ; n = n.next){
				array[i] = n.next.value;
				i++;
			}

			return array;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}
