/*
 * Test Class for LCM method 
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LcmTestCase {

	private int x;
	private int y;
	private int expectedResult;
	private ComputationOfLcmAndHcf compu;

	@Before
	public void initialize() {
		compu = new ComputationOfLcmAndHcf();
	}

	public LcmTestCase(int expectedResult, int x, int y) {
		this.expectedResult = expectedResult;
		this.x = x;
		this.y = y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 6, 2, 3 },
				{ 13, 13, 13}
		});
	}

	@Test
	public void LcmTestCase() {
		assertEquals(expectedResult, compu.LCMOfNumbers(x, y));
	}
}
