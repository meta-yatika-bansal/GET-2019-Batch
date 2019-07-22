/*
 * Test class for size method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SizeTestClass {

	private int[] inputArray = {1, 2, 3, 4};
	private int expectedResult;
	private IntSet set;

	@Before
	public void initialize() {
	    set = new IntSet(inputArray);
	}

	public SizeTestClass(int expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{4}
		});
	}

	@Test
	public void SizeTestClass() {
		assertEquals(expectedResult, set.size());
	}
}

