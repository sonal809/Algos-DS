package trees;

import pojos.TreeNode;

/**
 * Given a sorted array with unique integer elements, write an algorith to create a BST with minimal height.
 * @author sonaggarwal
 *
 */
public class BSTwithMinimalHeight {
	//end will be arr.length in the beginning.
	
	TreeNode createminimalBST(int arr[], int start, int end) {
		if (start > end) return null;
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createminimalBST(arr, start, mid-1);
		node.right = createminimalBST(arr, mid+1, end);
		return node;
	}
}
