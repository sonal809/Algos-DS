package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Zillow interview question. 
 * 
# Given a N by M matrix represented by a 2D boolean array and 2 coordinates (x1,y1), (x2,y2). Each coordinate in the maze is either a valid position or a wall. Find a path from the starting point (x1,y1) to the ending point (x2,y2). Print out said path.
	Example:	
	0 1 0 0
	0 S 1 1
	0 1 1 0
	0 1 0 0
	1 1 F 0
	
 * @author sonaggarwal
 *
 */

class Tuple {
    int x;
    int y;

    Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
	public int hashCode() {
    	return Objects.hash(this.x,this.y);
    }
    
    @Override
    public boolean equals(Object obj) {
    	Tuple t = (Tuple) obj;
        if (this.x == t.x && this.y == t.y) return true;
        return false;
    }
    
    @Override
    public String toString() {
    	return new StringBuilder().append(this.x).append(" ").append(this.y).toString();
    }
    
}
public class PathInAMatrix {

	public List<List<Tuple>> getPath(Tuple start, Tuple end, int[][] matrix) {
	    
	    List<Tuple> path = new ArrayList<>();
	    List<List<Tuple>> result = new ArrayList<>();
	    path.add(start);
	    if (matrix[end.x][end.y] != 1) return result;
	    getPath(start, end,matrix, path, new HashSet<Tuple>(), result);
	    return result;
	    
	}


	public void getPath(Tuple start, Tuple end, int[][] matrix, List<Tuple> path, Set<Tuple> visited, List<List<Tuple>> result) {
	    
	    if (start.x == end.x && start.y == end.y) {
	        result.add(new ArrayList<>(path));
	        return;
	    }
//	    visited.add(start);
	    
	    int[] row = {0,0, -1, 1};
	    int[] col = {-1, 1, 0, 0};
	    
	    for (int k = 0; k < row.length; k++) {
	        int rowIndex = start.x + row[k];
	        int colIndex = start.y + col[k];
	    
	        if (rowIndex >=0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length) {
	            
	            if(matrix[rowIndex][colIndex] == 1) {
	                Tuple next = new Tuple(rowIndex, colIndex);
	                if(!visited.contains(next) && !next.equals(start)) {
	                    path.add(next);
	                    getPath(next, end, matrix, path, visited,result);
	                    path.remove(next);
	                }
	                
	            }
	        }
	    }
	    visited.add(start);
	    return;	    
	    
	}
	
	public static void main(String args[]) {
		PathInAMatrix mat = new PathInAMatrix();
		int[][] matrix = {
				{0, 1, 0, 0},
				{0, 1, 1, 1},
				{0 ,1 ,1 ,0},
				{0, 1, 1, 0},
				{1 ,1 ,1 ,0}
		};
		Tuple start = new Tuple(1,1);
		Tuple end = new Tuple(4, 2);
		for (List<Tuple> l : mat.getPath(start, end, matrix)) {
			System.out.println(Arrays.toString(l.toArray()));

		}
	}
}
