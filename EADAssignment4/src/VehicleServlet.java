/*
 * Servlet To Add Vehicle
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		int vehicle_number = Integer.parseInt(request.getParameter("vehicle_number"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String identification = request.getParameter("identification");
		Vehicle v = new Vehicle(name,type,vehicle_number,employee_id,identification);
		if(Helper.addVehicle(v)){
			out.println(Output.passDetails(Helper.getVehiclePrice(type)));
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/VehiclePage.html");
			out.println("Employee Id doesnt't exist!");
			rd.include(request, response);
		}
	}
}
