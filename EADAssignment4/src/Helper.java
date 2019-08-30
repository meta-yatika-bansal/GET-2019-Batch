/*
 * Helper Class to query Database
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Helper {

	/**
	 * Adds Employee
	 * @param e is the Employee
	 * @return id of Employee added
	 */
	public static int addEmployee(Employee e){
		int id = 0;
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.add());
				PreparedStatement p1 = c.prepareStatement(Query.getId())){ 
			p.setString(1, e.full_name);
			p.setString(2, e.gender);
			p.setString(3, e.email);
			p.setString(4, e.password);
			p.setString(5, e.contact_number);
			p.setString(6, e.org);
			p.execute();
			ResultSet res = p1.executeQuery();
			if(res.next()){
				id = res.getInt("employee_id");
			} 			
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return id;
	}

	/**
	 * Authenticates Employee
	 * @param email of Employee
	 * @return password of Employee
	 */
	public static String authEmployee(String email){
		String password=null;
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.auth(email))){
			ResultSet res = p.executeQuery();
			if(res.next()){
				password = res.getString("password");
			} 		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return password;
	}

	/**
	 * Adds Vehicle of Employee
	 * @param v is vehicle
	 * @return true or false accordingly
	 */
	public static boolean addVehicle(Vehicle v){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.addVehicle())){
			p.setString(1, v.name);
			p.setString(2, v.type);
			p.setInt(3, v.vehicle_number);
			p.setInt(4, v.employee_id);
			p.setString(5, v.identification);
			p.execute();
			return true;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets Price of Vehicle
	 * @param type of vehicle
	 * @return prices of plans available
	 */
	public static double[] getVehiclePrice(String type){
		double[] price = new double[3];
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.getPrice(type))){
			ResultSet res = p.executeQuery();
			if(res.next()){
				price[0] = res.getDouble("daily");
				price[1] = res.getDouble("monthly");
				price[2] = res.getDouble("yearly");
			} 		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return price;
	}

	/**
	 * Updates Employee
	 * @param e is the employee
	 * @return true or false accordingly
	 */
	public static boolean updateEmployee(Employee e){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.update(e.employee_id))){   
			p.setString(1, e.full_name);
			p.setString(2, e.gender);
			p.setString(3, e.email);
			p.setString(4, e.password);
			p.setString(5, e.contact_number);
			p.setString(6, e.org);
			p.execute();
			return true;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns Employee having given id
	 * @param employee_id
	 * @return Employee
	 */
	public static Employee getEmployee(int employee_id){
		Employee e = null;
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.get(employee_id))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				String full_name = res.getString("full_name");
				String gender = res.getString("gender");
				String email = res.getString("email");
				String password = res.getString("password");
				String contact_number = res.getString("contact_number");
				String org = res.getString("org");
				e = new Employee(employee_id,full_name,gender,email,password,contact_number,org);
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return e;
	}

	/**
	 * Returns Employee having given email
	 * @param email of employee
	 * @return Employee
	 */
	public static Employee getEmployeeByEmail(String email){
		Employee e = null;
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.getByEmail(email))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				int employee_id = res.getInt("employee_id");
				String full_name = res.getString("full_name");
				String gender = res.getString("gender");
				String password = res.getString("password");
				String contact_number = res.getString("contact_number");
				String org = res.getString("org");
				e = new Employee(employee_id,full_name,gender,email,password,contact_number,org);
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return e;
	}

	/**
	 * Returns Friends of an Employee
	 * @param employee_id
	 * @return list of friends
	 */
	public static List<Employee> getFriend(int employee_id){
		List<Employee> e = new ArrayList<Employee>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.friend(employee_id))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				int id = res.getInt("employee_id");
				String full_name = res.getString("full_name");
				String gender = res.getString("gender");
				String email = res.getString("email");
				String password = res.getString("password");
				String contact_number = res.getString("contact_number");
				String org = res.getString("org");
				e.add(new Employee(id,full_name,gender,email,password,contact_number,org));
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return e;
	}
}