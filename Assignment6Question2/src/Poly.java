/*
 * Performs various operations on Polynomials
 * Coefficients of polynomial are assumed to be Integers
 * @since 22-July-2019
 */
public final class Poly {

	private final int[] coefficient;
	private final int[] exponent;

	public Poly(int[] coefficient, int[] exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	/**
	 * Getter Method
	 * @return coefficient array
	 */
	public int[] getCoefficient(){
		return coefficient;
	}

	/**
	 * Getter Method
	 * @return Exponent Array
	 */
	public int[] getExponent(){
		return exponent;
	}

	/**
	 * Computes Value of a polynomial for a given value of variable
	 * @param value is the value of variable
	 * @return value of polynomial
	 */
	float evaluate(float value){
		float valuePoly = 0;
		for(int i = 0 ; i < coefficient.length ; i++){
			valuePoly += coefficient[i]*(Math.pow(value, exponent[i]));
		}

		return valuePoly;
	}

	/**
	 * Computes degree of polynomial
	 * @return degree of polynomial
	 */
	int degree(){
		int degree = exponent[0];
		for(int i = 0 ; i < exponent.length ; i++){
			if(exponent[i] > degree){
				degree = exponent[i];
			}
		}

		return degree;
	}

	/**
	 * Adds two given Polynomial
	 * @param p1 is the first Polynomial
	 * @param p2 is the second Polynomial
	 * @return resultant polynomial
	 */
	Poly addPoly(Poly p1, Poly p2){
		int size = p1.coefficient.length + p2.coefficient.length;
		int[] coefficientAdd = new int[size];
		int[] exponentAdd = new int[size];
		int k = exponentAdd.length;
		boolean flag = false;

		coefficientAdd = p1.coefficient;
		exponentAdd = p1.exponent;

		for(int i=0 ; i < p2.exponent.length ; i++){
			for(int j = 0 ; j < p1.exponent.length ; j++){
				if(p2.exponent[i] == p1.exponent[j]){
					flag = true;
					coefficientAdd[j] += p2.coefficient[i];
				}
			}

			if(!flag){
				coefficientAdd[k] = p2.coefficient[i];
				exponentAdd[k] = p2.exponent[i];
				k++;
			}

		}

		Poly poly = new Poly(coefficientAdd, exponentAdd);
		return poly;
	}

	/**
	 * Multiplies two given polynomial
	 * @param p1 is the first polynomial
	 * @param p2 is the second polynomial
	 * @return resultant polynomial
	 */
	Poly multiply(Poly p1, Poly p2){
		int size = (p1.coefficient.length)*(p2.coefficient.length);
		int[] coefficient = new int[size];
		int[] exponent = new int[size];
		int k = 0;
		boolean flag = false;

		for(int i = 0 ; i < p1.exponent.length ; i++){
			for(int j = 0 ; j < p2.exponent.length ; j++){
				exponent[k] = p1.exponent[i] + p2.exponent[j];
				coefficient[k] = p1.coefficient[i]*p2.coefficient[j];
				k++;
			}
		}

		int[] finalCoefficient = new int[k];
		int[] finalExponent = new int[k];
		int l = 0;

		for(int i = 0 ; i < exponent.length ; i++){
			for(int j = i+1 ; j<exponent.length ; j++){
				if(exponent[i] == exponent[j]){
					flag = true;
					finalCoefficient[l] = coefficient[i] + coefficient[j];
					finalExponent[l] = exponent[i];
					l++;
				}
			}

			if(i == exponent.length-1){
				finalCoefficient[l] = coefficient[i];
				finalExponent[l] = exponent[i];
				l++;
			}

			if(!flag){
				finalCoefficient[l] = coefficient[i];
				finalExponent[l] = exponent[i];
				l++;
			}
		}

		int[] finalCoefficient1 = new int[l];
		int[] finalExponent1 = new int[l];
		for(int i = 0 ; i < l ; i++){
			finalCoefficient1[i]= finalCoefficient[i];
			finalExponent1[i] = finalExponent[i];
		}

		Poly poly = new Poly(finalCoefficient1, finalExponent1);
		return poly;
	}
}