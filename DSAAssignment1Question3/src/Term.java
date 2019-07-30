/*
 * Represents structure of each term
 * Coefficient of each term is assumed to be Integer
 */
class Node{
	int coefficient;
	Variable var = new Variable();
	Node next;
}

/*
 * Represents list of terms
 */
public class Term {
	Node head = new Node();

	/**
	 * Adds a term to list of terms
	 * @param coefficient is the coefficient of term
	 * @param variable is the type of variable in the term
	 * @param exponent is the power of variable
	 */
	public void addTerm(int coefficient, char[] variable, int[] exponent){
		try{
			Node node = new Node();
			Node n;
			node.coefficient = coefficient;

			if(head == null){
				head.next = node;
			}else{
				for(n = head ; n.next != null ; n = n.next){}
				n.next = node;
			}	

			for(int i = 0 ; i < variable.length ; i++){
				node.var.addVariable(variable[i], exponent[i]);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Calculates degree of polynomial
	 * @return degree
	 */
	public int degree(){
		try{
			int tempDegree;
			int degree = 0;
			for(Node n = head ; n.next != null ; n = n.next){
				tempDegree = n.var.sumOfExponent();

				if(tempDegree > degree){
					degree = tempDegree;
				}
			}

			return degree;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
}