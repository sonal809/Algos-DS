package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import util.GraphUtil;

public class CheckBipartite {
    static class Graph {
    	 Map<Integer, List<Integer>> map = new HashMap<>();
    	Graph() {
    		
    	}
    	Graph(int[][] edges) {
    		for (int[] edge : edges) {
    			if (map.containsKey(edge[0])) {
    				map.get(edge[0]).add(edge[1]);
    			} else if (map.containsKey(edge[1])){
    				map.get(edge[1]).add(edge[0]);
    			}
    			else {
    				map.put(edge[0], new LinkedList<>(Arrays.asList(edge[1])));
    				map.put(edge[1], new LinkedList<>(Arrays.asList(edge[0])));
    			}
    		}
    	}
    }
    	//graph[i] is a list of indexes j for which the edge between nodes i and j exists
			public Graph createGraph(int[][] edges) {
				Graph g = new Graph();
			int i = 0;
			for (int[] adj : edges) {
				List<Integer> adjNodeList = new LinkedList<>();
				for (int adjNode : adj) {
					adjNodeList.add(adjNode);
				}
				g.map.put(i, adjNodeList);
				i++;
			}
			return g;
		}
		
    public boolean isBipartite(int[][] graph) {
    	int[] colors = new int[graph.length];
    	Arrays.fill(colors, -1);
    	for (int i = 0 ; i < graph.length; i++) {
    		if(colors[i] == -1 && !dfsHelper(i, colors, graph, 0)) return false;
    	}
    	return true;
    	
    	
    }
    
    boolean dfsHelper(int node, int[] colors, int[][] graph, int color) {
    	 if(colors[node] != -1) {
    		 return colors[node] == color;
    	 }
    	 colors[node] = color;
    	 for (int adj : graph[node]) {
    		 if (!dfsHelper(adj, colors, graph, 1-color)) return false;
    	 }
    	 return true;
    }
    
	
	@Test
	public void test1() {
		int[][] graph = GraphUtil.stringToInt2dArray("[[1,3],[0,2],[1,3],[0,2]]");
		CheckBipartite cb = new CheckBipartite();
		Assert.assertTrue(cb.isBipartite(graph));
	}
	
	@Test
	public void test2() {
		int[][] graph = GraphUtil.stringToInt2dArray("[[1,2,3], [0,2], [0,1,3], [0,2]]");
		CheckBipartite cb = new CheckBipartite();
		Assert.assertFalse(cb.isBipartite(graph));
	}
	
	@Test
	public void test3() {
		int[][] graph = GraphUtil.stringToInt2dArray("[[1,2], [0,2], [0,1]]");
		CheckBipartite cb = new CheckBipartite();
		Assert.assertFalse(cb.isBipartite(graph));
	}
	
	@Test
	public void test4() {
		int[][] graph = GraphUtil.stringToInt2dArray("[[1],[0,3],[3],[1,2]]");
		CheckBipartite cb = new CheckBipartite();
		Assert.assertTrue(cb.isBipartite(graph));
	}
	
	@Test
	public void test5() {
		int[][] graph = GraphUtil.stringToInt2dArray("[[3],[2,4],[1],[0,4],[1,3]]");
		CheckBipartite cb = new CheckBipartite();
		Assert.assertTrue(cb.isBipartite(graph));
	}
}
