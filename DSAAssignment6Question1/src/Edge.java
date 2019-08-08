/*
 * Represents Edge of graph
 */
import java.util.Comparator;

public class Edge implements Comparator<Edge>{
	
	private int vertex1;
	private int vertex2;
	private int weight;
	
	public Edge(int v1, int v2,int weight) {
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.weight = weight;
	}

	public int getVertex1() {
		return vertex1;
	}

	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public void setVertex2(int vertex2) {
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Comparator for sorting edge collection based on edge's weight
	 */
	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.getWeight()-e2.getWeight();
		}
	};

	@Override
	public int compare(Edge o1, Edge o2) {
		return 0;
	}
}
