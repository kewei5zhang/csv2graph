import java.io.*;
import java.util.*;

public class DemoGraph {
    public static void main(String[] args){
    	Graph graph = new Graph();
    	ArrayList<Intersection> oldBeijingIntersection = null;
        sampleFile sampleFile = new sampleFile();
        fileReader CsvFileReader = new fileReader();
        
        sampleFile.sampleCsvFile("beijingNode.txt", 100, "sampleBeijingNode.txt");
        sampleFile.sampleCsvFile("beijingRoad.txt", 1000, "sampleBeijingRoad.txt");
        
        
        CsvFileReader.readNodeCsv("sampleBeijingNode.txt");
        CsvFileReader.readRoadCsv("sampleBeijingRoad.txt");
        oldBeijingIntersection =CsvFileReader.collection;
        System.out.print(CsvFileReader.collection);
 
        for( int i = 0; i <= oldBeijingIntersection.size() - 1; i++){
        	graph.addVertex(oldBeijingIntersection.get(i), true);
        	System.out.println(oldBeijingIntersection.get(i));
        }
    }
    
}
