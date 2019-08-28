/*
 * Updates Database
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String father_name = request.getParameter("father_name");
		String email = request.getParameter("email");
		int class_student = Integer.parseInt(request.getParameter("class"));
		int age = Integer.parseInt(request.getParameter("age"));
		int id = Integer.parseInt(request.getParameter("id"));
		if(Helper.updateStudent(id, first_name, last_name, father_name, email, class_student, age)){
			out.print("Successfully Updated!");
		}else{
			out.println("Some Error Occurred!");
		}
	}
}
