/*
 * Test class for negative test cases of methods of IntSet class
 */
import org.junit.Before;
import org.junit.Test;

public class Negative {

	private IntSet set ;
	private int[] array = {1, 2, 2};
	int[] array2 = {3, 3};
	IntSet set2 = new IntSet(array2);

	@Before
	public void initialize() {
		set = new IntSet(array);
	}

	@Test(expected = AssertionError.class)
	public void isMemberTest() {
		int x = 2;
		set.isMember(x);
	}
	
	@Test(expected = AssertionError.class)
	public void sizeTest() {
		set.size();
	}
	
	@Test(expected = AssertionError.class)
	public void getComplementTest() {
		set.getComplement();
	}
	
	@Test(expected = AssertionError.class)
	public void isSubsetTest() {
		set.isSubset(set2);
	}
	
	@Test(expected = AssertionError.class)
	public void unionTest() {
		set.union(set, set2);
	}
	
	

}
