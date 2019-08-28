/*
 * Helper Class to access database
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Helper {

	/**
	 * Adds Student
	 * @param first_name
	 * @param last_name
	 * @param father_name
	 * @param email
	 * @param class_student
	 * @param age
	 * @return true or false depending on whether student is added or not
	 */
	public static boolean addStudent(String first_name,String last_name,String father_name, String email,int class_student,int age){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.add(first_name, last_name, father_name, email, class_student, age))){    
			p.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Displays list of Students in Database
	 * @return list of students
	 */
	public static List<Student> showStudent(){
		List<Student> students = new ArrayList<Student>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.show())){
			ResultSet res = p.executeQuery();
			while(res.next()){
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String father_name = res.getString("father_name");
				String email = res.getString("email");
				int class_student = res.getInt("class");
				int age = res.getInt("age");
				int id = res.getInt("id");
				students.add(new Student(id,firstName,lastName,father_name,email,class_student,age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	/**
	 * Searches a student in database
	 * @param key is the keyword to be searched
	 * @param select flag depending on filter
	 * @return list of students
	 */
	public static List<Student> searchStudent(String key,boolean select){
		List<Student> students = new ArrayList<Student>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.search(key,select))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String father_name = res.getString("father_name");
				String email = res.getString("email");
				int class_student = res.getInt("class");
				int age = res.getInt("age");
				int id = res.getInt("id");
				students.add(new Student(id,firstName,lastName,father_name,email,class_student,age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	/**
	 * Gets a particular student based on id
	 * @param id of student
	 * @return student
	 */
	public static Student getStudent(int id){
		Student student = null;
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.get(id))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String father_name = res.getString("father_name");
				String email = res.getString("email");
				int class_student = res.getInt("class");
				int age = res.getInt("age");
				 student = new Student(id,firstName,lastName,father_name,email,class_student,age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	/**
	 * Updates Student
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param father_name
	 * @param email
	 * @param class_student
	 * @param age
	 * @return true or false depending on whether student is updated or not
	 */
	public static boolean updateStudent(int id,String first_name,String last_name,String father_name, String email,int class_student,int age){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.update(id,first_name, last_name, father_name, email, class_student, age))){    
			p.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}