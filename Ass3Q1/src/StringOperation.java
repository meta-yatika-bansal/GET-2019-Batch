/*
 * Calculates various operations on String.
 * Input is the String on which operation is to be performed.
 * String is assumed to be not null and case sensitive.
 * @since 15-July-2019
 */
import java.util.*;
public class StringOperation {

	public static void main(String[] args) {
		int choice;
		String str1=new String();
		String str2=new String();
		Operations operation=new Operations();
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		try {
			System.out.println("Enter the string");
			str1=sc1.nextLine();

			System.out.println("1Comparison");
			System.out.println("2String Reversal");
			System.out.println("3Change CASE");
			System.out.println("4Find Largest Word");
			choice=sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter another string");
				str2=sc1.nextLine();
				System.out.println(operation.Equality(str1, str2));
				break;
			case 2:
				System.out.println(operation.Reverse(str1));
				break;
			case 3:
				System.out.println(operation.ChangeCase(str1));
				break;
			case 4:	
				System.out.println(operation.LargestWord(str1));
				break;
			default:
				System.out.println("Enter the choice correctly!");
			}
		}catch(Exception e) {
			System.out.println("Enter correctly!");
		}
		
		sc.close();
		sc1.close();
	}

}
