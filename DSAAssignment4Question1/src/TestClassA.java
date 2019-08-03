/*
 * Test Class
 */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestClassA {

	EmployeeA input = new EmployeeA();
	List<EmployeeA> sortedById = new ArrayList<EmployeeA>();
	EmployeeA emp1 = new EmployeeA(6, "F", "Address Of F");
	EmployeeA emp2 = new EmployeeA(3, "B", "Address Of B");
	EmployeeA emp3 = new EmployeeA(5, "A", "Address Of A");
	EmployeeA emp4 = new EmployeeA(1, "D", "Address Of D");
	EmployeeA emp5 = new EmployeeA(7, "E", "Address Of E");	
	
	
	@Before
	public void sortedByIdList(){
		sortedById.add(emp4);
		sortedById.add(emp2);
		sortedById.add(emp3);
		sortedById.add(emp1);
		sortedById.add(emp5);
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
		assertEquals(sortedById, input.sortEmployeeById());
	}
}
