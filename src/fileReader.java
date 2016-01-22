import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

public class fileReader {
	
	
	// nodeCollection contain all Intersections(Vertexes) with labels;
     ArrayList<Intersection> nodeCollection = new ArrayList<Intersection>();
     
     //roadCollection contain all route information;
     ArrayList<ArrayList<String>> roadInfo = new ArrayList<>();
//     

/**
 * This method is used to read Oldbeijing node file, as known as csv file. And all vertexes into an Arraylist named collection
 * @param fileName This is the string filename
 */
     public void readNodeCsv(String fileName) {
    	 
     // This will reference one line at a time
     String myLat = null;
     String myLng = null;
     String line = null;
     
     try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         
         while((line = bufferedReader.readLine()) != null) {
        	Intersection point = new Intersection(null); 
         	String[] parts = line.split("\t");
         	int part1 = Integer.parseInt(parts[0]);
         	myLat = parts[2];
         	myLng = parts[1];
         	
         	point.setLongitude(myLat);
         	point.setLatitude(myLng);
         	point.label = parts[0];
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
     @SuppressWarnings("unchecked")
	public void readRoadCsv(String fileName) {
         String line = null;
         boolean flag = false;
         
         try {
             FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
         	 ArrayList<String> rdinfo= new ArrayList<>();
             while((line = bufferedReader.readLine()) != null) {

             	String[] parts = line.split(",");
            	while(flag){
            		ArrayList<String> rdbuffer = new ArrayList<>();
            		rdbuffer = (ArrayList<String>) rdinfo.clone();
            	roadInfo.add(rdbuffer);
            	rdinfo.clear();
            	flag = false;
            	}
             	if ((parts.length == 1) && (parts[0].contains("\t"))){
             		flag = false;
             		String[] subparts = parts[0].split("\t") ;
             		
             		rdinfo.add(subparts[0]);
             		rdinfo.add(subparts[1]);
             		rdinfo.add(subparts[2]);
             	}

             	else if (parts.length > 1) {
					for(int i = 0; i <= parts.length-1; i ++){		
						flag = true;
						rdinfo.add(parts[i]);
					}
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

