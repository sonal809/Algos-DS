package code;

import org.junit.Assert;

public class MedianOfTwoSortedArrays {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergeTwoSortedArrays(nums1, nums2);
        int l = result.length;
        if(l % 2 == 0) {
        	return (result[l/2] + result[(l-1)/2])/2.0;
        } else return result[(l)/2];
    }
    
    private int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
    	int i=0;
    	int j=0;
    	int[] result = new int[nums1.length + nums2.length];
    	int k =0;
    	while(i< nums1.length && j< nums2.length) {
    		if(nums1[i] < nums2[j]) {
    			result[k++] = nums1[i++];
    		}
    		else if(nums1[i] > nums2[j]) {
    			result[k++] = nums2[j++];
    			
    		}
    		else if (nums1[i] == nums2[j]) {
    			result[k++] = nums1[i];
    			i++;
    			j++;
    		}
    	}
    	while(i < nums1.length) {
    		result[k++] = nums1[i++];
    	}
    	while(j < nums2.length) {
    		result[k++] = nums2[j++];
    	}
    	return result;
    }
    
    public static void main(String args[]) {
    	MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
    	int[] nums1 = {1,3};
    	int[] nums2 = {2};
    	System.out.println( obj.findMedianSortedArrays(nums1, nums2));
    	
    	int[] nums3 = {1, 2};
    	int[] nums4 = {3, 4};
    	System.out.println( obj.findMedianSortedArrays(nums3, nums4)); //(2+3)/2

    	}
    
}
