/*
 * Reads key-value pair from JSON
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;

public class ReadListOfPair
{
	static Map<String, String> map = new HashMap<String, String>();
	@SuppressWarnings("unchecked")
	public static Map<String, String> readListOfPair(){
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("ListOfKeyValuePairs.json")){
			Object obj = jsonParser.parse(reader);

			JSONArray nodeList = (JSONArray) obj;
			System.out.println(nodeList);

			nodeList.forEach( n -> parseNodeObject( (JSONObject) n ) );

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	private static void parseNodeObject(JSONObject node){
		JSONObject nodeObject = (JSONObject) node.get("node");
		map.put((String) nodeObject.get("key"), (String) nodeObject.get("value"));  
	}
}