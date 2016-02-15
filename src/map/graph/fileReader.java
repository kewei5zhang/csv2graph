package map.graph;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileReader {

     ArrayList<Vertex> nodeCollection = new ArrayList<Vertex>();
     ArrayList<Edge> roadInfo = new ArrayList<Edge>();    

/**
 * This method is used to read Oldbeijing node file, as known as csv file. And all vertexes into an Arraylist named collection
 * @param fileName This is the string filename
 */
public void readNodeCsv(String fileName) {
     try {
    	 String line = null;   
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         
         while((line = bufferedReader.readLine()) != null) {
        	Vertex point = new Vertex(null); 
         	String[] parts = line.split("\t");
         	String label = parts[0];
         	String myLat = parts[2];
         	String myLng = parts[1];
         	
         	point.setLongitude(myLat);
         	point.setLatitude(myLng);
         	point.setLabel(label);
            nodeCollection.add(point);
         	}
         bufferedReader.close();         
     }
     catch(FileNotFoundException ex) {
         System.out.println(
             "Unable to open file '" + 
             fileName + "'");                
     }
     catch(IOException ex) {
         System.out.println(
             "Error reading file '" 
             + fileName + "'");                  
     }
     }
    /**
     * This method is used to read OldBeijing Map Road file, and save all lat lng information into road Collection arraylist
     * @param fileName
     */
	public void readRoadCsv(String fileName) {
         String line = null;
         boolean flag = false;
         Vertex one = new Vertex(null);
         Vertex two = new Vertex(null);
         Double length = null;
         ArrayList<String> rdinfo= new ArrayList<>();
         
         try {
             FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
         	
             while((line = bufferedReader.readLine()) != null) {
            	 String[] parts = line.split(",");
            	 if((parts.length == 1) && (parts[0].contains("\t"))){
            		 String[] subparts = parts[0].split("\t");
            		 
            		 String onelabel = subparts[0]; 
            		 String twolabel = subparts[1];
            		 one = nodeCollection.get(Integer.parseInt(onelabel));
            		 two = nodeCollection.get(Integer.parseInt(twolabel));
            		 length = Double.parseDouble(subparts[2]);
            	 }
            	 else if (parts.length > 1){
            		 for(int i = 0; i <= parts.length-1; i ++){		
						rdinfo.add(parts[i]);
					}
            		 flag = true;
            	 }
            	 while(flag){
            		 Edge edge = new Edge(one, two, length);
            		 edge.setLinkList(rdinfo);
            		 roadInfo.add(edge);
            		 flag = false;
            	 }
             }  
             bufferedReader.close();         
         }
         catch(FileNotFoundException ex) {
             System.out.println(
                 "Unable to open file '" + 
                 fileName + "'");                
         }
         catch(IOException ex) {
             System.out.println(
                 "Error reading file '" 
                 + fileName + "'");                  	
         }
     }
     
     
}

