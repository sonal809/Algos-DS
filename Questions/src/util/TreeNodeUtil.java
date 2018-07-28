package util;

import java.util.LinkedList;
import java.util.Queue;

import pojos.TreeNode;

public class TreeNodeUtil {
	
	public static TreeNode insertBST(TreeNode root, int key) {
		if(root == null) {
			root = new TreeNode(key);
			return root;
		}
		if (key < root.val) root.left = insertBST(root.left, key);
		else if (key > root.val) root.right = insertBST(root.right, key);
		return root;
	}
	
	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) +1;
	}
	
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
}
