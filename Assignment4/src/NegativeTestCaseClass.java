/*
 * Test class for negative test cases of methods of ArrOperation class
 */
import org.junit.Before;
import org.junit.Test;

public class NegativeTestCaseClass {

	private ArrOperation arrOperations ;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	@Test(expected = AssertionError.class)
	public void splitArraytest() {
		int[] arr={};
		arrOperations.splitArray(arr);
	}
	
	@Test(expected = AssertionError.class)
	public void countClumpstest() {
		int[] arr={};
		arrOperations.countClumps(arr);
	}
	
	@Test(expected = AssertionError.class)
	public void maxMirrortest() {
		int[] arr={};
		arrOperations.maxMirror(arr);
	}
	
	@Test(expected = AssertionError.class)
	public void fixXYtestIfEmpty() {
		int[] arr={};
		int X = 4;
		int Y = 5;
		arrOperations.fixXY(arr,X,Y);
	}
	
	@Test(expected = AssertionError.class)
	public void fixXYtestIfUnequal() {
		int[] arr={1,4,1,4,5};
		int X = 4;
		int Y = 5;
		arrOperations.fixXY(arr,X,Y);
	}
	
	@Test(expected = AssertionError.class)
	public void fixXYtestIfAdjacent() {
		int[] arr={1,4,4,5};
		int X = 4;
		int Y = 5;
		arrOperations.fixXY(arr,X,Y);
	}
	
	@Test(expected = AssertionError.class)
	public void fixXYtestIfAtLast() {
		int[] arr={2,3,5,4};
		int X = 4;
		int Y = 5;
		arrOperations.fixXY(arr,X,Y);
	}

}
