/*
 * Test class for negative test cases of methods of Poly class
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EvaluateTestClass {

	private Poly poly;
	private Poly poly1;
	private Poly polyAdd;
	private Poly polyMul;
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
		polyAdd = new Poly(coefficientAdd,exponentAdd);
		polyMul = new Poly(coefficientMul,exponentMul);
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
		Poly res =  poly.addPoly(poly, poly1);
		assertEquals(polyAdd, res);
	}
	
	@Test
	public void multiplyTest(){
		assertEquals(polyMul, poly.multiply(poly, poly1));
	}
}
