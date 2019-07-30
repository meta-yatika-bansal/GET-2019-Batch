/*
 * Test Class
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClass {
	int NUMBER_OF_VARIABLE = 2;
	Polynomial poly = new Polynomial();
	char[] var = new char[NUMBER_OF_VARIABLE];
	int[] expo = new int[NUMBER_OF_VARIABLE];

	@Before
	public void addTest(){
		var[0] = 'X';
		expo[0] = 2;
		poly.add(2, var, expo);
		var[0] = 'Y';
		expo[0] = 2;
		poly.add(1, var, expo);
		var[0] = 'X';
		expo[0] = 3;
		var[1] = 'Y';
		expo[1] = 2;
		poly.add(1, var, expo);
		var[0] = 'X';
		expo[0] = 0;
		poly.add(16, var, expo);
	}

	@Test
	public void degreeTest(){
		assertEquals(5, poly.calculateDegree());
	}
}
