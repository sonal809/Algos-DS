package trees;

import org.junit.Assert;
import org.junit.Test;

import pojos.TreeNode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
 * then this node's value is the smaller value among its two sub-nodes.

	Given such a binary tree, you need to output the second minimum value in the set made 
	of all the nodes' value in the whole tree.

	If no such second minimum value exists, output -1 instead.
 * @author sonaggarwal
 *
 */
public class SecondMinimum {
	private int firstMin;
	private int secondMin;
    public int findSecondMinimumValue(TreeNode root) {
    
         firstMin = root.val;
         secondMin = -1;
        
        findSecondMinimumValueHelper(root);
        
        return secondMin;
    }  
    
    private void findSecondMinimumValueHelper(TreeNode root) {
        if (root == null) return;

        if (root.val < firstMin) {
        	secondMin = firstMin;
        	firstMin = root.val;        	
        } else {
        	if (secondMin == -1 && root.val != firstMin) {
        		secondMin = root.val;
        	}
        }
        findSecondMinimumValueHelper(root.left);
        findSecondMinimumValueHelper(root.right);
    }
    
    @Test
    public void test() {
    	SecondMinimum sm = new SecondMinimum();
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.left.right = new TreeNode(7);
    	root.left.left = new TreeNode(5);
    	Assert.assertEquals(5,sm.findSecondMinimumValue(root));
    }
}
