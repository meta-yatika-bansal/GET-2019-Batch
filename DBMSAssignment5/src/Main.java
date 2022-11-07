/*
 * Main Class
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Helper helper = new Helper();
		List<Order> orders = new ArrayList<Order>();
		List<String> url = new ArrayList<String>();
		List<Category> categories = new ArrayList<Category>();
		
		System.out.println("Enter id of user");
		int id = sc.nextInt();
		orders = helper.getOrderDetails(id);
		for(Order o : orders){
			System.out.println(o.id);
			System.out.println(o.date.toString());
			System.out.println(o.amount);
		}

		url.add("cookerTop.jpg");
		url.add("cookerBottom.jpg");
		url.add("cookerLeft.jpg");
		url.add("cookerRight.jpg");
		url.add("cookerLogo.jpg");
		System.out.println("Enter the id of Product");
		id = sc.nextInt();
		System.out.println("Number of Images Inserted" + helper.insertImage(id, url));
		
		System.out.println("Number Of Products Deleted " + helper.deleteProduct());
		
		categories = helper.getCategoryDetails();
		for(Category c : categories){
			System.out.println("Parent Category :" + c.parent);
			System.out.println("Number of child categories :" + c.numberOfChild);
		}		
	}
}
