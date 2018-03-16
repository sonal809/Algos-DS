package code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSumProblem {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int start = 0; start <= nums.length - 3; start ++) {
        	while (start > 0 && nums[start] == nums[start-1]) {
        		start++;
        	}
        	int mid = start+1;
        	int end = nums.length -1;
        	int sum = 0 - nums[start];
            while (mid < end) {
                if (nums[mid] > sum) {
                    break;
                }
                List<Integer> triplet = new ArrayList<Integer>();
                if (nums[mid]+nums[end] == sum) {
                    triplet.add(nums[start]);
                    triplet.add(nums[mid]);
                    triplet.add(nums[end]);
                    result.add(triplet);
                    mid++;
                    while(mid > start && nums[mid] == nums[mid-1]) {
                    	mid++;
                	}
                    while(end< nums.length-2 && nums[end] == nums[end+1]) {
                    	end--;
                	}
                    end--;
                }
                else if (nums[mid]+ nums[end] < sum) {
                	mid++;
                	
                } else {
                	end--;                	
                }
            }
           
        }
        return result;
    }
	
	public static void main(String[] args) {
		ThreeSumProblem obj = new ThreeSumProblem();
		int[] arr = {-1,0,1,2,-1,-4};
		int[] arr2 ={-2,0,0,2,2};
		int[] arr3 = {-6, -2,-2, 0 , 0, 1 , 1, 2};
		List<List<Integer>> result = obj.threeSum(arr2);
		List<List<Integer>> result3 = obj.threeSum(arr3);
	}
}
