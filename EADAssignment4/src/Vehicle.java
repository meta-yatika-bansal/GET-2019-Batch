/*
 * Represents Vehicle Of An Employee
 */
public class Vehicle {
	int vehicle_id ;
	String name ;
	String type ;
	int vehicle_number; 
	int employee_id ;
	String identification ;

	public Vehicle(int vehicle_id, String name, String type,
			int vehicle_number, int employee_id, String identification) {
		super();
		this.vehicle_id = vehicle_id;
		this.name = name;
		this.type = type;
		this.vehicle_number = vehicle_number;
		this.employee_id = employee_id;
		this.identification = identification;
	}

	public Vehicle(String name, String type,
			int vehicle_number, int employee_id, String identification) {
		super();
		this.name = name;
		this.type = type;
		this.vehicle_number = vehicle_number;
		this.employee_id = employee_id;
		this.identification = identification;
	}
}
