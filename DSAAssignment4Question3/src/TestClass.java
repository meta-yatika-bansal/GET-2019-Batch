/*
 * Test Class
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClass {

	CompoundMass compound = new CompoundMass();
	
	@Test
	public void calculateMassTest(){
		assertEquals(46, compound.calculateMass("C(OH)2"));
		assertEquals(86, compound.calculateMass("CHOC(CH3)3"));
	}
	
	@Test
	public void calculateMassNegativeTest(){
		assertEquals(0, compound.calculateMass("3C(OH)2"));
	}
}
