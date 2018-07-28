package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WightedDiGraph {
	int n;
	public Map<Integer, Map<Integer, Integer>> adjacent;
	
	WightedDiGraph(int n) {
		this.n = n;
		adjacent = new HashMap<>();
	}
	//A row in the matrix is {x,y,w} that is an edge from x to y which has weight w.
	WightedDiGraph(int n, int[][] edges) {
		this(n);
		for (int[] edge : edges) {
			if (adjacent.containsKey(edge[0])) {
				Map<Integer, Integer> adjacentNodes = adjacent.get(edge[0]);
				adjacentNodes.put(edge[1], edge[2]); //assuming no edge will be repeated.
			} else {
				Map<Integer, Integer> neighbor = new HashMap<>();
				neighbor.put(edge[1], edge[2]);
				adjacent.put(edge[0], neighbor);
			}
			if (!adjacent.containsKey(edge[1])) {
				Map<Integer, Integer> emptyMap = new HashMap<>();
				adjacent.put(edge[1], emptyMap);
			}

		}
	}
}
class Custom {
	int pathLen;
	int stops;
	
	Custom(int pathLen, int stops) {
		this.pathLen = pathLen;
		this.stops = stops;
	}
	
	@Override
	public String toString() {
		return "PathLen:" + pathLen + " Stops:"+ stops;
	}
}
public class CheapestFlightWithKStops {
	private void dfs(WightedDiGraph graph, int src, int dst, int stops, int value, Set<Integer> visited, List<Custom> paths, int k) {
		visited.add(src);
		if (stops > k) return;
		if(src == dst) {
			printHashSet(visited);
			paths.add(new Custom(value, stops));
			return;
		}
		Map<Integer, Integer> adjacentNodes = graph.adjacent.get(src);
		if (adjacentNodes.keySet().size() > 0) {
			for (int neigh : adjacentNodes.keySet()) {
				if (!visited.contains(neigh) && neigh != src) {
					dfs(graph, neigh, dst, stops+1, value+(int)adjacentNodes.get(neigh), visited, paths, k);
				}
				visited.remove(neigh);
			}
		}
	}
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		WightedDiGraph graph = new WightedDiGraph(n, flights);
		List<Custom> paths = new ArrayList<>();
		dfs(graph, src, dst, -1, 0, new LinkedHashSet<Integer>(),paths, K);
		int minPathLen = Integer.MAX_VALUE;
		for (Custom path : paths) {
			if (path.stops <= K && path.pathLen < minPathLen) {
				minPathLen = path.pathLen;
			}
		}
		System.out.println(Arrays.toString(paths.toArray()));
		return minPathLen;
		
    }
	private void printHashSet(Set<Integer> printSet) {
		for (int i : printSet) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String args[]) {
		CheapestFlightWithKStops sol = new CheapestFlightWithKStops();
		int[][] edges1 = {
				{0,1,100},
				{1,2,100},
				{0,2,500}};
	//	System.out.println(sol.findCheapestPrice(3, edges1, 0, 2, 1));
	//	10
		int[][] edges2 = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},
				{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},
				{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};
		System.out.println(sol.findCheapestPrice(10, edges2, 6, 0, 7));

		//6
		//0
		//7
	}
}
