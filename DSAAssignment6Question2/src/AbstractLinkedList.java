/*
 * Abstract implementation of singly linked list
 */
public class AbstractLinkedList {
	private Node start;

	public void setStart(Node start) {
		this.start = start;
	}

	/**
	 * Creates string representing the sequence of the content of the list delimited by comma
	 * @param start node
	 */
	public String createStringRepresentation(Node start){
		try{
			Node currentNode = start;
			StringBuilder toPrint = new StringBuilder();
			while(currentNode != null){
				toPrint.append(currentNode.getValue() + ",");
				currentNode = currentNode.getNext();
			}

			return toPrint.toString();
		}catch(Exception e){
			System.out .println(e);
			return null;
		}
	}
}