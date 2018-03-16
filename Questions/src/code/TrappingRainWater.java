package code;
import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author sonaggarwal
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxJ = 0;
        int maxHeight = maxHeight(height);
        int[][] grid = new int[height.length][maxHeight];
        for (int i=0; i<height.length; i++) {
        	int len = height[i];
        	for (int j=0; j < len; j++) {
        		grid[i][j] = 1;
        		if (j>maxJ) {
        			maxJ = j;
        		}
        	}
        }
        System.out.println(Arrays.deepToString(grid));

        int water = 0;      
        for ( int j=0; j<= maxJ; j++) {
        	for (int i=1; i < height.length-1 ; i++) {
        		if (grid[i][j] != 1) {
        			int wallX = getWallX(grid,i,j);
        			int wallY = getWallY(grid, i , j);
        			if (wallY-wallX-1 > 0 && grid[wallX][j] == 1 && grid[wallY][j] == 1) {
        				water += wallY-wallX-1;
        				i = wallY;
        			}
        		}
        	}
        }
        return water;
    }
    
    public int getWallX(int[][]grid, int x , int y) {
    	int i = x;
    	for (; i>0;i--) {
    		if (grid[i][y] == 1) {
    			return i;
    		}
    	}
    	return i;
    }
    
    public int getWallY(int[][]grid, int x, int y) {
    	int i = x;
    	for (;i<grid.length-1; i++) {
    		if (grid[i][y] == 1) {
    			return i;
    		}
    	}
    	return i;
    }
    
    public int maxHeight(int[] arr) {
    	int max = 0;
    	for (int item: arr) {
    		if (item> max) {
    			max = item;
    		}
    	}
    	return max;
    }
    public static void main(String[] args) {
    	int[] height= {0,2,0};
    	TrappingRainWater tw = new TrappingRainWater();
    	System.out.println(tw.trap(height));
    }
}
