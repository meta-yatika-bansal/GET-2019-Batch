/*
 * Servlet To Update Employee
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String full_name=request.getParameter("full_name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String contact_number=request.getParameter("contact_number");
		String org=request.getParameter("org");
		String password=request.getParameter("password");
		if(Helper.updateEmployee(new Employee(employee_id,full_name,gender,email,password,contact_number,org))){
			out.print("Successfully Updated!");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/EditEmployeeServlet");
			out.println("Some Error Occurred!");
			rd.include(request, response);
		}
	}
}
