/*
 * Test class for Union method
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnionTestClass {

	private int[] inputArray = {1, 2, 3, 4};
	private int[] inputArray2 = {1, 2, 3};
	private int[] expectedResult;
	private IntSet set;
	private IntSet set2;


	@Before
	public void initialize() {
		set = new IntSet(inputArray);
		set2 = new IntSet(inputArray2);
	}

	public UnionTestClass(int[] expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{new int[]{4, 1, 2, 3}}
		});
	}

	@Test
	public void UnionTestClass() {
		assertArrayEquals(expectedResult, set.union(set, set2));
	}
}

