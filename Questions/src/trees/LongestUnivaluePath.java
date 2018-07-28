package trees;

import org.junit.Assert;
import org.junit.Test;

import pojos.TreeNode;
public class LongestUnivaluePath {
	static int maxValue;
	public int longestUnivaluePath (TreeNode root) {
		longestUnivaluePathHelper(root);
		return maxValue;
	}
	
	public void longestUnivaluePathHelper(TreeNode root) {
		if (root == null) return;
		
		int pathAtroot = countPathLen(root.left, root.val) + countPathLen(root.right, root.val);
		if(pathAtroot > maxValue) {
			maxValue = pathAtroot;
		}
		longestUnivaluePathHelper(root.left);		
		longestUnivaluePathHelper(root.right);
	}
	
	public int countPathLen(TreeNode root, int value){
		if (root == null || root.val != value) return 0;
		
		int countRight = countPathLen(root.right, value);
		
		int countLeft = countPathLen(root.left, value);
		
		return Math.max(countRight, countLeft) + 1;
	}
	
	@Test
	public void test1() {
		LongestUnivaluePath lt = new LongestUnivaluePath();
		TreeNode root = new TreeNode(1);
		Assert.assertEquals(0, lt.longestUnivaluePath(root));
	}
	
}
