/*
 * Test class for Split array method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SplitArrayTestCase{

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public SplitArrayTestCase(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] {1, 1, 1, 2, 1}},
				{ -1, new int[] { 2, 1, 1, 2, 1} },
				{ 1, new int[] {10, 10 }},
				{ -1 , new int[]{5}}
		});
	}

	@Test
	public void SplitArrayTestCase() {
		assertEquals(expectedResult, arrOperations.splitArray(inputArray));
	}
}

