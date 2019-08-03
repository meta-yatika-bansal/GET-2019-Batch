/*
 * Implements Collection of Employee
 */
import java.util.*;

public class EmployeeA implements Comparable<EmployeeA>{
	int empId;
	String name;
	String address;
	List<EmployeeA> listOfEmployee = new ArrayList<EmployeeA>();
	
	public EmployeeA(){}
	
	public EmployeeA(int empId, String name, String address){
		this.address = address;
		this.empId = empId;
		this.name = name;
	}

	/**
	 * Adds employee to List
	 * @param emp is the employee to be added
	 */
	public void makeList(EmployeeA emp){
		listOfEmployee.add(emp);
	}

	/**
	 * Defines Criteria of Comparison i.e Employee Id
	 * @param arg0 is the employee
	 */
	@Override
	public int compareTo(EmployeeA arg0) {
		return this.empId - (arg0).empId;
	}

	/**
	 * Sorts list of employee
	 * @return sorted list
	 */
	public List<EmployeeA> sortEmployeeById(){
		Collections.sort(listOfEmployee);
		return listOfEmployee;
	}
}

