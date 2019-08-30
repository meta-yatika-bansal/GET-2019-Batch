/*
 * Servlet to Show Pass Price
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		double price = Double.parseDouble(request.getParameter("plan"));
		String currency = request.getParameter("currency");
		if("USD".equals(currency)){}
		else if("INR".equals(currency)){
			price=price*71.73;
		}else{
			price= price*106.27;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
		out.println("Pass price is : "+ price);
		rd.include(request, response);
	}
}
