/*
 * Represents Bowler
 */
public class Bowler {
	String name;
	int quota;
	
	public Bowler(){
		this.name = "first";
		this.quota = Integer.MAX_VALUE;
	}
	
	public Bowler(String name, int quota){
		this.name = name;
		this.quota = quota;
	}
}
