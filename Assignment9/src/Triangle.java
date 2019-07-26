/*
 * Triangle Class
 * Inputs will be three sides and origin of triangle
 */
import java.util.List;

public class Triangle implements Shape{
	Shape.ShapeType type1 = ShapeType.Triangle;
	int side1;
	int side2;
	int base;
	Point origin;

	Triangle(Point point, List<Integer> list){
		side1 = list.get(0);
		side2 = list.get(1);
		base = list.get(2);
		origin = point;
	}
	
	public ShapeType getShape(){
		return type1;
	}

	@Override
	public double getArea() {
		double height = Math.sqrt((side2*side2)-(base*base));
		return 0.5*base*height;
	}

	@Override
	public double getPerimeter() {
		return (base + side1 + side2);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		Point pointBase = point;
		pointBase.x = origin.x + base/2;
		pointBase.y = origin.y ;
		double a1 = AreaOfSmallerTriangles(base, point, pointBase );
		pointBase.x = origin.x + side1/2;
		pointBase.y = origin.y + side1/2;
		double a2 = AreaOfSmallerTriangles(side1, point, pointBase );
		pointBase.x = origin.x - side2/2;
		pointBase.y = origin.y + side2/2 ;
		double a3 = AreaOfSmallerTriangles(side2, point, pointBase );
		double a = getArea();
		if(a == (a1 + a2 + a3)) {
			return true;
		}else {
			return false;
		}	
	}

	public double AreaOfSmallerTriangles(double a, Point b , Point point){
		double distance = Math.sqrt((b.x - point.x)*(b.x - point.x) + (b.y - point.y)*(b.y - point.y));
		return 0.5*a*distance;
	}
}