package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

public class RedundantEdge {
    
	public int[] findRedundantConnection2(int[][] edges) {
	    Set<Integer> visited = new HashSet<>();
	    Map<Integer, List<Integer>> graph = new HashMap<>(); 
	    int[] extraEdge = {-1, -1};
	    for(int[] edge: edges) {
	    	if(visited.contains(edge[0]) && visited.contains(edge[1])) return edge;

	    	if(!visited.contains(edge[0])) {
	    		List<Integer> u_neighbors = new ArrayList<>();
	    		if(graph.containsKey(edge[0])) {
	    			u_neighbors = graph.get(edge[0]);
	    		} 
	    		u_neighbors.add(edge[1]);
	    		graph.put(edge[0], u_neighbors);
	    		visited.add(edge[0]);
	    	
	    	} if(!visited.contains(edge[1])) {
	    		List<Integer> v_neighbors = new ArrayList<>();
	    		if(graph.containsKey(edge[1])) {
	    			v_neighbors = graph.get(edge[1]);
	    		} 
	    		v_neighbors.add(edge[0]);
	    		graph.put(edge[1], v_neighbors);
	    		visited.add(edge[1]);
	    	} 
	    }
	    
	    return extraEdge;
	    }
	
	public int[] findRedundantConnection(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] extraedge = {-1,-1};
		for (int[] edge: edges) {
			if(graph.containsKey(edge[0]) && graph.containsKey(edge[1])) {
				if(dfs(graph, edge[0], edge[1], new HashSet<Integer>())) return edge;
			}
			List<Integer> u_neigh = new ArrayList<>();
			List<Integer> v_neigh = new ArrayList<>();
			if(graph.containsKey(edge[0])) {
				u_neigh = graph.get(edge[0]);
			}
			if(graph.containsKey(edge[1])) {
				v_neigh = graph.get(edge[1]);
			}
			u_neigh.add(edge[1]);
			v_neigh.add(edge[0]);
			graph.put(edge[0], u_neigh);
			graph.put(edge[1], v_neigh);
			
		}
		return extraedge;
	}
	public boolean dfs(Map<Integer, List<Integer>> graph, int src, int target, Set<Integer> seen) {
		if (!seen.contains(src)) {
			seen.add(src);
			if(src == target) return true;
			for (int neighbor : graph.get(src)) {
				if( dfs(graph, neighbor, target, seen)) return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		RedundantEdge obj = new RedundantEdge();
		int[][] edges = {{1,2},{1,3},{2,3}};
		System.out.println(Arrays.toString(obj.findRedundantConnection(edges)));

	}
}
