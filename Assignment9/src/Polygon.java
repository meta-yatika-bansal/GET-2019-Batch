/*
 * Polygon Class
 * Inputs will be side length, number of sides and origin of Polygon
 */
import java.util.List;

public class Polygon implements Shape{
	int length;
	int numberOfSides;
	Point origin;
	public ShapeType type = ShapeType.Regular_Polygon;

	Polygon(Point point, List<Integer> list){
		length = list.get(0);
		numberOfSides = list.get(1);
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
		return ((length*length*numberOfSides)/(4*Math.tan(180/numberOfSides)));
	}

	/**
	 * Returns Perimeter of Shape
	 */
	@Override
	public double getPerimeter() {
		return (length*numberOfSides);
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
		int total = 0;
		for(int number = 1; number <= numberOfSides ; number++){
			Point pointBase = point;
			pointBase.x = origin.x + length/2;
			pointBase.y = origin.y ;
			double a1 = AreaOfSmallerTriangles(length, point, pointBase );
			total += a1;
			pointBase.y += length/2;  
		}
		
		double a = getArea();
		
		if(a == total) {
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * Finds area of smaller triangles in Shape
	 * @param a is the baseLength
	 * @param b is the point used to calculate height
	 * @param point is the mid-point of base
	 * @return area
	 */
	public double AreaOfSmallerTriangles(double a, Point b , Point point){
		double distance = Math.sqrt((b.x - point.x)*(b.x - point.x) + (b.y - point.y)*(b.y - point.y));
		return 0.5*a*distance;
	}
}
