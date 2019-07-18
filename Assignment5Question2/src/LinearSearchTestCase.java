/*
 * Test Class for Linear Search Method
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinearSearchTestCase {

	private double[] array;
	private double element;
	private int expectedResult;
	private Search search;

	@Before
	public void initialize() {
		search = new Search();
	}

	public LinearSearchTestCase(int expectedResult, double[] array, double element) {
		this.expectedResult = expectedResult;
		this.array = array;
		this.element = element;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 4, new double[]{78, 34, 100, -4, 0 }, -4},
				{ 3, new double[]{12.5, 14, 13.2}, 13.2},
				{-1, new double[]{3, 7, 2, 9}, 10},
				{ 2, new double[]{21, 56, 77}, 56},
				{-1, new double[]{}, 0}
		});
	}

	@Test
	public void LinearSearchTestCase() {
		assertEquals(expectedResult, search.linearSearch(array, element));
	}
}
