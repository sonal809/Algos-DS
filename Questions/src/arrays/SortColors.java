package arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = start;
        
        while (mid <= end) {
        	switch (nums[mid]) {
	        	case 0:
	        		swap(nums, start, mid);
	        		start++;
	        		mid++;
	        		break;
	        	case 1:
	        		mid++;
	        		break;
	        	case 2:
	        		swap(nums, mid, end);
	        		end--;
	        		break;
        	}
        }
    }
    
    void swap(int[] nums, int i, int j) {
    	if(nums[i] == nums[j]) return;
    	int temp = nums[j];
    	nums[j] = nums[i];
    	nums[i] = temp;
    }
    
    @Test
    public void test() {
    	SortColors sc = new SortColors();
    	int[] nums = {2,2,2,1,1,0};
    	sc.sortColors(nums);
    	int[] exp = {0, 1, 1, 2, 2, 2};
    	Assert.assertArrayEquals(exp, nums);
    }
    
    @Test
    public void test2() {
    	SortColors sc = new SortColors();
    	int[] nums = {2,0,2,1,1,0};
    	sc.sortColors(nums);
    	int[] exp = {0, 0, 1, 1, 2, 2};
    	Assert.assertArrayEquals(exp, nums);
    }
    
    @Test
    public void test3() {
    	SortColors sc = new SortColors();
    	int[] nums = {1,2,0};
    	sc.sortColors(nums);
    	int[] exp = {0,1,2};
    	Assert.assertArrayEquals(exp, nums);
    }
}
