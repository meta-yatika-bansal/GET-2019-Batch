
/*
 * Test class for fixXy method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTestClass{

	private int[] inputArray;
	private int[] expectedResult;
	private int X;
	private int Y;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public FixXYTestClass(int[] expectedResult, int[] inputArray, int X, int Y) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.X = X;
		this.Y = Y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{new int[] {9, 4, 5, 4, 5, 9} , new int[] {5, 4, 9, 4, 9, 5}, 4, 5},
				{ new int[] {1, 4, 5, 1}, new int[] { 1, 4, 1, 5}, 4, 5},
				{ new int[] {1, 4, 5, 1, 1, 4, 5}, new int[] {1, 4, 1, 5, 5, 4, 1 }, 4, 5}
		});
	}

	@Test
	public void FixXYTestClass() {
		assertArrayEquals(expectedResult, arrOperations.fixXY(inputArray,X,Y));
	}
}

