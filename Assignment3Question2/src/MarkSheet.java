/*
 * Calculates Average ,maximum , minimum grades among students 
 * and percentage of students passed.
 * Assumes number of students as a positive integer 
 * Grades in [0,100].
 * Passing marks are assumed to be 40.
 * @since 15-July-2019
 */
import java.util.Scanner;

public class MarkSheet {

	public static void main(String[] args) {
		int number;
		Marks mark=new Marks();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of students");
		number=sc.nextInt();

		float[] grade=new float[number];
		System.out.println("Enter the grade of students");
		for(int i =0 ; i<number ; i++){
			grade[i]=sc.nextFloat();
		}
		
		System.out.printf("\nAverage %.2f " , mark.Average(grade, number));
		System.out.printf("\nMaximum %.2f ",mark.Maximum(grade, number));
		System.out.printf("\nMinimum %.2f ",mark.Minimum(grade, number));
		System.out.println("\nPercentage of students passed "+mark.StudentsPassed(grade, number)+"%" );
	sc.close();
   }
}
