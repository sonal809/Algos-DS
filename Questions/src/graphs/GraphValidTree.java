package graphs;

import java.util.ArrayList;
import java.util.List;
/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges.
 * @author sonaggarwal
 *
 */
class GraphSimple{
	int vertices;
	List<Integer> [] adj;
	
	public GraphSimple(int v) {
		vertices = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdges(int[][] edges) {
		for (int i = 0 ; i < edges.length; i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}
	}
}
public class GraphValidTree {
	
	public boolean isCyclic(GraphSimple g, boolean[] visited, int start, int parent) {
		if (visited[start]) {
			return false;
		}
		visited[start] = true;
		for (int adjacentVertix: g.adj[start]) {
			if (visited[adjacentVertix] && parent != adjacentVertix) {
				return true;
			}
			if(isCyclic(g, visited, adjacentVertix, start)) return true;
		}
		return false;
	}
    public boolean validTree(int n, int[][] edges) {
    	GraphSimple g = new GraphSimple(n);
    	g.addEdges(edges);
    	
    	boolean[] visited = new boolean[n];
    	if (isCyclic(g, visited, 0, -1)) {
    		return false;
    	}
    	for (int i = 0 ; i < n ; i++) {
    		if (!visited[i]) return false;
    	}
    	return true;
    }
    
    public static void main(String args[]) {
    	GraphValidTree obj = new GraphValidTree();
    	int[][] edges = {
    			{0,1},
    			{0,2},
    			{2,3},
    			{2,4}
    	};
    	System.out.println(obj.validTree(5, edges));
    }
}
