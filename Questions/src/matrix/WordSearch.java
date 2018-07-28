package matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/word-search/description/
 * Search for a word in a char matrix
 * @author sonaggarwal
 *
 */
public class WordSearch {
	
    public boolean exist(char[][] board, String word) {
        
    	for (int i = 0 ; i < board.length; i++) {
    		for (int j = 0 ; j < board[0].length; j++) {
    			if (board[i][j] == word.charAt(0)) {
    				if (dfs(board, word, 1, i , j)) return true;
    			}
    		}
    	}
    	return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int x, int y) {
    	if (index == word.length()) {
    		return true;
    	}
    	char ch = board[x][y];
    	board[x][y] = '#';
    	int[] rows = {0,0,1,-1};
    	int[] cols = {1,-1,0,0};
    	for (int i = 0 ; i < rows.length; i++) {
    		int next_i = x + rows[i];
    		int next_j = y + cols[i];
    		if (next_i < board.length && next_j < board[0].length && next_i >=0 && next_j >=0) {
    			char next = board[next_i][next_j];
    			if ( next != '#' && next == word.charAt(index)) {
    				if( dfs(board, word, index+1, next_i,next_j)) {
    			    	board[x][y] = ch;
    					return true;
    				}

    			}
    			
    		}
    	}
    	board[x][y] = ch;
    	return false;
    }
    
    @Test
    public void test1() {
    	WordSearch ws = new WordSearch();
    	char[][] board = {
    			{'A','B','C','E'},
    			{'S','F','C','S'},
    			{'A','D','E','E'}
    	};
    	Assert.assertTrue(ws.exist(board, "SEE"));
    	Assert.assertTrue(ws.exist(board, "ABCCED"));
    	Assert.assertFalse(ws.exist(board, "ADFA"));

    }
    
    @Test
    public void test2() {
    	WordSearch ws = new WordSearch();
    	char[][] board = {
    			{'a','a'}
    	};
    	Assert.assertFalse(ws.exist(board, "aaa"));

    }
    
    @Test
    public void test3() {
    	WordSearch ws = new WordSearch();	
    	char[][] board2 = {
    			{'C','A','A'},
    			{'A','A','A'},
    			{'B','C','D'}
    	};
    	Assert.assertFalse(ws.exist(board2, "ABCCED"));
    	Assert.assertTrue(ws.exist(board2, "AAB"));

    }
    
    @Test
    public void test4() {
    	WordSearch ws = new WordSearch();	
      	char[][] board3 = {
    			{'A','B','C','E'},
    			{'S','F','E','S'},
    			{'A','D','E','E'}
    	};
      	Assert.assertTrue(ws.exist(board3,"ABCESEEEFS"));
    }
    public static void main(String args[]) {
    	

    }
}
