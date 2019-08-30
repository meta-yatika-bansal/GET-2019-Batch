/*
 * Servlet for Employee Login
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String actualPass = Helper.authEmployee(email);
		Employee e = Helper.getEmployeeByEmail(email);
		if(password.equals(actualPass)){
			HttpSession session = request.getSession(true);
			session.setAttribute("logged in", "true");
			out.println(Output.printOutputWithLink(e,true));
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
			out.println("Authentication Failed!");
			rd.include(request, response);
		}
	}
}
