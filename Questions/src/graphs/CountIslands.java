package graphs;

public class CountIslands {
    
	public int numIslands(char[][] grid) {
		int count = 0;
		int[][] visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0 ; j < grid[0].length; j++) {
				if(visited[i][j] == 0 && grid[i][j] == '1') {
					count += 1;
					dfs(grid, visited, i , j);
				}
			}
		}
		return count;
    }
	
	private void dfs(char[][] grid, int[][] visited, int i, int j) {
		visited[i][j] = 1;
		int[][] neighDirection = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		for (int k = 0; k < neighDirection.length ; k++ ) {
			int nextRow = i + neighDirection[k][0];
			int nextCol = j + neighDirection[k][1];
			if( nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
				if (grid[nextRow][nextCol] == '1' && visited[nextRow][nextCol] == 0) dfs(grid, visited, nextRow, nextCol);
			}
		}
		return;
	}
	
	public static void main(String args[]) {
		CountIslands cs = new CountIslands();
		char[][] grid = 
				{{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		System.out.println(cs.numIslands(grid));
	}
}
