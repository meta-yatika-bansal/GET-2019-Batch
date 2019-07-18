/*
 * Test Class for HCF Method
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HcfTestCase {

	private int x;
	private int y;
	private int expectedResult;
	private ComputationOfLcmAndHcf compu;

	@Before
	public void initialize() {
		compu = new ComputationOfLcmAndHcf();
	}

	public HcfTestCase(int expectedResult, int x, int y) {
		this.expectedResult = expectedResult;
		this.x = x;
		this.y = y;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 1, 2, 3 },
				{ 13, 13, 13},
				{ 13, 13, 26}
		});
	}

	@Test
	public void HcfTestCase() {
		assertEquals(expectedResult, compu.HCFOfNumbers(x, y));
	}
}