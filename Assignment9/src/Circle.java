/*
 * Circle Class
 * Inputs will be radius and origin of circle
 */
import java.util.List;

public class Circle implements Shape{
	int radius;
	Point origin;
	public ShapeType type = ShapeType.Circle;

	Circle(Point point, List<Integer> list){
		radius = list.get(0);
		origin = point;

	}

	/**
	 * Returns the Shape type of object
	 */
	public String getType(){
		return type.toString();
	}

	/**
	 * Returns Area of Shape
	 */
	@Override
	public double getArea() {
		return (Math.PI*radius*radius);
	}

	/**
	 * Returns Perimeter of Shape
	 */
	@Override
	public double getPerimeter() {
		return (2*Math.PI*radius);
	}

	/**
	 * Returns origin of Shape
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Checks whether a point is enclosed by Shape
	 * @param point is the point to be enclosed
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		Point center = point;
		center.x = origin.x + radius;
		center.y = origin.y + radius;
		double distance = Math.sqrt((point.x-center.x)*(point.x-center.x) 
				+ (point.y-center.y)*(point.y-center.x));
		if(distance <= radius){
			return true;
		}else{
			return false;
		}
	}
}
