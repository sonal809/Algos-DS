package code;

/*
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa. 
 * Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.
 * 
 */
public class ArrayRotation {
	
	public void arrayRotate(int[] nums) {
		//move -ve elements to one end
		int n = nums.length;
		int i = 0;
		int j = n-1;
		while( i < j) {
			while(nums[i] < 0) {
				i++;
			}
			while(nums[j] > 0) {
				j--;
			}
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
		System.out.println(nums);
		
		int k = 1;
		while (k < n && i < n) {
			int temp = nums[k];
			nums[k] = nums[i];
			nums[i] = temp;
			
			i = i+1;
			k = k+2;
		}
		
	}
}
