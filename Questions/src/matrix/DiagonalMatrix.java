package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {
	public int row;
	public int col;
	
	Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

//COULD NOT COMPLETE
public class DiagonalMatrix {
	
	   public int[] findDiagonalOrder(int[][] matrix) {
		   List<Integer> result = new ArrayList<>();
		   int ROW = matrix.length;
		   int COL = matrix[0].length;
		   boolean diagonalUp = true;
		   Pair p = new Pair(0, 0);
		   while(p.row != ROW  && p.col != COL) {
			   if(diagonalUp) {
				   diagonalUp(result, p, matrix, ROW, COL);
				   diagonalUp = false;
			   } else {
				   diagonalDown(result, p, matrix, ROW, COL);
				   diagonalUp = true;
			   }
			 //  if (p.row == ROW -1 && p.col == COL-1) break;
		   }
		   int[] array = new int[result.size()];
		   int i = 0;
		   for (Integer e : result) {
			   array[i++] = e;
		   }
		   return array;
				   
			
			  
	    }
	   
	   private void diagonalUp(List<Integer> result, Pair p, int[][] matrix, int ROW, int COL) {
		   int row = p.row;
		   int col = p.col;
		   while(row >= 0 && row < ROW && col < COL && col >= 0) {
			   result.add(matrix[row--][col++]);
		   }
		   if (row == ROW && col == COL) {
			   return;
		   }
		   if (row < 0 && col == COL) {
			   row = 1;
			   col = COL-1;
		   }
		   if (row < 0) {
			   p.row = 0;
			  // p.col = col == COL? col -1 :col;			   
		   }
		   
		   if (col == COL) {
			   p.row = row+2;
			   p.col = col-1;
		   }
	   }
	   
	   private void diagonalDown(List<Integer> result,Pair p, int[][] matrix, int ROW, int COL) {
		   int row = p.row;
		   int col = p.col;
		   while(row >= 0 && row < ROW && col < COL && col >= 0) {
			   result.add(matrix[row++][col--]);
		   }
		   if (row == ROW && col == COL) {
			   return;
		   }
		   if(row == ROW && COL < 0) {
			   col = 1;
			   row = ROW -1;
		   }
		   if (col < 0) {
			   p.col = 0;
			 //  p.row = row == ROW ? row-1 : row;
		   }
		   if (row == ROW ) {
			   p.col = col + 2;
			   p.row = row-1;
		   }
	   }
	   
	   public static void main(String args[]) {
		   int[][] m1 = { {1,2,3},
				   {2,3,4},
				   {9,8 ,6}
		   };
		   
		   DiagonalMatrix obj = new DiagonalMatrix();
		   System.out.println(Arrays.toString(obj.findDiagonalOrder(m1)));
		   
		   }
	   
	   
}
