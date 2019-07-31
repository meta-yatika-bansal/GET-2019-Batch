/*
 * Represents structure of each variable
 * Exponent of each variable is assumed to be Integer
 * Variable is assumed to be a Character
 */
class NodeVar{
	int exponent;
	char variable;
	NodeVar next;
}

/*
 * Represents list of variables
 */
public class Variable {
	NodeVar head = new NodeVar();

	/**
	 * Adds variable to list of variables
	 * @param variable is the variable to be added
	 * @param exponent is the power of variable
	 */
	public void addVariable(char variable, int exponent){
		try{
			NodeVar node = new NodeVar();
			NodeVar n;
			node.exponent = exponent;
			node.variable = variable;

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
	 * Calculates sum of exponents of each variable in list
	 * @return calculated sum
	 */
	public int sumOfExponent(){
		try{
			int sum = 0;
			for(NodeVar n = head ; n.next != null ; n = n.next){
				sum += n.next.exponent;
			}

			return sum;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
}