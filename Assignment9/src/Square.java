/*
 * Square Class
 * Input will be side and origin of Square
 */
import java.util.*;

public class Square implements Shape{
	int side;
	Point origin;
	public ShapeType type = ShapeType.Square;

	Square(Point point, List<Integer> list){
		side = list.get(0);
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
		return side*side;
	}

	/**
	 * Returns Perimeter of Shape
	 */
	@Override
	public double getPerimeter() {
		return 4*side;
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
			if(((side + origin.x) >= point.x  && point.x>= origin.x ) &&
					((side + origin.y) >= point.y  &&  point.y>= origin.y)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println("isPointEnclosed");
			return false;
		}
	}
}