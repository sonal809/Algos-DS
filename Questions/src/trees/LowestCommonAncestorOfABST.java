package trees;


public class LowestCommonAncestorOfABST {
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
   	if (root == null) return null;
   	
   	if (root.val > p.val && root.val > q.val) {
   		return lowestCommonAncestor(root.right, p, q);
   	}
   	if (root.val < q.val && root.val < p.val) {
   		return lowestCommonAncestor(root.left, p, q);
   	}
   	
   	else return root;
   }
}
