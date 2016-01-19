import java.util.*;

public class Intersection extends Vertex {
	private int number;
	private String longitude;
	private String latitude;
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Intersection(String label) {
		super(label);
		//label = this.longitude + this.latitude;
	}
	
	public void setLongitude(String lng){
		this.longitude = lng;
	}
	
	public String getLongitude(){
		return this.longitude;
	}
	
	public void setLatitude(String lat){
		this.latitude = lat;
	}
	
	public String getLatitude(){
		return this.latitude;
	}
}
