/*
 * Contains Query to database
 */
public class Query {

	/**
	 * Adds an Employee
	 * @return query
	 */
	public static String add(){
		String query = "insert into employee(full_name,gender,email,password,contact_number,org)"
				+" values(?,?,?,?,?,?)";
		return query;
	}

	/**
	 * Returns Employee with given id
	 * @param employee_id
	 * @return query
	 */
	public static String get(int employee_id){
		String query = "Select * from employee where employee_id =" + employee_id;
		return query;
	}

	/**
	 * Returns Employee with given Email
	 * @param email
	 * @return query
	 */
	public static String getByEmail(String email){
		String query = "Select * from employee where email ='" + email + "'";
		return query;
	}

	/**
	 * Returns id of last employee inserted
	 * @return query
	 */
	public static String getId(){
		String query = "select last_insert_id() as employee_id";
		return query;
	}

	/**
	 * Authenticates employee
	 * @param email
	 * @return query
	 */
	public static String auth(String email){
		String query="Select password from employee where email='" + email +"'";
		return query;
	}

	/**
	 * Adds Vehicle
	 * @return query
	 */
	public static String addVehicle(){
		String query = "insert into vehicle(name,type,vehicle_number,employee_id,identification)"
				+" values(?,?,?,?,?)";
		return query;
	}

	/**
	 * Gets Pass Prices according to vehicle type
	 * @param type of vehicle
	 * @return query
	 */
	public static String getPrice(String type){
		String query="select daily,monthly,yearly from pass where type='"+type+"'";
		return query;
	}

	/**
	 * Updates Employee
	 * @param employee_id
	 * @return query
	 */
	public static String update(int employee_id){
		String query="update employee set full_name=?,gender=?,email=?,password=?,contact_number=?,org=? where employee_id="+employee_id;
		return query;
	}

	/**
	 * Finds friends of an employee with given id
	 * @param employee_id
	 * @return query
	 */
	public static String friend(int employee_id){
		String query="select * from employee where org=(select org from employee where employee_id="+employee_id+")"
				+"and employee_id !="+employee_id;
		return query;
	}
}