package trees;

import pojos.TreeNode;
import util.TreeNodeUtil;

public class CheckValidBST {
	    public static int last_node = Integer.MIN_VALUE;
	    public static boolean isValidBST(TreeNode root) {
	        if (root == null) return true;
	        if (!isValidBST(root.left)) return false;
	        if (root.val <= last_node) return false;
	        last_node = root.val;
	        if (!isValidBST(root.right)) return false;
	        return true;
	    }
	    
	    
	    public static void main(String args[]) {
	    	TreeNode root = TreeNodeUtil.stringToTreeNode("[0]");
	    	boolean result = isValidBST(root);
	    	System.out.println(result);
	    }
}
