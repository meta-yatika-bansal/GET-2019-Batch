/*
 * Writes key-value pair to JSON
 */
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class ListOfKeyValuePairs{
	
    @SuppressWarnings("unchecked")
    public static void main( String[] args ){
        
        JSONObject node = new JSONObject();
        node.put("key", "0");
        node.put("value", "false");
         
        JSONObject nodeObject = new JSONObject();
        nodeObject.put("node", node);
         
        JSONObject node1 = new JSONObject();
        node1.put("key", "2");
        node1.put("value", "even");
         
        JSONObject nodeObject1 = new JSONObject();
        nodeObject1.put("node", node1);
         
        JSONObject node2 = new JSONObject();
        node2.put("key", "-1");
        node2.put("value", "exception");
         
        JSONObject nodeObject2 = new JSONObject();
        nodeObject2.put("node", node2);
         
        JSONObject node3 = new JSONObject();
        node3.put("key", "1");
        node3.put("value", "true");
         
        JSONObject nodeObject3 = new JSONObject();
        nodeObject3.put("node", node3);
         
        JSONArray NodeList = new JSONArray();
        NodeList.add(nodeObject);
        NodeList.add(nodeObject1);
        NodeList.add(nodeObject2);
        NodeList.add(nodeObject3);

         
        try (FileWriter file = new FileWriter("ListOfKeyValuePairs.json")) {
            file.write(NodeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
