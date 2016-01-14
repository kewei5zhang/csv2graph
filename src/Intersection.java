import java.util.*;

public class Intersection extends Vertex {
	
	private String longitude;
	private String latitude;
	
 public Intersection(String longitude, String latitude) {
	 
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Intersection(String label) {
		super(label);
		label = this.longitude + this.latitude;
	}


}
