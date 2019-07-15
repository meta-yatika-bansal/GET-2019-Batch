
/*It performs Arithmetic operation on HexaDecimal numbers.
 * Input are the HexaDecimal numbers.
 * HexaDecimal numbers are assumed to be positive integers.
 * Output will be the resultant HexaDecimal number after operation.
 */

import java.util.*;

public class HexCalc {

	public static void main(String[] args) {
		HexArithmetic function = new HexArithmetic();
		String hexNumber1;
		String hexNumber2;
		String number1;
		String number2;
		int choice;
		Scanner sc=new Scanner(System.in);
		final int BASE = 16;
		System.out.println("Enter the First Hexadecimal number:");
		number1 = sc.next();
		System.out.println("Enter the Second Hexadecimal number:");
		number2 = sc.next();
		
		hexNumber1 = number1.toUpperCase();
		hexNumber2 = number2.toUpperCase();
		if(!(function.isHexaDecimal(hexNumber1) 
				&& function.isHexaDecimal(hexNumber2))){
			System.out.println("Wrong!Enter a hexadecimal number");
		}else {
			System.out.println("Enter the Number of the operation you want"
					+ " to perform");
			System.out.println("1.Add");
			System.out.println("2.Subtract");
			System.out.println("3.Multiply");
			System.out.println("4.Divide");
			System.out.println("5.Equality");
			System.out.println("6.Greater Than");
			System.out.println("7.Less Than");
			choice = sc.nextInt();

			System.out.println("Result:");
			switch(choice) {
			case 1:
				System.out.println(function.Add(hexNumber1,hexNumber2,BASE));
				break;
			case 2:
				System.out.println(function.Subtract(hexNumber1,hexNumber2,BASE));
				break;
			case 3:
				System.out.println(function.Multiply(hexNumber1,hexNumber2,BASE));
				break;
			case 4:
				if(!"0".equals(hexNumber2)) {
					System.out.println(function.Divide(hexNumber1,hexNumber2,BASE));
					break;
				}else {
					System.out.println("Denominator cannot be zero!");
					break;
				}
			case 5:
				System.out.println(function.Equality(hexNumber1,hexNumber2));
				break;
			case 6:
				System.out.println(function.GreaterThan(hexNumber1,hexNumber2));
				break;
			case 7:
				System.out.println(function.LessThan(hexNumber1,hexNumber2));
				break;
			default:System.out.println("Please Enter the correct number");
			}
			sc.close();
		}

	}
}