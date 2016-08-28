//Store Graph as a list of Vertexes

import java.util.*;

public class Graph {

	List<Vertex> vertexes;
	Graph(){
		this.vertexes = new ArrayList<Vertex>();
	}
	
	public void printGraph(){
		System.out.println("Node(visited)---weight(Edge)---> OtherNode");
		System.out.println();
		for(Vertex v: vertexes){			
			System.out.print(v);
		}
	}
	/*given arraylist of [from, to] generate graph
	public Graph generateGraph(){
		//see method //public Graph createGraph(ArrayList<Ticket> tickets) //from  class FlightItineraryProblem
	}*/
	
	public Vertex getVertex(String valueToSearch){	
		Vertex vtx = new Vertex();
		for( Vertex v: this.vertexes){
			if(v.value == valueToSearch )
				return v;
		}
		return vtx;
	}
}
