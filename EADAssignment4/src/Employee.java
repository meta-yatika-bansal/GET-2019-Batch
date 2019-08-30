/*
 * Represents Employee
 */
public class Employee {
	int employee_id; 
	String full_name ;
	String gender; 
	String email; 
	String password; 
	String contact_number; 
	String org;

	public Employee(String full_name, String gender,
			String email, String password, String contact_number, String org) {
		super();
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact_number = contact_number;
		this.org = org;
	}

	public Employee(int employee_id, String full_name, String gender,
			String email, String password, String contact_number, String org) {
		super();
		this.employee_id = employee_id;
		this.full_name = full_name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact_number = contact_number;
		this.org = org;
	}
}
