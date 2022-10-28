/*
 * Rectangle Class
 * Inputs will be length, breadth and origin of Rectangle
 */
import java.util.List;

public class Rectangle implements Shape{
	int length;
	int breadth;
	Point origin;
	public ShapeType type = ShapeType.Rectangle;

	public Rectangle(Point point, List<Integer> list){
		length = list.get(0);
		breadth = list.get(1);
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
		return length*breadth;
	}

	/**
	 * Returns Perimeter of Shape
	 */
	@Override
	public double getPerimeter() {
		return (2*length + 2*breadth);
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
			if(((length + origin.x) >= point.x  && point.x>= origin.x ) &&
					((breadth + origin.y) >= point.y  &&  point.y>= origin.y)){
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