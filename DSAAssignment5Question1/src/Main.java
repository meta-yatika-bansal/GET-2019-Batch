import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadListOfPair pair = new ReadListOfPair();
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "false");
		map.put("2", "even");
		map.put("-1", "exception");
		//map.put("1", "true");
		ImplementDictionary dictionary = new ImplementDictionary(map);
		dictionary.add("3", "me");
		//dictionary.delete("0");
		//System.out.println(dictionary.getValue("0"));
	}

}
