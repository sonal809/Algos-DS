package code;

import junit.framework.Assert;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = nums[0];
        int maxSum = sum;
        for (int i=1;i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > sum) {
                sum = nums[i];
            } 
            if(sum > maxSum) {
            	maxSum = sum;
            }
        }
        return maxSum;
    }
    
    /**
     * Divide and conquer approach
     * @param nums
     * @return
     */
    public int maxSubArrayDC(int[] nums) {
    	return maxSubArrayDCHelper(nums, 0, nums.length-1);
    }
    
    
    public int maxSubArrayDCHelper(int[] nums, int low, int high) {
    	int mid = (low+high)/2;
    	if (low == high) {
    		return nums[low];
    	}
    	int leftMax = maxSubArrayDCHelper(nums, low, mid);
    	int rightMax = maxSubArrayDCHelper(nums, mid+1, high);
    	int crossSum = maxSubArrayDCHelperCross(nums, low, high);
    	return Math.max(leftMax, Math.max(rightMax, crossSum));
    }
    
    public int maxSubArrayDCHelperCross(int[] nums, int low, int high) {
    	int mid = (low+high)/2;
    	int i = mid;
    	int j = mid+1;
    	int maxleftSum = Integer.MIN_VALUE;
    	int leftSum = 0;
    	while(i >= low) {
    		leftSum += nums[i];
    		if (leftSum > maxleftSum) {
    			maxleftSum = leftSum;
    		}
    		i--;
    	}
    	int rightSum = 0;
    	int maxRightSum = Integer.MIN_VALUE;
    	while(j <= high) {
    		rightSum += nums[j];
    		if(rightSum > maxRightSum) {
    			maxRightSum = rightSum;
    		}
    		j++;
    	}
    	if (maxleftSum < 0 || maxRightSum < 0) {
    		return Math.max(maxleftSum, maxRightSum);
    	} else return maxleftSum + maxRightSum;
    }
    
    @SuppressWarnings("deprecation")
	public static void main(String args[]) {
    	MaxSubArray maxSubArray = new MaxSubArray();
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	maxSubArray.maxSubArray(nums);
        int arr[] = {2, 3, 4, 5, 7};

    	Assert.assertEquals(maxSubArray.maxSubArray(nums), 6);
    	int[] nums2 = {-2,-1,-3};
    	Assert.assertEquals(-1, maxSubArray.maxSubArray(nums2));
    	
    	// Check divide and conquer approach
    	Assert.assertEquals(6, maxSubArray.maxSubArrayDC(nums));
    	Assert.assertEquals(-1, maxSubArray.maxSubArrayDC(nums2));
    	Assert.assertEquals(21, maxSubArray.maxSubArray(arr));
    	Assert.assertEquals(21,  maxSubArray.maxSubArrayDC(arr));
    	


    }
}
