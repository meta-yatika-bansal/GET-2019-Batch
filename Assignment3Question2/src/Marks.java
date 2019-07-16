/**
 * Contains Helper Functions for calculating Marks.
 */
public class Marks {
	public final int PASSING_MARKS=40;
	
	/**
	 * Calculates Average of the grades of students
	 * @param grade grades of students
	 * @param n number of students
	 * @return average grade 
	 */
	public float Average(float[] grade , int n){
		float sum =0;
		float average=0;
		for(int i =0 ; i<n ; i++){
			sum += grade[i];
		}
		try{
			average = sum/n;
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException");
		}
		
		return average;
	}
	
	/**
	 * Calculates Maximum grade among all the students 
	 * @param grade grades of students
	 * @param n number of students
	 * @return maximum grade
	 */
	public float Maximum(float[]grade , int n){
		float max=0;
		for(int i =0 ; i<n ; i++){
			if(grade[i]>max){
				max=grade[i];
			}
		}
		
		return max;
	}
	
	/**
	 * Calculates Minimum grade among all the students 
	 * @param grade grades of students
	 * @param n number of students
	 * @return minimum grade
	 */
	public float Minimum (float[] grade , int n){
		float min=grade[0];
		for(int i =0 ; i<n ; i++){
			if(grade[i]<min){
				min=grade[i];
			}
		}
		
		return min;
	}
	
	/**
	 * Calculates Percentage of students passed
	 * @param grade grade of students
	 * @param n number of students
	 * @return Percentage of students passed
	 */
	public int  StudentsPassed(float [] grade , int n){
		int studentsPassed=0;
		int percent=0;
		for(int i =0 ; i<n ; i++){
			if(grade[i]>=PASSING_MARKS){
				studentsPassed++;
			}
		}
		try{
			percent = (studentsPassed/n)*100;
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException");
		}
		
		return percent;
	}

}
