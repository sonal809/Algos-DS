package dp;


import org.junit.Assert;
import org.junit.Test;

public class JumpGame {
    public boolean canJump(int[] nums) {
    	boolean[] reachable = new boolean[nums.length];
    	reachable[0] = true;
    	for (int i = 0; i < nums.length ; i++) {
    		if (reachable[i]) {
    			int jumps = nums[i];
    			while(jumps > 0) {
    				if (i + jumps < nums.length) {
    					reachable[i + jumps]  = true;
    					if (reachable[nums.length -1]) return true;
    				}
    				jumps -= 1;
    			}
    		}
    	}
    	
    	return reachable[nums.length-1];
    }
    
    @Test
    public void test1() {
    	JumpGame jp = new JumpGame();
    	int[] arr = {2,3,1,1,4};
    	Assert.assertTrue(jp.canJump(arr));
    }
    
    
    @Test
    public void test2() {
    	JumpGame jp = new JumpGame();
    	int[] arr = {3,2,1,0,4};
    	Assert.assertFalse(jp.canJump(arr));
    }
}
