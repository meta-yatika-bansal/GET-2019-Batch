/*
 * Calculates Mass of a organic compound
 */
import java.util.*;

public class CompoundMass {

	Map<Character,Integer> value = new HashMap<Character,Integer>();
	Stack<Integer> stack = new Stack<Integer>();

	/**
	 * Calculates mass of given compound
	 * @param compound is the organic compound
	 * @return mass of the compound
	 */
	public int calculateMass(String compound){
		try{
			int massOfCompound = 0;
			value.put('C', 12);
			value.put('O', 16);
			value.put('H', 1);
			value.put('(', 0);

			for(int i = 0 ; i < compound.length() ; i++){
				int mass = 0;
				int digit;
				if(compound.charAt(i) == ')'){
					int s = stack.pop();
					
					while(s != 0){
						mass += s;
						s = stack.pop();
					}

					stack.push(mass);
				}
				else if(Character.isDigit(compound.charAt(i))){
					digit = Character.getNumericValue(compound.charAt(i));
					stack.push((stack.pop())*digit);
				}else{
					stack.push(value.get(compound.charAt(i)));     
				}
			}

			while(!stack.empty()){
				massOfCompound += stack.pop();
			}

			return massOfCompound;
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
}
