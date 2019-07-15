/**
 * Contains functions for calculating area of different shapes.
 */
public class AreaFunctions {
	
	/**
	 * Calculates area of Triangle
	 * @param width width of triangle
	 * @param height height of triangle
	 * @return calculated area of triangle
	 */
	double AreaTriangle(double width , double height){
	    final double AREA_FACTOR_TRIANGLE=0.5;
		return (AREA_FACTOR_TRIANGLE*width*height);
	}
	
	/**
	 * Calculates area of Rectangle
	 * @param width width of Rectangle
	 * @param height height of Rectangle
	 * @return calculated area of Rectangle
	 */
	double AreaRectangle(double width , double height){
		return (width*height);
	}
	
	/**
	 * Calculates area of Square
	 * @param width side of Square
	 * @return calculated area of Square
	 */
	double AreaSquare(double width){
		return (width*width);
	}
	
	/**
	 * Calculates area of Circle
	 * @param radius radius of Circle
	 * @return calculated area of Circle
	 */
	double AreaCircle(double radius){
        return (Math.PI*radius*radius);
	}
}
