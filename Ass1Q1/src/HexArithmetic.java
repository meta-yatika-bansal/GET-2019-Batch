
/** Helper class to the main class.Contains all the operations*/
public class HexArithmetic implements AnyBaseArithmetic{
	String hex[]= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	/**Checks if given number is HexaDecimal.
	 * @param baseNumber HexaDecimal number to be checked. 
	 * @return true or false.
	 */
	public boolean isHexaDecimal(String baseNumber) {
		for(int i = 0; i< baseNumber.length() ; i++) {
			char ch= baseNumber.charAt(i);
			if(!(ch>=0 && ch<=9 || ch >='A' && ch<='F')){
				return false;
			}
		}
		return true;
	}
	
	/**Converts Decimal number to HexaDecimal number.
	 * @param decimalNumber decimal number to be converted.
	 * @return HexaDecimal number.
	 */
	public String DecimalToBase(int decimalNumber,int base) {
		int number = decimalNumber;
		int remainder;
		String hexNumber="";
		if(number>=0 && number<=15) {
			return hex[number];
		}
		while(number!=0) {
			remainder = number % base ;
			number = number/base ;
			hexNumber = hex[remainder] + hexNumber;
		}
		return hexNumber;
	}
	
	/**Converts HexaDecimal number to Decimal number.
	 * @param baseNumber HexaDecimal to be converted.
	 * @return Decimal number.
	 */
	public int BaseToDecimal(String baseNumber,int base) {
		String hexNumber = baseNumber;
		int number = 0;
		int factor=1;
		int len = hexNumber.length();
		for(int i = len-1 ; i >=0 ;i--) {
			if(hexNumber.charAt(i)>='0'&& hexNumber.charAt(i)<='9') {
			    number = number + (hexNumber.charAt(i))*factor;
			    factor= factor*base;
			}else if(hexNumber.charAt(i)>='A'&& hexNumber.charAt(i)<='F') {
				number = number + (hexNumber.charAt(i)-55)*factor;
			    factor= factor*base;
			}
		}
		return number;
	}
	
	/**Adds two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number to be added.
	 *  @param baseNumber2 HexaDecimal number to be added.
	 *  @return HexaDecimal number as result.
	 */
	public String Add(String baseNumber1 ,String baseNumber2 ,int base) {
		int number1 = BaseToDecimal(baseNumber1,base);
		int number2 = BaseToDecimal(baseNumber2,base);
		return DecimalToBase((number1 + number2),base);	
	}
	
	/**Subtracts two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number to be subtracted.
	 * @param baseNumber2 HexaDecimal number to be subtracted.
	 *  @return HexaDecimal number as result.
	 */
	public String Subtract(String baseNumber1 ,String baseNumber2 ,int base) {
		int number1 = BaseToDecimal(baseNumber1,base);
		int number2 = BaseToDecimal(baseNumber2,base);
		return DecimalToBase(Math.abs(number1 - number2),base);	
	}
	
	/**Multiplies two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number to be multiplied.
	 *  @param baseNumber2 HexaDecimal number to be multiplied.
	 *  @return HexaDecimal number as result.
	 */
	public String Multiply(String baseNumber1 ,String baseNumber2,int base ) {
		int number1 = BaseToDecimal(baseNumber1,base);
		int number2 = BaseToDecimal(baseNumber2,base);
		return DecimalToBase((number1 * number2),base);	
	}
	
	/**Divides two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number as numerator.
	 *  @param baseNumber2 HexaDecimal number as denominator.
	 *  @return HexaDecimal number as result.
	 */
	public String Divide(String baseNumber1 ,String baseNumber2 ,int base) {
		int number1 = BaseToDecimal(baseNumber1,base);
		int number2 = BaseToDecimal(baseNumber2,base);
		 return DecimalToBase((number1 / number2),base);	
	}
	
	/**Compares two HexaDecimal numbers for equality.
	 * @param baseNumber1 HexaDecimal number to be compared.
	 *  @param baseNumber2 HexaDecimal number to be compared.
	 *  @return true or false as result.
	 */
	public Boolean Equality(String baseNumber1 ,String baseNumber2 ) {
		if(baseNumber1.length()!=baseNumber2.length()) {
			return false;	
		}
		for(int i = 0;i<baseNumber2.length();i++) {
			if(baseNumber1.charAt(i)!=baseNumber2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**Compares two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number to be compared.
	 *  @param baseNumber2 HexaDecimal number to be compared.
	 *  @param baseNumber1 is assumed to be greater than baseNumber2
	 *  @return true or false as result.
	 */
	public Boolean GreaterThan(String baseNumber1 ,String baseNumber2 ) {
		if(baseNumber1.length() < baseNumber2.length()) {
			return false;	
		}
		for(int i = 0;i<baseNumber2.length();i++) {
			if(baseNumber1.charAt(i) < baseNumber2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**Compares two HexaDecimal numbers.
	 * @param baseNumber1 HexaDecimal number to be compared.
	 * @param baseNumber2 HexaDecimal number to be compared.
	 *  @param baseNumber1 is assumed to be less than baseNumber2
	 *  @return true or false as result.
	 */
	public Boolean LessThan(String baseNumber1 ,String baseNumber2 ) {
		if(baseNumber1.length() > baseNumber2.length()) {
			return false;	
		}
		for(int i = 0;i<baseNumber2.length();i++) {
			if(baseNumber1.charAt(i) > baseNumber2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
