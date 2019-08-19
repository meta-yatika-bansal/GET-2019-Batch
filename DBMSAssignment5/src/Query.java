/*
 * Contains Queries made to database
 */
public class Query {

	/**
	 * Query to get details of order from database
	 * @param id of the user
	 * @return query
	 */
	public static String orderDetails(int id){
		String query = "select p.order_id,p.order_date,p.order_amount from product_order as p inner join order_item as o on p.order_id=o.order_id where p.user_id = " + id +
                       " and product_status = 'Shipped' group by order_id order by order_date" ;
		return query;
	}
	
	/**
	 * Query to insert image of a product in database
	 * @return query
	 */
	public static String imageDetails(){
		String query = "insert into image(product_id,url) values(?,?)";
		return query;
	}
	
	/**
	 * Query to update details of product in database
	 * @return query
	 */
	public static String updateProductDetails(){
		String query = "update product as p left outer join order_item as o on p.product_id=o.product_id "
				+ " left outer join product_order as po on po.order_id=o.order_id"
				+ " set p.active = 0"
				+ " where (datediff(curdate(),po.order_date)/365) > 1 "
				+ " or o.order_id is null";
		return query;
	}
	
	/**
	 * Query to get details of category from database
	 * @return query
	 */
	public static String categoryDetails(){
		String query = "select p.category_name,count(c.parent_category_id) as child"
				+ " from category as c inner join category as p on c.parent_category_id=p.category_id"
				+ " group by p.category_name"
				+ " order by p.category_name";
		return query;
	}
}
