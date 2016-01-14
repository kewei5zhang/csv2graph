import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class fileReader {
	
	 Vertex point = new Intersection(null); 
     ArrayList collection = new ArrayList<Intersection>();
    
/**
 * This method is used to read Oldbeijing node file, as known as csv file.
 * @param fileName This is the string filename
 */
     public void readNodeCsv(String fileName) {

     // The name of the file to open.

     // This will reference one line at a time
     String line = null;
     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = 
             new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader = 
             new BufferedReader(fileReader);

         while((line = bufferedReader.readLine()) != null) {
         	String[] parts = line.split("\t");
         	String part1 = parts[0];
         	String part2 = parts[1];
         	String part3 = parts[2];
         	
         	point.
         	}   
         
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
