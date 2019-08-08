/*
 * Represents Graph
 */
import java.util.List;

public interface Graph {
	boolean isConnected();
	Integer[] reachable(int node);
	List<Edge> minimumSpanningTree();
	int shortestPath(int vertex1, int vertex2);
}
