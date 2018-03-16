package code;

public class MaxRectangularAreaInAHistogram {
	
	/**
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
	 * 
	 */
	
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) {
        	return maxArea;
        }
        int n = heights.length;
        for(int hIndex = 0; hIndex < n; hIndex++) {
        	int i = hIndex;
        	while(i >= 0 && heights[i] >= heights[hIndex]) {
        		i--;
        	}
        	int j = hIndex;
        	while(j < n && heights[j] >= heights[hIndex]) {
        		j++;
        	}
        	int area = (j-i-1)*heights[hIndex];
        	if(area > maxArea) {
        		maxArea = area;
        	}
        }
        return maxArea;
    }
    
    
    public static void main(String[] args) {
    	MaxRectangularAreaInAHistogram obj = new MaxRectangularAreaInAHistogram();
    	int[] nums = {2,1,5,6,2,3};
    	System.out.println(obj.largestRectangleArea(nums));
    }
}
