/*
 * Implements collection of Employee
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeB implements Comparable<EmployeeB>{
	int empId;
	String name;
	String address;
	List<EmployeeB> listOfEmployee = new ArrayList<EmployeeB>();
	
	public EmployeeB(){}
	
	public EmployeeB(int empId, String name, String address){
		this.address = address;
		this.empId = empId;
		this.name = name;
	}

	/**
	 * Adds employee to List
	 * @param emp is the employee to be added
	 */
	public void makeList(EmployeeB emp){
		listOfEmployee.add(emp);
	}

	/**
	 * Defines Criteria of Comparison i.e Employee Name
	 * @param arg0 is the employee
	 */
	@Override
	public int compareTo(EmployeeB arg0) {
		return this.name.compareTo(arg0.name);
	}

	/**
	 * Sorts list of employee
	 * @return sorted list
	 */
	public List<EmployeeB> sortEmployeeByName(){
		Collections.sort(listOfEmployee);
		return listOfEmployee;
	}
}

