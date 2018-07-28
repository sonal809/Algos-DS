package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Directed graph
 * @author sonaggarwal
 *
 */
class DiGraph {
	int vertices;
	List<Integer> [] adj;
	
	public DiGraph(int v) {
		vertices = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdges(int[][] edges) {
		for (int i = 0 ; i < edges.length; i++) {
			adj[edges[i][0]].add(edges[i][1]);
		}
	}
}


public class CourseSchedule {
	public boolean isCyclic(DiGraph g, boolean[] visited, Set<Integer> recursionStack, int start ) {
	
		if (recursionStack.contains(start)) {
			return true;
		}
		visited[start] = true;
		recursionStack.add(start);
		for(int adjVertex: g.adj[start]) {
			
			if(isCyclic(g, visited, recursionStack, adjVertex)) return true;
			
		}
		recursionStack.remove(start);
		return false;
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	DiGraph g = new DiGraph(numCourses);
        g.addEdges(prerequisites);
        
        boolean[] visited = new boolean[numCourses];
        for (int i = 0 ; i < numCourses; i++) {
        	if(!visited[i] && isCyclic(g, visited, new HashSet<Integer>(), i)) {
        		return false;
        	}
        	
        }
    	return true;
    }
    
    public static void main(String args[]) {
    	CourseSchedule sc = new CourseSchedule();
    	int[][] prerequisites =  {
    		{1,0}
    	};
    	
    	int[][] prereq = {
    			{1,0},
    			{0,1}
    	};
    	
    	int[][] preq3 = {
    			{0,1},
    			{0,2},
    			{1,2}
    	};
    	int[][] preq4 = {
    			
    			{2,0},{1,0},{3,1},{3,2}, {1,3}
    	};
   // 	System.out.println(sc.canFinish(2, prerequisites));
    //	System.out.println(sc.canFinish(2, prereq));
    	System.out.println(sc.canFinish(4, preq4));


    }
}
