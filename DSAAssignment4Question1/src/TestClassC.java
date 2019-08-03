/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestClassC {

	EmployeeC input = new EmployeeC();
	EmployeeC emp1 = new EmployeeC(6, "F", "Address Of F");
	EmployeeC emp2 = new EmployeeC(3, "B", "Address Of B");
	EmployeeC emp3 = new EmployeeC(5, "A", "Address Of A");
	EmployeeC emp4 = new EmployeeC(1, "D", "Address Of D");
	EmployeeC emp5 = new EmployeeC(7, "E", "Address Of E");	
	
	@Before
	public void makeListTest(){
		input.makeSet(emp1);
		input.makeSet(emp2);
		input.makeSet(emp3);
		input.makeSet(emp4);
		input.makeSet(emp5);
	}
	
	@Test
	public void sortEmployeeByIdtest() {
		EmployeeC empDuplicate = new EmployeeC(7, "G", "Address Of G");	
		assertEquals(false, input.makeSet(empDuplicate));
	}
}
