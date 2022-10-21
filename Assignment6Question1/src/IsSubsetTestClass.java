/*
 * Test class for isSubset method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IsSubsetTestClass {

	private int[] inputArray = {1, 2, 3, 4};
	private int[] inputArray2 = {1, 2, 3};
	private Boolean expectedResult;
	private IntSet set;
	private IntSet set2;

	@Before
	public void initialize() {
		set = new IntSet(inputArray);
		set2 = new IntSet(inputArray2);
	}

	public IsSubsetTestClass(Boolean expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{true}
		});
	}

	@Test
	public void IsSubsetTestClass() {
		assertEquals(expectedResult, set.isSubset(set2));
	}
}

