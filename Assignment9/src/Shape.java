/*
 * Base Class Shape
 */
public interface Shape {
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	public String getType();
	public enum ShapeType{
		Square, Rectangle, Circle, Triangle , Regular_Polygon;
	}
}
