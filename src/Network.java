
public class Network extends Graph{
	
	  /**
     * Accepts two vertices and a route, and adds the road
     * ({one, two}, route) if no Road relating one and two 
     * exists in the Graph.
     * 
     * @param one The first Intersection of the Road
     * @param two The second Vertex of the Edge
     * @param weight The weight of the Edge
     * @return true iff no Edge already exists in the Graph
     */
    
    
    public boolean addRoad(Intersection one, Intersection two, String route){
        if(one.equals(two)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Road r = new Road(one, two, route);
        if(edges.containsKey(r.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(r) || two.containsNeighbor(r)){
            return false;
        }
            
        edges.put(r.hashCode(), r);
        one.addNeighbor(r);
        two.addNeighbor(r);
        return true;
    }
    
}
