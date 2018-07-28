package trees;

import org.junit.Assert;
import org.junit.Test;

import pojos.TreeNode;

public class LeftLeavesSum {
	static int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        if (root.left != null) sum += root.left.val;
        return sum;       
    }
    
    
    
    @Test
    public void test1() {
    	TreeNode root = new TreeNode(10);
    	
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(7);
    	root.right.right = new TreeNode(5);
    	root.left.left = new TreeNode(2);
    	root.right.left = new TreeNode(3);

    	root.left.right = new TreeNode(20);
    	LeftLeavesSum obj = new LeftLeavesSum();
    	Assert.assertEquals(6,obj.sumOfLeftLeaves(root));
    }
}
