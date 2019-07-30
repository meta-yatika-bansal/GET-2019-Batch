/*
 * Represents Polynomial as a collection of terms
 */
public class Polynomial {
	Term terms = new Term();
	
	/**
	 * Adds a term to polynomial
	 * @param coefficient is the coefficient of term
	 * @param variable is the type of variable in the term
	 * @param exponent is the power of variable
	 */
	public void add(int coefficient, char[] variable, int[] exponent){
		terms.addTerm(coefficient, variable, exponent);
	}
	
	/**
	 * Calculates Degree of polynomial
	 * @return degree
	 */
	public int calculateDegree(){
		return terms.degree();
	}
}
