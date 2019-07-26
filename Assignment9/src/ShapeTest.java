/*
 * Test Case for Screen Class
 */
import static org.junit.Assert.*;
import java.util.*;

public class ShapeTest {

	ClassScreen screen = new ClassScreen(100, 100);
	Point point;
	List<Integer> list;
	
	@Test
	public void addObjectTest() {
		point.x = 0;
		point.y = 0;
		list.add(2);
		screen.addObject(Circle, point, list);
		screen.addObject(Square, point, list);
		screen.addObject(Circle, point, list);
	}
	
	@Test
	public void deleteObjectTest() {
		screen.deleteObject(Circle, point, list);
	}
	
	@Test
	public void deleteObjectOfSpecificTypeTest() {
		screen.deleteObjectOfSpecificType(Circle);
	}
	
	@Test
    public void sortedTest() {
		List<Shape> shape;
		shape.add(Circle, point, list);
		shape.add(Circle, point, list);
		shape.add(Square, point, list);
    	assertEquals(shape, screen.sorted());
    }
	
	@Test
    public void enclosingPointTest() {
		point.x = 2;
		point.y = 3;
		List<Shape> shape;
		shape = null;
    	assertEquals(shape, screen.enclosingPoint(point));
    }
}
