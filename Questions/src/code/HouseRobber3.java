package code;
import java.util.HashMap;
import java.util.Map;


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
	
	public int rob(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		return robHelper(root, map);
	}
	

	public int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
			if (root == null) return 0;
			if (map.containsKey(root)) return map.get(root);
			int left = robHelper(root.left, map);
			
			int right = robHelper(root.right, map);
			
			int val = 0;
			if (root.left != null) {
				val += robHelper(root.left.left, map)+robHelper(root.left.right, map);
			}
			if (root.right != null) {
				val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
			}
			int max = Math.max(root.val + val, left+right);
			map.put(root, max);
			return max;
			
	}
}
