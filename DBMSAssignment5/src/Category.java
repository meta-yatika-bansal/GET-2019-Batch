/*
 * Represents Category of Products in StoreFront
 */
public class Category {

	String parent;
	int numberOfChild;
	
	public Category(String parent, int numberOfChild) {
		super();
		this.parent = parent;
		this.numberOfChild = numberOfChild;
	}
}
