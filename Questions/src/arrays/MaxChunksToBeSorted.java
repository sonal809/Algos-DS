package arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxChunksToBeSorted {
    
	public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
	
    public int maxChunksToSorted2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }
        
        int count = 0;
        int upperLimit = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max[i] == sorted[i]) {
                if (sorted[i] > upperLimit) continue;
                
                count++;
                upperLimit = arr[i];
            }
        }
        
        return count;
    }
    
	@Test
	public void test1() {
		MaxChunksToBeSorted obj = new MaxChunksToBeSorted();
		int[] arr = {4,3,1,0,2};
		Assert.assertEquals(1, obj.maxChunksToSorted(arr));		
	}
	
	@Test
	public void test2() {
		MaxChunksToBeSorted obj = new MaxChunksToBeSorted();
		int[] arr2 = {2, 1, 4, 4, 3, 5, 7, 6};
		Assert.assertEquals(4, obj.maxChunksToSorted2(arr2));		

	}
}
