/*
 * Test Case for Screen Class
 */
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShapeTest {

	ClassScreen screen;
	Point point;
	List<Integer> list;
	Point origin;

	@Before
	public void initialize(int XMAX, int YMAX){
		origin.x = 0;
		origin.y = 0;
		List<Integer> list1 = list;
		list1.add(XMAX);
		list1.add(YMAX);
		screen = new ClassScreen(origin, list1);
	}

	@Test
	public void addObjectTest() {
		point.x = 0;
		point.y = 0;
		list.add(2);
		screen.addObject("Circle", point, list);
		screen.addObject("Square", point, list);
		screen.addObject("Circle", point, list);
	}

	@Test
	public void deleteObjectTest() {
		screen.deleteObject("Triangle", point, list);
	}

	@Test
	public void deleteObjectOfSpecificTypeTest() {
		screen.deleteObjectOfSpecificType("Triangle");
	}

	@Test
	public void sortedTest() {
		assertEquals(true, screen.sorted());
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
