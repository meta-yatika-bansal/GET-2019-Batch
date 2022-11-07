/*
 * Represents order made by a user
 */
import java.util.Date;

public class Order {
	
	int id;
	double amount;
	Date date = new Date();
	public Order() {}
	
	public Order(int id, double amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
}
