/*
 * Contains Output HTML page
 */
import java.util.List;

public class Output {
	
	/**
	 * Displays list of students as HTML page
	 * @param students
	 * @return page as string
	 */
	public static String printOutput(List<Student> students){
		String res = "<html>"
				+"<h3>List Of Student</h3>"
				+"<table>"
				+"<tr><td>Student Id </td><td>First Name </td><td>Last Name </td><td>Father Name </td><td>Email </td><td>Class </td><td>Age </td></tr>";
		for(Student student : students){
			 res += "<tr><td>" +student.id +"</td><td>"+ student.first_name +" </td><td>"+student.last_name+" </td><td>"+student.father_name +" </td><td>"+student.email+" </td><td>"+student.class_student+" </td><td>"+student.age+" </td></tr>";
		}
		
		return res;
	}
	
	/**
	 * Displays list with update link as HTML Page
	 * @param students
	 * @return page as string
	 */
	public static String printOutputWithLink(List<Student> students){
		String res = "<html>"
				+"<h3>List Of Student</h3>"
				+"<table>"
				+"<tr><td>Student Id </td><td>First Name </td><td>Last Name </td><td>Father Name </td><td>Email </td><td>Class </td><td>Age </td><td>Update </td></tr>";
		for(Student student : students){
			 res += "<tr><td>" + student.id+" </td><td>" + student.first_name +" </td><td>"+student.last_name+" </td><td>"+student.father_name +" </td><td>"+student.email+" </td><td>"+student.class_student+" </td><td>"+student.age+" </td><td>"
		            +"<a href='UpdateStudentServlet?id=" +student.id+ "'> Update </a></td></tr>";
		}
		
		return res;
	}
}