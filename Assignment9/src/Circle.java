import java.util.List;
public class Circle implements Shape{
	int radius;
	Point origin;

	Circle(Point point, List<Integer> list){
		radius = list.get(0);
		origin = point;
	}
	
	@Override
	public double getArea() {
		return (Math.PI*radius*radius);
	}

	@Override
	public double getPerimeter() {
		return (2*Math.PI*radius);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

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
