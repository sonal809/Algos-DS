package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	Map<Node, LinkedList<Node>> adj;
	Map<String, Node> vertices;
	
	public Graph() {
		adj = new HashMap<>();
		vertices = new HashMap<>();
	}
	
	public Node insertNode(String value) {
		Node n = vertices.get(value);
		if(n == null) {
			n = new Node(value);
			vertices.put(value, n);
		}
		if (!adj.containsKey(n)) {
			adj.put(n, new LinkedList<Node>());
		} 
		return n;
	}

	public void addEdge(String src, String dest) {
		Node srcNode = insertNode(src);
		Node destNode = insertNode(dest);
		LinkedList<Node> adjacentNodes = adj.get(srcNode);
		adjacentNodes.add(destNode);
	}
	
	class Node implements Comparable<Graph.Node>{
		String val;
		public boolean visited;
		
		Node(String val) {
			this.val = val;
		}

		@Override
		public int compareTo(Graph.Node o) {
			return val.compareTo(o.val);
		}
		
		@Override
		public String toString() {
			return val;
		}
		
	}

}
