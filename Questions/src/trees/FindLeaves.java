package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pojos.TreeNode;

public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        
        if (root == null) return null;
        while(root != null) {
        	List<Integer> currLeaves = new ArrayList<>();
        	root = findAndRemoveLeavesCurrent(root, currLeaves);
        	leaves.add(currLeaves);
        }
        
        return leaves;
    }
    
    TreeNode findAndRemoveLeavesCurrent(TreeNode root, List<Integer> currLeaves) {
    	if (root == null) return null;
    	if (root.left == null && root.right == null) {
    		currLeaves.add(root.val);
    		return null;
    	}
    	root.left = findAndRemoveLeavesCurrent(root.left, currLeaves);
    	root.right = findAndRemoveLeavesCurrent(root.right, currLeaves);
    	

    	return root;
    }
    
    @Test
    public void test1() {
    	FindLeaves fl = new FindLeaves();
    	SerializeAndDeserializeABinaryTree util = new SerializeAndDeserializeABinaryTree();
    	String treeStr = "1,2,3,4,5";
    	TreeNode root = util.deserialize(treeStr);
    	List<List<Integer>> leaves = fl.findLeaves(root);
    	System.out.println(Arrays.deepToString(leaves.toArray()));
    }
}
