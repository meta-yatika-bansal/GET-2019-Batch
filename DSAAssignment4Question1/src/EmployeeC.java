/*
 * Implements collection of Employee
 */
import java.util.*;

public class EmployeeC {
	int empId;
	String name;
	String address;
	Set<EmployeeC> setOfEmployee = new HashSet<EmployeeC>();
	
	public EmployeeC(){}
	
	public EmployeeC(int empId, String name, String address){
		this.address = address;
		this.empId = empId;
		this.name = name;
	}

	/**
	 * Adds employee to Set
	 * @param emp is the employee to be added
	 */
	public boolean makeSet(EmployeeC emp){
		 System.out.println(emp.empId);
		 return setOfEmployee.add(emp);
	}
	
	/**
	 * Defines criteria of Equality
	 * @param o is the object
	 */
	@Override
	public boolean equals(Object o){
		return o instanceof EmployeeC && this.empId == ((EmployeeC)o).empId;
	}
	
	/**
	 * Overrides hashcode as equals method is overridden
	 */
	@Override
	public int hashCode(){
		return this.empId;
	}
}

