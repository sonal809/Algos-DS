package code;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/house-robber-iii/description/
 * @author sonaggarwal
 *
 */
public class HouseRobber3 {
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      
      @Override
      public String toString() {
    	  String left = null;
    	  String right = null;
    	  if (this.left != null) {
    		  left = String.valueOf(this.left.val);
    	  }
    	  if (this.right != null) {
    		  right = String.valueOf(this.right.val);
    	  }
    	  return "TreeNode: "+this.val + " left: "+left+" right: "+ right;
    	  
      }
	}
	public class NodeLevel {
		public TreeNode node;
		public int level;
		
		NodeLevel(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
		@Override
		public String toString() {
			return this.node.toString() + " level: "+this.level;
		}
	}
	
	public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return dp[1];
        }
        for (int i = 2; i< nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        } 
        return dp[nums.length-1];
    }
	
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<NodeLevel> queue = new LinkedList<NodeLevel>();
		int levels = height(root);
		int[] values = new int[levels];
		queue.add(new NodeLevel(root, 0));
		while(!queue.isEmpty()) {
			NodeLevel queueNode = queue.poll();
			TreeNode node = queueNode.node;
			values[queueNode.level] += node.val;
			if (node.left != null) {
				queue.add(new NodeLevel(node.left, queueNode.level+1));
			}
			if (node.right != null) {
				queue.add(new NodeLevel(node.right, queueNode.level+1));
			}
		}
		return rob(values);
	}
}
