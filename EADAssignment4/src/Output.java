/*
 * Contains Output as HTML Pages
 */
import java.util.List;

public class Output {

	public static String passDetails(double[] price){
		String s = "<div align='center'>"
				+"<form method='get' action='PassServlet'>"
				+"<p>1. Select Plans in (USD)</p>"
				+"<select name = 'plan'>"
				+" <option  value= '"+ price[0] +"'/>" + price[0] + " Daily</option>"
				+ " <option value= '"+ price[1] +"'/>" + price[1] + " Monthly</option>"
				+ " <option value= '"+ price[2] +"'/>" + price[2] + " Yearly</option>"
				+" </select></br></br>"
				+ "<p>2. Do You Want To Change Currency</p>"
				+"<select name='currency' align='center'>"
				+"<option  value = 'USD'>USD</option>"
				+ "<option  value= 'INR'>INR</option>"
				+ " <option value= 'YEN'>YEN</option>"
				+"</select>"
				+"<input type='submit' value = 'GetPass'/>"
				+"</div>";
		return s;
	}

	public static String printOutputWithLink(Employee e,boolean showLink){
		String res = "<html>"
				+"<h3>EmployeeDetail</h3>"
				+"<table>"
				+"<tr><td>Employee Id </td><td>Full Name </td><td>Gender </td><td>Email </td><td>Contact Number </td><td>Organization </td></tr>"
				+ "<tr><td>" + e.employee_id+" </td><td>" + e.full_name +" </td><td>"+e.gender+" </td><td>"+e.email +" </td><td>"+e.contact_number+" "
				+ "</td><td>"+e.org+" </td><td></tr></table>";
		if(showLink){
			res += "<a href='EditEmployeeServlet?id=" +e.employee_id+ "'> Edit </a><br>"
					+"<a href='FriendServlet?id=" +e.employee_id+ "'> Friend </a><br>"
					+"<a href='LogOutServlet'> Log Out </a><br>"
					+"<input type='hidden' name='email' value='"+e.email +"'/>";
		}

		return res;
	}

	public static String onUpdate(Employee e){
		String onUpdate = "<html>"
				+"<form method='get' action='UpdateEmployeeServlet'>"
				+"<h3>Update Employee</h3>"
				+"<table>"
				+"<tr><td>Employee Id<td><td><input type='text' name='employee_id' value ='"+ e.employee_id +"'readonly></td></tr>"
				+"<tr><td>Password<td><td><input type='password' name='password' value ='"+e.password +"'></td></tr>"
				+"<tr><td>Full Name<td><td><input type='text' name='full_name' value ='"+e.full_name +"'></td></tr>"
				+"<tr><td>Gender<td><td><input type='text' name='gender' value ='"+ e.gender +"'></td></tr>"
				+"<tr><td>Email<td><td><input type='text' name='email' value ='"+ e.email +"'></td></tr>"
				+"<tr><td>Contact Number<td><td><input type='text' name='contact_number' value ='"+ e.contact_number+"'></td></tr>"
				+"<tr><td>Organization<td><td><input type='text' name='org' value ='"+e.org  +"'></td></tr>"
				+"</table>"
				+"<input type = 'submit' value='Update'/>"
				+"</form>";	
		return onUpdate;
	}

	public static String printFriend(List<Employee> emp){
		String res = "<html>"
				+"<h3>Friends</h3>"
				+"<table>"
				+"<tr><td>Full Name</td><td>Profile</td></tr>";
		for(Employee e:emp){
			res+= "<tr><td>" + e.full_name+ "</td><td><a href='FriendProfileServlet?id="+ e.employee_id+"'>Profile</a></td></tr>";
		}

		return res;
	}
}