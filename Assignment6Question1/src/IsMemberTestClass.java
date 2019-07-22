/*
 * Test class for isMember method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IsMemberTestClass {

	private int[] inputArray = {1, 2, 3, 4};
	private int x;
	private Boolean expectedResult;
	private IntSet set;

	@Before
	public void initialize() {
	    set = new IntSet(inputArray);
	}

	public IsMemberTestClass(Boolean expectedResult, int x) {
		this.expectedResult = expectedResult;
		this.x=x;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{true, 1},
				{true, 2},
				{true, 3},
				{true, 4},
				{false, 5},
				{false, 0}
		});
	}

	@Test
	public void IsMemberTestClass() {
		assertEquals(expectedResult, set.isMember(x));
	}
}

