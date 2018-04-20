package code;

public class GameOfLife {
	private int countNeighbors(int i, int j, int[][] board) {
		int[] row = {0,0,1,1,1,-1,-1,-1};
		int[] col = {-1,1,0,-1,1,0,1,-1};
        int ROW = board.length;
        int COL = board[0].length;
		int neighbors = 0;
		for (int k = 0 ; k < row.length; k++) {
            int rowIndex = i+row[k];
            int colIndex = j+col[k];
            if (rowIndex < 0 || colIndex< 0 || rowIndex >= ROW || colIndex >= COL) {
                continue;
            }
			if (board[rowIndex][colIndex] == 1 || board[rowIndex][colIndex] == 10) {
				neighbors += 1;
			}
		}
		return neighbors;
	}
    public void gameOfLife(int[][] board) {
    	
    	for (int i = 0 ; i < board.length; i++) {
    		for (int j = 0 ; j < board[0].length; j++) {
    			int n = countNeighbors(i, j , board);
                System.out.print(" count->" + n+ " ");
    			if (board[i][j] == 1 && (n < 2 || n > 3)) {
    				board[i][j] = 10;
    			}
    			if (board[i][j] == 0 && n == 3) {
    				board[i][j] = 11;
    			}
    		}
    	}
    	
    	for (int i = 0 ; i < board.length; i++) {
    		for (int j = 0 ; j < board[0].length; j++) {
    			if (board[i][j] == 10) {
    				board[i][j] = 0;
    			}
    			if (board[i][j] == 11) {
    				board[i][j] = 1;
    			}
    		}
    	}
    }
}
