/*
 * This class represents a rectangular Screen
 * Left-Bottom corner is assumed to be origin i.e <0,0>
 */
import java.util.*;
import java.sql.Timestamp;

public class ClassScreen extends Rectangle{
	List<Shape> shapeObjects = new ArrayList<>();
	List<Timestamp> time = new ArrayList<>();
	Point origin ;

	ClassScreen(Point point, List<Integer> list){
		super(point, list);
	}

	/**
	 * Adds Shape to Screen
	 * @param type is the type of shape
	 * @param point is the origin of shape
	 * @param list is the list of parameters required to draw a shape
	 */
	public void addObject(String type, Point point, List<Integer> list) {
		try{
			Timestamp currentTime = new Timestamp(new Date().getTime());
			Shape shape = Factory.createShape(type, point, list);
			shapeObjects.add(shape);
			time.add(currentTime);
		}catch(Exception e){
			System.out.println("addObject");
		}
	}

	/**
	 * Deletes Shape from Screen
	 * @param type is the type of shape
	 * @param point is the origin of shape
	 * @param list is the list of parameters required to find the shape
	 */
	public void deleteObject(String type, Point point, List<Integer> list) {
		try{
			Shape shape = Factory.createShape(type, point, list);
			int index = shapeObjects.indexOf(shape);
			shapeObjects.remove(index);
		}catch(Exception e){
			System.out.println("deleteObject");
		}
	}

	/**
	 * Deletes all Shapes  of a type from Screen
	 * @param type is the type of shape
	 */
	public void deleteObjectOfSpecificType(String type) {
		try{
			for(int i = 0 ; i < shapeObjects.size() ; i++) {
				if(type.equals(shapeObjects.get(i).getType())) {
					shapeObjects.remove(i);
				}
			}
		}catch(Exception e){
			System.out.println("deleteObjectOfSpecificType");
		}
	}

	/**
	 * Sorts the list of shapes on screen in Ascending order
	 * @return the sorted list of shapes 
	 */
	public boolean sorted(){
		try{
			for(int i = 0 ; i < shapeObjects.size()-1 ; i++) {
				for(int j = 0 ; j < shapeObjects.size()-i-1 ; j++){
					if(shapeObjects.get(j).getArea() > shapeObjects.get(j+1).getArea()) {
						swapShape(shapeObjects.get(j), shapeObjects.get(j+1));
					}
				}
			}

			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * Finds the list of shapes enclosing a given point
	 * @param point is the point to be enclosed
	 * @return list of shapes enclosing given point
	 */
	public List<Shape> enclosingPoint(Point point){
		try{
			List<Shape> shapeList = new ArrayList<>();
			for(Shape i : shapeObjects) {
				if(i.isPointEnclosed(point)) {
					shapeList.add(i);
				}
			}

			return shapeList;
		}catch(Exception e){
			System.out.println("enclosingPoint");
			return null;
		}
	}
	
	/**
	 * Swap function
	 * @param shape1 is the first shape to be swapped
	 * @param shape2 is the second shape to be swapped
	 */
	private void swapShape(Shape shape1, Shape shape2) {
		Shape swap;
		swap = shape1;
		shape1 = shape2;
		shape2 = swap;
	}
}