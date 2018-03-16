package code;
import java.util.Arrays;

/**
 * Given an input array of integers, return an array of the  same size such that that 
 * ith element in the output array is the product of every element in the input array other 
 * than the ith element of the input array. 
 * Restriction: do not use division in your algorithm. This should be done in O(n) time complexity.
 * @author sonaggarwal
 *
 */
public class IthElementIsAProductOfOtherNumbers {

	public static int[] solution(int[] nums) {
		int[] result = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		
		left[0] = 1;
		right[nums.length-1] = 1;
		for (int i=1; i<nums.length; i++) {
			left[i] = left[i-1]*nums[i-1];
		}
		for (int i=nums.length-2; i>=0;i--) {
			right[i] = right[i+1]*nums[i+1];
		}
		for (int i=0;i<nums.length;i++){
			result[i] = left[i]*right[i];
		}
		return result;
		
	}

}
