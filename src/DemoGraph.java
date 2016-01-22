import java.util.*;

public class DemoGraph {
    public static void main(String[] args){
    	Graph network = new Graph();
    	
    	ArrayList<Intersection> oldBeijingIntersections = null;
    	ArrayList<ArrayList<String>> oldBeijingRoadInfo = null;
    	
    	ArrayList<Integer> pointsPair = new ArrayList<>();
        sampleFile sampleFile = new sampleFile();
        fileReader CsvFileReader = new fileReader();
        
        sampleFile.sampleCsvFile("beijingNode.txt", 2000, "sampleBeijingNode.txt");
        sampleFile.sampleCsvFile("beijingRoad.txt", 100, "sampleBeijingRoad.txt");
        
        CsvFileReader.readNodeCsv("beijingNode.txt");
        CsvFileReader.readRoadCsv("beijingRoad.txt");
        oldBeijingIntersections =CsvFileReader.nodeCollection;
        oldBeijingRoadInfo = CsvFileReader.roadInfo;
        

        //read all nodes in the text file and add those into the network as an intersection
        for( int i = 0; i <= oldBeijingIntersections.size() - 1; i++){
        	network.addVertex(oldBeijingIntersections.get(i), true);
        }
        
        // add road in network
        for(int i = 0; i <= oldBeijingRoadInfo.size()-1; i++){
        	for(int j = 0; j <= 1;j++){       		
        		int k = Integer.parseInt(oldBeijingRoadInfo.get(i).get(j)) ;
        		pointsPair.add(k);
        	}
        	
        	Intersection one =oldBeijingIntersections.get(pointsPair.get(0));
        	Intersection two = oldBeijingIntersections.get(pointsPair.get(1));
        	Double length = Double.parseDouble(oldBeijingRoadInfo.get(i).get(2));
        	
        	network.addEdge(one, two, length);
        	pointsPair.clear();
        }
        
//        for(int i = 0; i <= oldBeijingIntersections.size()-1; i++){
//        	System.out.println(oldBeijingIntersections.get(i));
//        	
//        	for(int j = 0; j< oldBeijingIntersections.get(i).getNeighborCount(); j++)
//        		System.out.println(oldBeijingIntersections.get(i).getNeighbor(j));       		
//        }     
//        System.out.println();
        
        
        //compute shortest path
        DijkstraAlgorithm.computePaths(oldBeijingIntersections.get(0));
        System.out.println("Distance to " + 5 + " : " + oldBeijingIntersections.get(5).minDistance);
        List<Vertex> path = DijkstraAlgorithm.getShortestPathTo(oldBeijingIntersections.get(506));
        System.out.println("Path:" + path);
        for(int i = 0; i<= path.size()-1;i++){
        	String latString = null;
        	String lngString = null;
        	latString = oldBeijingIntersections.get(Integer.parseInt(path.get(i).getLabel())).getLatitude();
        	lngString = oldBeijingIntersections.get(Integer.parseInt(path.get(i).getLabel())).getLongitude();
        	System.out.println(path.get(i) + " : " +latString +" , "+ lngString);
        	
        }
        
    }
    
}
