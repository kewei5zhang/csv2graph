import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DijkstraAlgorithm
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.getNeighborhood())
            {
                Vertex v = e.getNeighbor(u);
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                
                if (distanceThroughU < v.minDistance) {
                	vertexQueue.remove(v);

                	v.minDistance = distanceThroughU ;
                	v.previous = u;
                	vertexQueue.add(v);
                }
            }
        }
    }
    

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
    	
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

}