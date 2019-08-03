/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestClassB {

	EmployeeB input = new EmployeeB();
	List<EmployeeB> sortedByName = new ArrayList<EmployeeB>();
	EmployeeB emp1 = new EmployeeB(6, "F", "Address Of F");
	EmployeeB emp2 = new EmployeeB(3, "B", "Address Of B");
	EmployeeB emp3 = new EmployeeB(5, "A", "Address Of A");
	EmployeeB emp4 = new EmployeeB(1, "D", "Address Of D");
	EmployeeB emp5 = new EmployeeB(7, "E", "Address Of E");	
	
	
	@Before
	public void sortedByIdList(){
		sortedByName.add(emp3);
		sortedByName.add(emp2);
		sortedByName.add(emp4);
		sortedByName.add(emp5);
		sortedByName.add(emp1);
	}
	
	@Before
	public void makeListTest(){
		input.makeList(emp1);
		input.makeList(emp2);
		input.makeList(emp3);
		input.makeList(emp4);
		input.makeList(emp5);
	}
	
	@Test
	public void sortEmployeeByIdtest() {
		assertEquals(sortedByName, input.sortEmployeeByName());
	}
}
