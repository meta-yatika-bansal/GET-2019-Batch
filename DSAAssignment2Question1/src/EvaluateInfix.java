/*
 * Evaluates an infix expression
 * Operands are assumed to be integers
 */
public class EvaluateInfix {

	/**
	 * Evaluates value of infix expression
	 * @param InfixExpression is the input expression
	 * @return evaluated value
	 */
	public int evaluateInfix(String InfixExpression){
		Stack stack = new Stack();
		String[] string;
		int operand1;
		int operand2;
		String result;
		String PostfixExpression =  infixToPostfix(InfixExpression);

		if(PostfixExpression == null){
			throw new AssertionError();
		}
		string = PostfixExpression.split(" ");

		for(String token : string){
			try{
				Integer.parseInt(token);
				stack.push(token);	
			}catch(NumberFormatException e){
				operand1 = Integer.parseInt(stack.pop());
				operand2 = Integer.parseInt(stack.pop());
				result = operation(operand2, operand1, token);
				stack.push(result);
			}
		}

		return Integer.parseInt(stack.pop());
	}	

	/**
	 * Computes operation to be performed
	 * @param operand1 is the first operand
	 * @param operand2 is the second operand
	 * @param operator is the operator
	 * @return result of the operation
	 */
	private String operation(int operand1, int operand2, String operator){
		switch(operator){
		case "+" : 
			return Integer.toString((operand1 + operand2));
		case "-" : 
			return Integer.toString((operand1 - operand2));
		case "*" : 
			return Integer.toString((operand1 * operand2));
		case "/" : 
			return Integer.toString((operand1 / operand2));
		case "==" : 
			return Boolean.toString((operand1 == operand2));
		case "!=" : 
			return Boolean.toString((operand1 != operand2));
		case ">" : 
			return Boolean.toString((operand1 > operand2));
		case "<" : 
			return Boolean.toString((operand1 < operand2));
		case ">=" : 
			return Boolean.toString((operand1 >= operand2));
		case "<=" : 
			return Boolean.toString((operand1 <= operand2));
		default : 
			return Integer.toString(0);
		}
	}

	/**
	 * Converts infix expression to post fix
	 * @param expression is the infix expression
	 * @return post fix expression
	 */
	private String infixToPostfix(String expression){
		Stack stack = new Stack();
		String PostfixExpression = "";
		String[] string;
		int operand;
		string = expression.split(" ");

		for(String token : string){
			try{
				operand = Integer.parseInt(token);
				PostfixExpression = PostfixExpression + operand  + " ";	
			}catch(NumberFormatException e){
				if(stack.peek() == null){
					stack.push(token);
				}else{
					int precedenceToken = precedenceOfOperators(token);
					while(precedenceToken <= precedenceOfOperators(stack.peek())){
						if(precedenceToken == -1){
							return null;
						}
						PostfixExpression = PostfixExpression  + stack.pop()  + " ";
						if(stack.peek() == null){
							break;
						}
					}

					stack.push(token);
				}
			}
		}

		while(!stack.isStackEmpty()){
			PostfixExpression = PostfixExpression  + stack.pop()  + " ";
		}

		return PostfixExpression;
	}

	/**
	 * Calculates precedence of operators
	 * @param token is the operator
	 * @return precedence
	 */
	private int precedenceOfOperators(String token){
		switch(token){
		case "(" : return 8;
		case "!" : return 7;
		case "*" :  
		case "/" : return 6;
		case "+" :
		case "-" : return 5;
		case ">" :
		case "<" :
		case ">=" :
		case "<=" : return 4;
		case "==" :
		case "!=" : return 3;
		case "&&" : return 2;
		case "||" : return 1;
		default : System.out.println("Enter properly!");
		return -1;
		}
	}
}
