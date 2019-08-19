/*
 * Represents order made by a user
 */
public class Order {
	
	int id;
	double amount;
	String date;
	public Order() {}
	
	public Order(int id, double amount, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
}
