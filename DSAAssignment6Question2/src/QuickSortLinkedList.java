/*
 * Implements Quick Sort
 */
public class QuickSortLinkedList extends AbstractLinkedList {

	/**
	 * Sorts the list
	 * @param start node
	 * @param end node
	 * @return start/end node of segments
	 */
	public Node quickSort(Node start, Node end){
		try{
			if(start == null || start.getNext() == null || start == end){
				return start;
			}

			Node[] result = partition(start, end);
			Node resultLeft = null; 

			if(result[0] != null) {
				resultLeft = quickSort(result[0], result[1]);
			}

			Node resultRight = null; 
			if(result[3] != null){
				resultRight = quickSort(result[3], result[4]);
			}

			if(resultRight !=null) {
				result[2].setNext(resultRight);
			}

			if(resultLeft == null){
				return result[2];
			}else{
				return  resultLeft;
			}
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}

	/**
	 * partitions the list
	 * @param start
	 * @param end
	 * @return Array of nodes
	 */
	private Node[] partition (Node start, Node end){    
		try{
			Node pivot = end;       
			Node tail = end;    
			Node newStart = null;      
			Node current = start;
			Node previous = null;  
			boolean isFirstNodeWithoutMove = true;

			while(current != null && current != end){
				Node next = current.getNext();    
				if(current.getValue() > pivot.getValue()){ 
					moveNodeToEnd(current, previous, tail); 
					tail = tail.getNext();
				}else{
					if(isFirstNodeWithoutMove){
						newStart = current;
						isFirstNodeWithoutMove = false;
					}
					if(previous != null){
						previous.setNext(current);
					}

					previous = current;
				}

				current = next;
			}

			Node[] result = new Node[5];
			result[0] = newStart;
			result[1] = previous;
			result[2] = pivot;
			result[3] = pivot.getNext();
			result[4] = tail;
			return result;
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}

	/**
	 * Moves a node to end
	 * @param current node
	 * @param previous node
	 * @param tail node
	 */
	private void moveNodeToEnd(Node current, Node previous, Node tail) {
		try{
			if(previous != null){
				previous.setNext(current.getNext());
			}

			current.setNext(null);
			tail.setNext(current);
		}catch(Exception e){
			System.out .println(e);
		}
	}
}