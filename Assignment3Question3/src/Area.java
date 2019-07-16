/*
 * Calculates the area of different shapes.
 * Input is the dimension of the shape.
 * Dimensions are assumed to be positive.
 * @since 15-July-2019
 */
import java.util.*;

public class Area {

	public static void main(String[] args) {
		AreaFunctions area=new AreaFunctions();
		int choice;
		double width;
		double height;
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("Area Calculation :");
			System.out.println("Enter the serial number of your desired shape");
			System.out.println("1.Triangle");
			System.out.println("2.Rectangle");
			System.out.println("3.Square");
			System.out.println("4.Circle");
			choice = sc.nextInt();

			switch(choice){
			case 1:
				System.out.println("Enter the width and height");
				width=sc.nextDouble();
				height=sc.nextDouble();
				System.out.println("Ärea: "+area.AreaTriangle(width, height));
				break;
			case 2:
				System.out.println("Enter the width and height");
				width=sc.nextDouble();
				height=sc.nextDouble();
				System.out.println("Ärea: "+area.AreaRectangle(width, height));
				break;
			case 3:
				System.out.println("Enter the width");
				width=sc.nextDouble();
				System.out.println("Ärea: "+area.AreaSquare(width));
				break;
			case 4:
				System.out.println("Enter the radius");
				width=sc.nextDouble();
				System.out.println("Ärea: "+area.AreaCircle(width));
				break;
			default:
				System.out.println("Please Enter correct serial number");
			}

			sc.close();
		}catch(Exception e){
			System.out.println("Enter properly!");
		}
	}
}
