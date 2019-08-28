/*
 * Displays Update Student Form
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = Helper.getStudent(id);
		PrintWriter out = response.getWriter();
		String onUpdate = "<html>"
		+"<form method='get' action='UpdateDatabase'>"
		+"<h3>Update Student</h3>"
		+"<table>"
		+"<tr><td>Student Id<td><td><input type='text' name='id' value ='"+ student.id +"'readonly></td></tr>"
		+"<tr><td>First Name<td><td><input type='text' name='first_name' value ='"+ student.first_name +"'></td></tr>"
		+"<tr><td>Last Name<td><td><input type='text' name='last_name' value ='"+ student.last_name +"'></td></tr>"
		+"<tr><td>Father Name<td><td><input type='text' name='father_name' value ='"+ student.father_name +"'></td></tr>"
		+"<tr><td>Email Name<td><td><input type='text' name='email' value ='"+ student.email +"'></td></tr>"
		+"<tr><td>Class<td><td><input type='text' name='class' value ='"+ student.class_student +"'></td></tr>"
		+"<tr><td>Age<td><td><input type='text' name='age' value ='"+ student.age +"'></td></tr>"
		+"</table>"
		+"<input type = 'submit' value='Update'/>"
		+"</form>";
		out.print(onUpdate);
	}
}
