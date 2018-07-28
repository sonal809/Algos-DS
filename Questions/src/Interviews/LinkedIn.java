package Interviews;

import pojos.TreeNode;

public class LinkedIn {
	static TreeNode root;
	static int counter;
	public static void createBST(int[] keys) {
	//	Integer counter = 0;
		for (int key: keys) {
			if (root == null) {
				root = new TreeNode(key);
			} else insert(root, key);
			System.out.println(counter);
		}
	}
	
	private static TreeNode insert(TreeNode node, int key) {
		//System.out.println(counter);
		counter++;
		if(node == null) {
			node = new TreeNode(key);
			return node;
		}
		if (key < node.val) node.left = insert(node.left, key);
		else if (key > node.val) node.right = insert(node.right, key);
		return node;
	}
	
	public static void main(String args[]) {
		int[] arr = {2,1,3,4};
		LinkedIn.createBST(arr);
		
	}
}
