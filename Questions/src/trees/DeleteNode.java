package trees;

import pojos.TreeNode;
import util.TreeNodeUtil;

public class DeleteNode {

    void deleteKey(TreeNode root, int key)
    {
        root = deleteRec(root, key);
    }
 
    TreeNode deleteRec(TreeNode root, int key)
    {
        if (root == null)  return root;
 
        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.value = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
 
        return root;
    }
 
    int minValue(TreeNode root)
    {
        int minv = root.value;
        while (root.left != null)
        {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
    
    
    public static void main(String args[]) {
    	DeleteNode obj = new DeleteNode();
    	TreeNode node = new TreeNode(20);
    	TreeNodeUtil.insertBST(node, 5);
    	TreeNodeUtil.insertBST(node, 10);
    	TreeNodeUtil.insertBST(node, 7);
    	TreeNodeUtil.insertBST(node, 15);
    	TreeNodeUtil.insertBST(node, 70);
    	obj.deleteRec(node, 10);
    	System.out.println(node.value);




    }
}
