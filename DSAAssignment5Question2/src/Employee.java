/*
 * Represents Employee
 */
public class Employee {
	String name;
	int salary;
	int age;
	Employee next;
	
	public Employee(){}
	
	public Employee(String name, int salary, int age){
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.next = null;
	}
}
