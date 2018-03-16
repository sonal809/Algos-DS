package code;
/**
 * houses are in a circle
 * first house is the neighbor of the last house
 * @author sonaggarwal
 *
 */
public class HouseRobber2 {
    public static int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1,  nums.length));
    }
    
    public static int rob(int[] nums, int start, int end) {
    	System.out.println("rob");
        int length = end-start;
        int[] maxSums = new int[length];
        if(nums.length == 1) {
            return nums[0];
        }
        maxSums[0] = nums[start];
        maxSums[1] = Math.max(nums[start], nums[start+1]);
        int j = 2;
        for (int i = start+2 ; i < end; i++) {
        	System.out.println("i-->"+ i);
        	System.out.println("First val -->"+ maxSums[i-2]+nums[i]);
        	System.out.println("Second val -->" + maxSums[i-1]);
            maxSums[j] = Math.max(maxSums[j-2]+nums[i], maxSums[j-1]);
        }
        return maxSums[maxSums.length-1];
    }
    
    public static void main(String[] args) {
    	int[] array = {1,2,1,1};
    	System.out.println(rob(array));
    }
}
