/*
 * Test class for Max Mirror Method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxMirrorTestClass {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public MaxMirrorTestClass(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] {1, 2, 3, 8, 9, 3, 2, 1}},
				{ 2, new int[] {7, 1, 4, 9, 7, 4, 1}},
				{ 3, new int[] {1, 2, 1, 4 }},
				{ 7, new int[] {1, 4, 5, 3, 5, 4, 1}},
				{ 1, new int[] {1}},
				{ 1, new int[] {1, 2}},
				{ 1, new int[] {1, 2 ,3}}
		});
	}

	@Test
	public void MaxMirrorTestClass() {
		assertEquals(expectedResult, arrOperations.maxMirror(inputArray));
	}
}

