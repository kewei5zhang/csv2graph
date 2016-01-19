import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class fileReader {
	
	 
     ArrayList<Intersection> collection = new ArrayList<Intersection>();
     ArrayList<String> roadCollection = new ArrayList<>();
     ArrayList<ArrayList<Integer>> startEndpoints = new ArrayList<>();
/**
 * This method is used to read Oldbeijing node file, as known as csv file. And all vertexes into an Arraylist named collection
 * @param fileName This is the string filename
 */
     public void readNodeCsv(String fileName) {
    	 
     // This will reference one line at a time
     String myLat = null;
     String myLng = null;
     String line = null;
     String myLabel = null;
     
     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader = new BufferedReader(fileReader);

         while((line = bufferedReader.readLine()) != null) {
        	Intersection point = new Intersection(null); 
         	String[] parts = line.split("\t");
         	int part1 = Integer.parseInt(parts[0]);
         	myLat = parts[1];
         	myLng = parts[2];
         	
         	point.setNumber(part1);
         	point.setLongitude(myLat);
         	point.setLatitude(myLng);
         	point.label = myLat + myLng;
         	
         	myLabel = point.getLabel();
         	collection.add(point);
         	
        // 	System.out.println(point);
         //	System.out.println(collection);
         	}
         
        // System.out.println(collection);
         // Always close files.
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
         // Or we could just do this: 
         // ex.printStackTrace();
     }
     }
    /**
     * This method is used to read OldBeijing Map Road file, and save all lat lng information into road Collection arraylist
     * @param fileName
     */
     public void readRoadCsv(String fileName) {
         // This will reference one line at a time
         String line = null;
        //  ArrayList<String> latLngCollection = null;
         
         try {
             // FileReader reads text files in the default encoding.
             FileReader fileReader = new FileReader(fileName);

             // Always wrap FileReader in BufferedReader.
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             while((line = bufferedReader.readLine()) != null) {
            	Intersection point = new Intersection(null); 
             	String[] parts = line.split(",");
             	if (parts.length > 1) {
					for(int i = 0; i <= parts.length-1; i ++){
						roadCollection.add(parts[i]);
					}
				}	
             	else if ((parts.length == 1) && (parts[0].contains("\t"))){
             		
             		String[] subparts = parts[0].split("\t") ;
             		ArrayList<Integer> startend= new ArrayList<>();
             		startend.add(Integer.parseInt(subparts[0]));
             		startend.add(Integer.parseInt(subparts[1]));
             		startEndpoints.add(startend);
             	}
             }
             	
             for (ArrayList<Integer> startEndPairs: startEndpoints){
            	 System.out.println(startEndPairs);
             }
//             for (String latlngpair : roadCollection) {
//				System.out.println(latlngpair);
//			}
             //System.out.println(roadCollection);
             // Always close files.
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
             // Or we could just do this: 
             // ex.printStackTrace();
         
		
         }
     }
}

