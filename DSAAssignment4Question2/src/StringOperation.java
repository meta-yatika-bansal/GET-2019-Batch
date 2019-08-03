/*
 * Defines operation on String
 */
import java.util.*;

public class StringOperation {
	Map<String, Integer> cacheResult = new HashMap<String, Integer>();

	/**
	 * Counts unique characters in given string
	 * @param string is the input string
	 * @return number of unique characters
	 */
	public int countUniqueCharacters(String string){
		try{
			if(cacheResult.containsKey(string)){
				System.out.println("Cached Result!");
				return cacheResult.get(string);
			}else{
				System.out.println("Calculated Result!");
				int countUnique = 0;
				for(int i = 0 ; i < string.length() ; i++){
					if(search(string.charAt(i), string) == 1){
						countUnique++;
					}
				}

				cacheResult.put(string, countUnique);
				return countUnique;
			}
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}

	/**
	 * Searches given character in a string
	 * @param c is the character to be searched 
	 * @param string is the input string
	 * @return number of occurrence of character
	 */
	private int search(char c, String string){
		int count = 0;
		for(int i = 0 ; i < string.length() ; i++){
			if(string.charAt(i) == c){
				count++;
			}
		}

		return count;
	}
}
