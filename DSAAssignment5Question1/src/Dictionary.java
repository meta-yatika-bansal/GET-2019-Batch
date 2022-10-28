/*
 * Represents Dictionary
 */
import java.util.*;

public interface Dictionary {
	
	public void add(String key, String value);
	public boolean delete(String key);
	public String getValue(String key);
	public List<Node> sort();
	public List<Node> sortSublist(String K1, String K2);
}
