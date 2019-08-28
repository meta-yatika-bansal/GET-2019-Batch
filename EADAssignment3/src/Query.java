/*
 * Contains Queries made to Database
 */
public class Query {
	
	/**
	 * Adds a Student to databse
	 * @param first_name
	 * @param last_name
	 * @param father_name
	 * @param email
	 * @param class_student
	 * @param age
	 * @return query
	 */
	public static String add(String first_name,String last_name,String father_name, String email,int class_student,int age){
		String query = "insert into students(first_name ,last_name,father_name,email,class,age)"
                      +" values('" + first_name + "','" + last_name + "','" + father_name + "','" + email + "'," 
				      +class_student + "," + age +")";
		return query;
	}
	
	/**
	 * Gets Student based on id
	 * @param id
	 * @return query
	 */
	public static String get(int id){
		String query = "Select * from students where id =" + id;
		return query;
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
	 * @return query
	 */
	public static String update(int id,String first_name,String last_name,String father_name, String email,int class_student,int age){
		String query="update students set first_name='"+first_name+"',last_name='"+last_name+"',father_name='"+father_name+"',email='"+email
				+"',class="+class_student+",age="+age
				+" where id="+id;
		return query;
	}
	
	/**
	 * Displays Student
	 * @return query
	 */
	public static String show(){
		String query = "Select * from students";
		return query;
	}
	
	/**
	 * Searches student
	 * @param key
	 * @param select
	 * @return query
	 */
	public static String search(String key,boolean select){
		String query = "select * from students where first_name like '" + key + "%' or last_name like '"
                + key +"%'";
		if(select){
			query += "order by class";
		}
		
		return query;
	}
}