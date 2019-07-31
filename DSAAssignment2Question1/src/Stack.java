/*
 * Represents Stack
 */
public class Stack {
	String[] stack = new String[100];
    int top = -1;

    /**
     * Pushes item onto the stack
     * @param item to be pushed
     */
	public void push(String item){
		if(top == -1){
			top = 0;
			stack[top] = item;
		}else{
			top++;
			stack[top] = item;
		}
	}

	/**
	 * Pops item from the stack
	 * @return popped item
	 */
	public String pop(){
		if(isStackEmpty()){
			return null;
		}else{
			String item;
			item = stack[top];
			top--;
			return item;
		}
	}

	/**
	 * Peeks onto the topmost element
	 * @return topmost element
	 */
	public String peek(){
		if(top == -1){
			return null;
		}
		
		return stack[top];
	}

	/**
	 * Checks whether the stack is empty
	 * @return true or false accordingly
	 */
	public boolean isStackEmpty(){
		if(top == -1){
			return true;
		}
		
		return false;
	}
}
