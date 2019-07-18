/*
 * It Computes LCM and HCF of two numbers.
 * Input is the numbers.
 * Numbers are assumed to be positive Integers.
 * Output is the HCF and LCM of numbers.
 * @since 18-July-2019
 */
public class ComputationOfLcmAndHcf {
	int lcm = 1;

	/**
	 * Calculates HCF of given numbers
	 * @param x first number
	 * @param y second number
	 * @return HCF of x and y
	 */
	int HCFOfNumbers(int x, int y){
		if(x == y){
			return x;
		}
		if(x > y){
			return HCFOfNumbers(x - y, y);
		}else{
			return HCFOfNumbers(x, y - x);
		}
	}

	/**
	 * Calculates LCM of given numbers
	 * @param x first number
	 * @param y second number
	 * @return LCM of x and y
	 */
	int LCMOfNumbers(int x, int y){

		if(lcm % x == 0 && lcm % y == 0){
			return lcm;
		}else{
			lcm++;
			return LCMOfNumbers(x, y);
		}
	}

}
