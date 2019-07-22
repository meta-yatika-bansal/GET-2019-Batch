
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] coefficient = {1, 2, 1};
	 int[] exponent = {2, 1, 0};
		 int[] coefficient1 = {1, 6};
		 int[] exponent1 = {1, 0};
		// int[] coefficientAdd = {1,3,12};
		 //int[] exponentAdd = {2,1,0};
		 Poly poly = new Poly(coefficient,exponent);
		Poly poly1 = new Poly(coefficient1,exponent1);
		 Poly polyAdd;
		 polyAdd=poly.addPoly(poly, poly1);
		 for(int i=0;i<polyAdd.getCoefficient().length;i++){
			 System.out.println(polyAdd.getCoefficient());
		 }
	}

}
