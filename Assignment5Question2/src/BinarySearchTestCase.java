/*
 * Test Class for Binary Search
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinarySearchTestCase {

	private double[] array;
	private double element;
	private int firstIndex;
	private int lastIndex;
	private int expectedResult;
	private Search search;

	@Before
	public void initialize() {
		search = new Search();
	}

	public BinarySearchTestCase(int expectedResult, double[] array, double element, int firstIndex, int lastIndex) {
		this.expectedResult = expectedResult;
		this.array = array;
		this.element = element;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 2, new double[]{0, 34, 56, 90}, 56, 0, 4},
				{ 1, new double[]{12.5, 13.2, 14}, 13.2, 0, 3},
				{ 0, new double[]{-1, 3, 7, 9}, -1, 0, 4},
				{-1, new double[]{21, 56, 77}, 57, 0, 3},
				{-1, new double[]{}, 0, 0, 0},
				{-1, new double[]{4, 5, 6}, 0,  1, -2},
				{-1, new double[]{4, 5, 6}, 0, -1, 2},
				{-1, new double[]{4, 5, 6}, 0, -1, -2},
				{ 2, new double[]{6, 6, 6, 6}, 6, 0, 4}
		});
	}

	@Test
	public void BinarySearchTestCase() {
		assertEquals(expectedResult, search.binarySearch(array, element, firstIndex, lastIndex));
	}
}
