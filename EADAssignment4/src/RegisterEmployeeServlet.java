/*
 * Servlet For Employee Registration
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String full_name=request.getParameter("full_name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String contact_number=request.getParameter("contact_number");
		String org=request.getParameter("org");
		String repass=request.getParameter("repass");
		String password=request.getParameter("password");
		if(password.equals(repass)){
			Employee e = new Employee(full_name,gender,email,password,contact_number,org);
			int id=Helper.addEmployee(e) ;
			if(id != 0){
				RequestDispatcher rd = request.getRequestDispatcher("/VehiclePage.html");
				out.println("Successfully Registered! Your Employee Id is :" + id);
				rd.include(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/RegisterPage.html");
				out.print("Some error occurred!");
				rd.include(request, response);
			}	
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/RegisterPage.html");
			out.println("Passwords Don't Match!");
			rd.include(request, response);
		}
	}
}
