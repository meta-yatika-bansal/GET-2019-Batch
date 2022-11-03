/**
 * Contains helper functions for StringOperation class
 */
public class Operations {
	
	/**
	 * Compares the given Strings for equality
	 * @param str1 String which is passed
	 *  @param str2 String which is passed
	 *  @return 1 or 0
	 */
	public int Equality(String str1 , String str2) {
		if(str1.length() != str2.length()) {
			return 0;	
		}
		for(int i = 0 ; i<str2.length() ; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				return 0;
			}
		}
		
		return 1;
	}
	
	/**
	 * Reverses the given String
	 * @param str String which is passed
	 * @return Reversed String
	 */
	public String Reverse(String str) {
		String rev="";
		for(int i = str.length()-1 ; i>=0 ; i--) {
			rev += str.charAt(i);
		}
		
		return rev;
	}
	
	/**
	 * Converts UpperCase to LowerCase and vice-versa
	 * @param str String which is passed
	 * @return Resultant String after operation
	 */
	public String ChangeCase(String str) {
		final int CAPITAL_LETTER_TO_SMALL_LETTER=32;                               //(A-a) in ASCII
		String opposite="";
		for(int i = 0 ; i<str.length() ; i++){
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				opposite += (char)(str.charAt(i)- CAPITAL_LETTER_TO_SMALL_LETTER);
			}else if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				opposite += (char)(str.charAt(i)+ CAPITAL_LETTER_TO_SMALL_LETTER);
			}else{
				opposite += (char)(str.charAt(i));
			}
		}
		
		return opposite;
	}
	
	/**
	 * Finds Largest word in a given string
	 * @param str String which is passed
	 * @return Largest word found
	 */
	public String LargestWord(String str) {
		String[] words = str.split(" ");
		String longestWord= words[0];
		for(int i =0 ; i< words.length ; i++){
				if(words[i].length()>=longestWord.length()){
					longestWord = words[i];
				}
			}
		return longestWord;
	}
}
