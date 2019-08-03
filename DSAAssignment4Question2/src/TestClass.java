/*
 * Test Class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

	StringOperation operation = new StringOperation();

	@Test
	public void countCharactersTest(){
		assertEquals(4, operation.countUniqueCharacters("yatika"));
		assertEquals(0, operation.countUniqueCharacters("aa"));
		assertEquals(4, operation.countUniqueCharacters("yatika"));
	}
}
