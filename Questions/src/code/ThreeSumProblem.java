package code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	public boolean sumToTarget(int[] arr, int target, int excludeIndex) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < arr.length; i++) {
	        map.put(arr[i], i);
	    }
	    for (int i = 0; i< arr.length; i++) {
	      int otherNo = target - arr[i];
	      if( i == excludeIndex) {
	          continue;
	      }
	      if (map.containsKey(otherNo) && map.get(otherNo) != i && map.get(otherNo) != excludeIndex) {
	          return true;
	      }
	    }
	    return false;
	}

	public boolean sum3Target(int[] arr, int target) {
	    for(int i = 0 ; i < arr.length; i++) {
	        int sum2 = target - arr[i];
	        if (sumToTarget(arr, sum2, i)) {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	public static void main(String[] args) {
		ThreeSumProblem obj = new ThreeSumProblem();
		int[] arr = {-1,0,1,2,-1,-4};
		int[] arr2 ={-2,0,0,2,2};
		int[] arr3 = {-6, -2,-2, 0 , 0, 1 , 1, 2};
		List<List<Integer>> result = obj.threeSum(arr2);
		List<List<Integer>> result3 = obj.threeSum(arr3);
		
		int[] arr4 = {1,-6, 8, 2,3, -5,	2};
		System.out.println(obj.sum3Target(arr4, 2));
	}
}
