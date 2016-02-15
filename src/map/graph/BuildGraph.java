package map.graph;

import java.util.ArrayList;

/**
 * this class build up a graph with data imported from fileReader class
 * @author s4366844 Kewei Zhang
 *
 */

public class BuildGraph {

	private Graph graph = new Graph();
	
	private ArrayList<Vertex> oldBeijingIntersections = new ArrayList<Vertex>();
	private ArrayList<Edge> oldBeijingRoadInfo = new ArrayList<Edge>();
	
	
	public ArrayList<Vertex> getOldBeijingIntersections() {
		return oldBeijingIntersections;
	}
	
	public void setOldBeijingIntersections(ArrayList<Vertex> oldBeijingIntersections) {
		this.oldBeijingIntersections = oldBeijingIntersections;
	}
	
	public ArrayList<Edge> getOldBeijingRoadInfo() {
		return oldBeijingRoadInfo;
	}
	
	public void setOldBeijingRoadInfo(ArrayList<Edge> oldBeijingRoadInfo) {
		this.oldBeijingRoadInfo = oldBeijingRoadInfo;
	}
	
	public BuildGraph() throws Exception{
		fileReader CsvFileReader = new fileReader();
		 CsvFileReader.readNodeCsv("beijingNode.txt");
		 CsvFileReader.readRoadCsv("beijingRoad.txt");
		 oldBeijingIntersections =CsvFileReader.nodeCollection;
		 oldBeijingRoadInfo = CsvFileReader.roadInfo;
	}
	/**
	 * the addVertexes() method adds all vertexes read from the node text file into a graph
	 * @throws Exception
	 */
	public void addVertexes() throws Exception{
	    for( int i = 0; i <= oldBeijingIntersections.size() - 1; i++){
	    	graph.addVertex(oldBeijingIntersections.get(i), true);
	    }
	}	   
	
	/**
	 * the addEdges() method adds all edges read from the road text file into a graph
	 * @throws Exception
	 */
	public void addEdges() throws Exception{	
	    for(int i = 0; i <= oldBeijingRoadInfo.size()-1; i++){
	    	graph.addEdge(oldBeijingRoadInfo.get(i));
	    	}
	    }
	
	/**
	 * the printGraph function can print all edges and weight in the graph
	 * @return true if the map has successfully been printed out
	 * @return false is the oldBeijingIntersection arraylist is empty
	 * @throws Exception
	 */
	public boolean printGraph() throws Exception{
		if(oldBeijingIntersections != null){
			for(int i = 0; i <= oldBeijingIntersections.size()-1; i++){
	    	System.out.println(oldBeijingIntersections.get(i));
	    	
	    	for(int j = 0; j< oldBeijingIntersections.get(i).getNeighborCount(); j++)
	    		System.out.println(oldBeijingIntersections.get(i).getNeighbor(j));       		
	    }     
	    System.out.println();
		return true;	
		}
		else{
			return false;
		}
	}
}
