import java.util.List;
public class Rectangle implements Shape{
	int length;
	int breadth;
	Point origin;

	Rectangle(Point point, List<Integer> list){
		length = list.get(0);
		breadth = list.get(1);
		origin = point;
	}
	
	@Override
	public double getArea() {
		return length*breadth;
	}

	@Override
	public double getPerimeter() {
		return (2*length + 2*breadth);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(((length + origin.x) >= point.x  && point.x>= origin.x ) &&
				((breadth + origin.y) >= point.y  &&  point.y>= origin.y)){
			return true;
		}else{
			return false;
		}
	}

}
