package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {
	public List<String> reconstructItinerary(Graph g, String start) {
		List<String> result = new ArrayList<String>();
		Stack<Graph.Node> stack = new Stack<>();
		topSortUtil(stack, g, g.vertices.get(start));
		for (Graph.Node n : g.adj.keySet()) {
			if(!n.visited) {
				topSortUtil(stack, g, n);
			}
		}
		while(!stack.isEmpty()) {
			result.add(stack.pop().val);
		}
		return result;
	}
	
	private void topSortUtil(Stack<Graph.Node> stack, Graph g, Graph.Node n) {
		n.visited = true;
		for (Graph.Node adjacentNode: g.adj.get(n)) {
			if(!adjacentNode.visited) {
				topSortUtil(stack, g, adjacentNode);
			}
		}
		stack.push(n);
	}
	
	public List<String> findItinerary(String[][] tickets) {
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	    for (String[] ticket: tickets) {
	    	PriorityQueue<String> adj = targets.get(ticket[0]);
	    	if(!targets.containsKey(ticket[0])) {
	    		adj = new PriorityQueue<>();
	    		targets.put(ticket[0], adj);
	    	}
	    	adj.add(ticket[1]);
	    }
	    Stack<String> stack = new Stack<>();
	    stack.push("JFK");
	    List<String> route = new LinkedList<>();
	    while(!stack.isEmpty()) {
	    	String curr = stack.peek();
	    	PriorityQueue<String> next = targets.get(curr);
	    	while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	    	route.add(0, stack.pop());
	    }
	    return route;
	}
	
	
	
	public static void main(String args[]) {
		ReconstructItinerary obj = new ReconstructItinerary();
		Graph g = new Graph();
		g.addEdge("JFK", "SFO");
		g.addEdge("JFK", "ATL");
		g.addEdge("SFO", "ATL");
		g.addEdge("ATL", "JFK");
		g.addEdge("ATL", "SFO");
		
		System.out.println(Arrays.toString(obj.reconstructItinerary(g, "JFK").toArray()));
		
		/**
		"Chennai" -> "Banglore"		 
		"Bombay" -> "Delhi"
		"Goa"    -> "Chennai"
		"Delhi"  -> "Goa"
		
		 */
		  
		Graph g2 = new Graph();
		g2.addEdge("Chennai", "Bangalore");
		g2.addEdge("Bombay", "Delhi");
		g2.addEdge("Goa", "Chennai");
		g2.addEdge("Delhi", "Goa");
		System.out.println(Arrays.toString(obj.reconstructItinerary(g2, "Bombay").toArray()));

		//[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
		
		String[] s1 = {"MUC","LHR"};
		String[] s2 = {"JFK","MUC"};
		String[] s3 = {"SFO","SJC"};
		String[] s4 = {"LHR","SFO"};
		String[][] tickets = {s1,s2,s3,s4};
		System.out.println(Arrays.toString(obj.findItinerary(tickets).toArray()));


		

	}

}
