/*
 * Factory Class creates object based on inputs by user
 */
import java.util.*;

public class Factory {
	
	static Shape createShape(String type, Point point, List<Integer> list) {
		
		switch(type) {
		    case "Square":
		    	return new Square(point, list);
		    
		    case "Circle":
		    	return new Circle(point, list);
		   
		    case "Rectangle": 
		    	return new Rectangle(point, list);
		    
		    case "Triangle":
		    	return new Triangle(point, list);
		   
		    case "Regular_Polygon":
		    	return new Polygon(point, list);
		    
		    default:
		    	System.out.println("Please Enter proper shape!");
		        return null;
		}
	}
}
