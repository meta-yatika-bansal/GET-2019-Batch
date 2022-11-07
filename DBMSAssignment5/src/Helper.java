/*
 * Helper Class to execute queries
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Helper{

	/**
	 * Gets Order Details of a given user
	 * @param id of user
	 * @return list of orders made by user
	 */
	public List<Order> getOrderDetails(int id) {
		List<Order> orders = new ArrayList<Order>();
		JDBC j = new JDBC();
		try(Connection c = j.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.orderDetails(id))){
			ResultSet res= p.executeQuery();
			while(res.next()){
				int o_id = res.getInt("order_id");
				double o_amount = res.getDouble("order_amount");
				Date o_date = res.getDate("order_date");
				orders.add(new Order(o_id,o_amount,o_date));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return orders;
	}

	/**
	 * Inserts Image of a given product
	 * @param product_id of product
	 * @param url of the image
	 * @return number of Images inserted
	 */
	public int insertImage(int product_id,List<String> url){
		JDBC j = new JDBC();
		try(Connection c = j.makeConnection()){
			PreparedStatement p = c.prepareStatement(Query.imageDetails());
			c.setAutoCommit(false);
			for(String i : url){
				p.setInt(1, product_id);
				p.setString(2, i);
				p.addBatch();
			}

			int[] res = p.executeBatch();
			c.commit();
			return res.length;
		}catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Deletes Product from database
	 * @return Number of deleted products
	 */
	public int deleteProduct(){
		JDBC j = new JDBC();
		ResultSet productDeleted ;
		try(Connection c = j.makeConnection();
				PreparedStatement p1 = c.prepareStatement(Query.updateProductDetails())){
			    return p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets Category details of all Top Categories
	 * @return list of categories along with their child categories
	 */
	public List<Category> getCategoryDetails(){
		List<Category> category = new ArrayList<Category>();
		JDBC j = new JDBC();
		try(Connection c = j.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.categoryDetails())){
			    ResultSet res = p.executeQuery();
			    while(res.next()){
			    	String parent = res.getString("category_name");
			    	int count = res.getInt("child");
			    	category.add(new Category(parent,count));
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return category;
	}
}
