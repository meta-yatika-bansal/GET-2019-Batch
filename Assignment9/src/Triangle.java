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
	public ShapeType type = ShapeType.Triangle;

	Triangle(Point point, List<Integer> list){
		side1 = list.get(0);
		side2 = list.get(1);
		base = list.get(2);
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
		double height = Math.sqrt((side2*side2)-(base*base));
		return 0.5*base*height;
	}

	/**
	 * Returns Perimeter of Shape
	 */
	@Override
	public double getPerimeter() {
		return (base + side1 + side2);
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
		try{
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
		}catch(Exception e){
			System.out.println("isPointEnclosed");
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
		try{
			double distance = Math.sqrt((b.x - point.x)*(b.x - point.x) + (b.y - point.y)*(b.y - point.y));
			return 0.5*a*distance;
		}catch(Exception e){
			System.out.println("AreaOfSmallerTriangles");
			return 0;
		}
	}
}