package arrays;


import org.junit.Assert;
import org.junit.Test;

public class LongestMountain {
    public int longestMountain(int[] A) {
        int maxLength = 2;
        if (A == null || A.length == 0) return 0;
        int[] up = new int[A.length];
        int[] down = new int [A.length];
        down[0] = 0;
        up[A.length -1] = 0;
        for (int i = A.length-2; i >=0 ; i--) {
        	if (A[i] > A[i+1]) down[i] = down[i+1] +1;
        	
        }
        for (int i = 1 ; i < A.length ; i++) {
        	if (A[i] > A[i-1]) up[i] = up[i-1] + 1;
        	int newLength = up[i]+down[i]+1;
        	if (up[i] > 0 && down[i] > 0 && newLength > maxLength) {
        		maxLength = newLength;
        	}
        }
        return maxLength == 2 ?  0:maxLength;
    }
    
    @Test
    public void test1() {
    	LongestMountain obj = new LongestMountain();
    	int[] arr = {2,1,4,7,3,2,5};
    	int[] arr2 = {2,2,2};
    	Assert.assertEquals(5, obj.longestMountain(arr));
    	Assert.assertEquals(0, obj.longestMountain(arr2));

    }
}
