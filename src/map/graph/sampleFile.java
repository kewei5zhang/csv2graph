package map.graph;
	import java.io.*;
	/**
	 * This class is used to sample all resource files. the sample files would be used to test this program
	 * more effeciently.
	 * @author keweizhang
	 *
	 */
public class sampleFile {
			/**
			 * This method is used to sample OldBeijing text files, in other words, CSV files. 
			 * @param OriginalfileName
			 * @param LineNumber
			 * @param SamplefileName
			 */
			public void sampleCsvFile(String OriginalfileName, int LineNumber, String SamplefileName){
	        // The name of the file to open.

	        // This will reference one line at a time
	      
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(OriginalfileName);
	            
	            // FileWriter writes lines of sample into a new file;
	            FileWriter fileWriter = new FileWriter(SamplefileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            String line = bufferedReader.readLine();
	            
	            for(int i = 1; i <= LineNumber && line != null; i++){
	            	bufferedWriter.write(line);
	            	bufferedWriter.write("\n");
	            	line = bufferedReader.readLine();
	            }
	            bufferedReader.close();   
	            bufferedWriter.close();
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                OriginalfileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + OriginalfileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
		}
	}

