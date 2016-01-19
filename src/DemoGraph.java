import java.io.*;
import java.util.*;

import javax.security.auth.kerberos.KerberosKey;

public class DemoGraph {
    public static void main(String[] args){
    	Network network = new Network();
    	ArrayList<Intersection> oldBeijingIntersections = null;
    	ArrayList<ArrayList<Integer>> oldBeijingStardEndPoints = null;
    	ArrayList<Integer> pointsPair = new ArrayList<>();
        sampleFile sampleFile = new sampleFile();
        fileReader CsvFileReader = new fileReader();
        
        sampleFile.sampleCsvFile("beijingNode.txt", 2000, "sampleBeijingNode.txt");
        sampleFile.sampleCsvFile("beijingRoad.txt", 100, "sampleBeijingRoad.txt");
        
        CsvFileReader.readNodeCsv("sampleBeijingNode.txt");
        CsvFileReader.readRoadCsv("sampleBeijingRoad.txt");
        oldBeijingIntersections =CsvFileReader.nodeCollection;
        oldBeijingStardEndPoints = CsvFileReader.startEndPoints;
      //  System.out.print(CsvFileReader.collection);
 
        //read all nodes in the text file and add those into the network as an intersection
        for( int i = 0; i <= oldBeijingIntersections.size() - 1; i++){
        	network.addVertex(oldBeijingIntersections.get(i), true);
        	//System.out.println(oldBeijingIntersections.get(i));
        }
        
//        System.out.println("startEndPoints pairs are " + CsvFileReader.startEndPoints);
//        System.out.println("nodeCollection is " + CsvFileReader.nodeCollection);
//        System.out.println("roadCollection is " + CsvFileReader.roadCollection);
        
        for(int i = 0; i <= oldBeijingStardEndPoints.size()-1; i++){
        	for(int j = 0; j <= 1;j++){       		
        		int k = oldBeijingStardEndPoints.get(i).get(j);
        		pointsPair.add(k);
        	}
        	network.addEdge(oldBeijingIntersections.get(pointsPair.get(0)), oldBeijingIntersections.get(pointsPair.get(1)));
        //	System.out.println(pointsPair);
        	pointsPair.clear();
        }
        
        for(int i = 0; i <= oldBeijingIntersections.size()-1; i++){
        	System.out.println(oldBeijingIntersections.get(i));
        	
        	for(int j = 0; j< oldBeijingIntersections.get(i).getNeighborCount(); j++)
        		System.out.println(oldBeijingIntersections.get(i).getNeighbor(j));
        }
        
        System.out.println();
    }
    
}
