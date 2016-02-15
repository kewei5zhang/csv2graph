package map.graph;
import java.util.*;

/**
 * This class is used to contain the main method, which build up the graph and on which the dijkstra's algorithm implemented
 * 
 * @author s4366844
 *
 */
public class DemoGraph {
    public static void main(String[] args) throws Exception{
    	
    	BuildGraph bdGraph = new BuildGraph();
    	bdGraph.addVertexes();;
    	bdGraph.addEdges();
    	bdGraph.printGraph(); 
    	
        DijkstraAlgorithm.computePaths(bdGraph.getOldBeijingIntersections().get(0));
        System.out.println("Distance from " + 0 + " to " + 2000 + " : " + bdGraph.getOldBeijingIntersections().get(2000).minDistance);
        List<Vertex> path = DijkstraAlgorithm.getShortestPathTo(bdGraph.getOldBeijingIntersections().get(2000));
        System.out.println("Path:" + path);
    }
    
}
