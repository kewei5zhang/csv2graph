
public class Road extends Edge{
	
	public Road(Intersection one, Intersection two) {
		super(one, two);
		// TODO Auto-generated constructor stub
	}
	public Road(Intersection one, Intersection two, String route){
		 super(one, two);
	     this.route = route;
	}
	
	private double length;
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	private String route;

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	

}
