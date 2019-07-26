/*
 * Polygon Class
 * Inputs will be side length, number of sides and origin of Polygon
 */
import java.util.List;

public class Polygon implements Shape{
	int length;
	int numberOfSides;
	Point origin;

	Polygon(Point point, List<Integer> list){
		length = list.get(0);
		numberOfSides = list.get(1);
		origin = point;
	}

	@Override
	public double getArea() {
		return ((length*length*numberOfSides)/(4*Math.tan(180/numberOfSides)));
	}

	@Override
	public double getPerimeter() {
		return (length*numberOfSides);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
      //need to implement yet
		return false;
	}
}
