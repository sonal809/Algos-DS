package code;


import org.junit.Assert;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.
 * @author sonaggarwal
 * https://leetcode.com/problems/search-insert-position/description/
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        if (target > nums[nums.length-1]) {
           return nums.length;
        }
        if(target < nums[0]) {
            return 0;
        }
        for(; i<nums.length ; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (nums[i] > target) {
                return i-1;
            }
        }
        return i;
    }
    
    public int searchInsertBinary(int[] nums, int target) {
    	return searchInsertBinaryHelper(nums, target, 0, nums.length-1);
    }
    
    public int searchInsertBinaryHelper(int[] nums, int target, int low, int high) {
    	int mid = (low+high)/2;
    	if (nums[mid] > target) {
    		return searchInsertBinaryHelper(nums, target, low, mid-1);
    	} else if (nums[mid] < target) {
    		return searchInsertBinaryHelper(nums, target, mid+1, high);
    	}
    	return mid;
    }
    
    /**
     * Leetcode solution
     * @param A
     * @param target
     * @return
     */
        public static int searchInsertLC(int[] A, int target) {
        	int low = 0, high = A.length-1;
        	while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    /**
     * Sinchi's solution
     */
    	private static int find(int[] arr, int low, int high, int k) {

    		if (low < high) {

    			int mid = (low + high)/2;



    			if (arr[mid] == k) {

    				return mid;

    			}

    			if (arr[mid] > k) {

    				return find(arr, low, mid, k);

    			} else {

    				return find(arr, mid +1, high, k);

    			}

    		}

    		System.out.println("Should have been in the index: " + high);

    		return -1;

    	}
    public static void main(String args[]) {
    	int[] nums = {1,2,3,4};
    	Assert.assertEquals(0, SearchInsertPosition.searchInsertLC(nums, 0));
    //	Assert.assertEquals(0, SearchInsertPosition.find(nums, 0, nums.length-1, 0));
    	
    	int[] nums2 = {1,2,3,5,10,20};
    	Assert.assertEquals(4, SearchInsertPosition.searchInsertLC(nums2, 8));
    	Assert.assertEquals(4, SearchInsertPosition.find(nums2,0,nums.length-1, 8));


    	
    }
}
