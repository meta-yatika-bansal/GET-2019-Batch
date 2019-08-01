/*
 * Test Class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {
	EvaluateInfix evaluate = new EvaluateInfix();
	
	@Test
	public void evaluateInfixPositiveTest(){
		String InfixExpression = "1 + 2 * 3 - 4";
		assertEquals(3, evaluate.evaluateInfix(InfixExpression));
	}
	
	@Test(expected = AssertionError.class)
	public void evaluateInfixNegativeTest(){
		String InfixExpression = "1 + 2 ; 3 - 4";
		evaluate.evaluateInfix(InfixExpression);
	}
}
