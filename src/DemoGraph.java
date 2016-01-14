import java.io.*;
import java.util.*;

public class DemoGraph {
    public static void main(String[] args){
        Graph graph = new Graph();
        fileReader frFileReader = new fileReader();
        
        frFileReader.readNodeCsv("beijingNode.txt");
    }
}
