/*
 * Class for JDBC Connection
 */
import java.sql.*;

public class JDBC {

	public Connection makeConnection(){
		final String URL = "jdbc:mysql://localhost:3306/StoreFront";
		final String USER= "root";
		final String PASS= "root";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		}
		catch(SQLException e){
			System.out.println(e);
			return null;
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
			return null;
		}
	}
}
