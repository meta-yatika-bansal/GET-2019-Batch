
/**Interface to support arithmetic in any base.*/
public interface AnyBaseArithmetic {
	
	String DecimalToBase(int decimalNumber,int base);
	int BaseToDecimal(String baseNumber,int base);
	String Add(String baseNumber1 ,String baseNumber2 ,int base);
	String Subtract(String baseNumber1 ,String baseNumber2 ,int base);
	String Multiply(String baseNumber1 ,String baseNumber2 ,int base);
	String Divide(String baseNumber1 ,String baseNumber2 ,int base);
	Boolean Equality(String baseNumber1 ,String baseNumber2 );
	Boolean GreaterThan(String baseNumber1 ,String baseNumber2 );
	Boolean LessThan(String baseNumber1 ,String baseNumber2 );
}
