/*
 * This class represents a rectangular Screen
 * Left-Bottom corner is assumed to be origin i.e <0,0>
 */
import java.util.*;
import java.sql.Timestamp;

public class ClassScreen {
	List<Shape> shapeObjects = new ArrayList<>();
	List<Timestamp> time = new ArrayList<>();
	Point origin ;

	ClassScreen(int XMAX, int YMAX){
		origin.x = 0;
		origin.y = 0;
		List<Integer> list;
		list.add(XMAX);
		list.add(YMAX);
	}
	
	/**
	 * Adds Shape to Screen
	 * @param type is the type of shape
	 * @param point is the origin of shape
	 * @param list is the list of parameters required to draw a shape
	 */
	public void addObject(Shape.ShapeType type, Point point, List<Integer> list) {
		Timestamp ts = new Timestamp(new Date().getTime());
		Shape shape = Factory.createShape(type, point, list);
		shapeObjects.add(shape);
		time.add(ts);
	}

	/**
	 * Deletes Shape from Screen
	 * @param type is the type of shape
	 * @param point is the origin of shape
	 * @param list is the list of parameters required to find the shape
	 */
	public void deleteObject(Shape.ShapeType type, Point point, List<Integer> list) {
		Shape shape = Factory.createShape(type, point, list);
		int index = shapeObjects.indexOf(shape);
		shapeObjects.remove(index);
	}

	/**
	 * Deletes all Shapes  of a type from Screen
	 * @param type is the type of shape
	 */
	public void deleteObjectOfSpecificType(Shape.ShapeType type) {
		for(int i = 0 ; i < shapeObjects.size() ; i++) {
			if(shapeObjects.get(i).g == type ) {
				shapeObjects.remove(i);
			}
		}
	}

	/**
	 * Sorts the list of shapes on screen in Ascending order
	 * @return the sorted list of shapes 
	 */
	public List<Shape> sorted(){
		for(int i = 0 ; i < shapeObjects.size()-1 ; i++) {
			for(int j = 0 ; j < shapeObjects.size()-i-1 ; j++){
				if(shapeObjects.get(j).getArea() > shapeObjects.get(j+1).getArea()) {
					swapShape(shapeObjects.get(j), shapeObjects.get(j+1));
				}//else if(shapeObjects.get(j).getPerimeter() )
			}
		}
		return shapeObjects;
	}

	/**
	 * Swap function
	 * @param shape1 is the first shape to be swapped
	 * @param shape2 is the second shape to be swapped
	 */
	public void swapShape(Shape shape1, Shape shape2) {
		Shape swap;
		swap = shape1;
		shape1 = shape2;
		shape2 = swap;
	}

	/**
	 * Finds the list of shapes enclosing a given point
	 * @param point is the point to be enclosed
	 * @return list of shapes enclosing given point
	 */
	public List<Shape> enclosingPoint(Point point){
		List<Shape> shapeList = new ArrayList<>();
		for(Shape i : shapeObjects) {
			if(i.isPointEnclosed(point)) {
				shapeList.add(i);
			}
		}
		return shapeList;
	}
}
