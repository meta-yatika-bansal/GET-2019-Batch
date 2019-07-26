/*
 * Square Class
 * Input will be side and origin of triangle
 */
import java.util.*;

public class Square implements Shape{
	int side;
	Point origin;

	Square(Point point, List<Integer> list){
		side = list.get(0);
		origin = point;
	}
	
	@Override
	public double getArea() {
		return side*side;
	}

	@Override
	public double getPerimeter() {
		return 4*side;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(((side + origin.x) >= point.x  && point.x>= origin.x ) &&
				((side + origin.y) >= point.y  &&  point.y>= origin.y)){
			return true;
		}else{
			return false;
		}
	}
}
