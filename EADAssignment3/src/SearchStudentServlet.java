/*
 * Searches Student in Database
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean select = false;
		List<Student> students = null;
		PrintWriter out = response.getWriter();
		String key=request.getParameter("search");
		if("selected".equals(request.getParameter("filter"))){
			select = true;
		}
		students = Helper.searchStudent(key,select);
		out.print(Output.printOutput(students));
	}
}
