package heaps;

public class Heap {
	
	public void buildMaxHeap(int[] nums) {
		int i = (nums.length -2)/2;
		while(i >= 0) {
			heapify(nums, i);
			i--;
			
		}
	}
	
	private void swap(int[] nums, int i , int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void heapify(int[] nums, int i) {
		if( i > (nums.length-2)/2) {
			return;
		}
		int leftChild = nums[2*i+1];
		int rightChild = Integer.MIN_VALUE;
		if (2*i+2 <= nums.length -1) rightChild = nums[2*i+2];
		int max = nums[i];
		int largest = i;
		if (leftChild > max) {
			largest = 2*i+1;
		}
		if(rightChild > max) {
			largest = 2*i+2;
		}
		if (largest != i) {
			swap(nums, i, largest);
			heapify(nums, largest);
		}
	}
}
