/*
 * Test class for negative test cases of methods of Poly class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EvaluateTestClass {

	private Poly poly;
	private Poly poly1;
	private int[] coefficient = {1, 2, 1};
	private int[] exponent = {2, 1, 0};
	private int[] coefficient1 = {1, 6};
	private int[] exponent1 = {1, 0};
	private int[] coefficientAdd = {1, 3, 7};
	private int[] exponentAdd = {2, 1, 0};
	private int[] coefficientMul = {1, 8, 13, 6};
	private int[] exponentMul = {3, 2, 1, 0};
	
	@Before
	public void initialize() {
		poly = new Poly(coefficient,exponent);
		poly1 = new Poly(coefficient1,exponent1);
	}

	@Test
	public void evaluateTest() {
		float x = 2;
		assertEquals(9, poly.evaluate(x),0);
	}
	
	@Test
	public void degreeTest(){
		assertEquals(2, poly.degree());
	}
	
	@Test
	public void addPolyTest(){
		int[] coefficientArray =  poly.addPoly(poly, poly1).getCoefficient();
		assertArrayEquals(coefficientAdd, coefficientArray );
		int[] exponentArray =  poly.addPoly(poly, poly1).getExponent();
		assertArrayEquals(exponentAdd, exponentArray );
	}
	
	@Test
	public void multiplyTest(){
		int[] coefficientArray =  poly.multiply(poly, poly1).getCoefficient();
		assertArrayEquals(coefficientMul, coefficientArray);
		int[] exponentArray =  poly.multiply(poly, poly1).getExponent();
		assertArrayEquals(exponentMul, exponentArray);

	}
}
