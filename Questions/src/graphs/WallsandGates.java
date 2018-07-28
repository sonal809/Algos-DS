package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The value of a cell can either be 0,-1 or INF. 
 * Find the path to the nearest gate (0) for every INF
 * @author sonaggarwal
 *
 */
public class WallsandGates {
    private static int INF = Integer.MAX_VALUE;
    private static int GATE = 0;
    private int[][] directions = {
    		{0,-1},
    		{0,1},
    		{1,0},
    		{-1,0}
    };
    
	public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int n = rooms.length;
        if (n == 0) return;
        int m = rooms[0].length;
        
        for (int i = 0; i < n ; i++) {
        	for (int j = 0; j < m ; j++) {
        		if (rooms[i][j] == GATE) {
        			queue.add(new int[]{i,j});
        		}
        	}
        }
        
        while(!queue.isEmpty()) {
        	int[] curr = queue.poll();
        	int row = curr[0]; int col = curr[1];
        	for (int[] next : directions) {
        		int nextRow = row + next[0];
        		int nextCol = col + next[1];
        		
        		if (nextRow >=0 && nextCol >=0 && nextRow < n && nextCol < m && rooms[nextRow][nextCol] == INF) {
        			rooms[nextRow][nextCol] = rooms[row][col] + 1;
        			queue.add(new int[]{nextRow, nextCol});
        		}
        	}
        }
    }
}
