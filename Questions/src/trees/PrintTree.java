package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class PrintTree {
	class TreeNode {
		TreeNode right;
		TreeNode left;
		char value;
		
		TreeNode(char value) {
			this.value = value;
		}
	}
	
	private Map<Character, Integer> getInorderMap(TreeNode node) {
		Map<Character, Integer> inorderMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		inorderString(node, sb);
		for (int i = 0 ; i < sb.length(); i++) {
			inorderMap.put(sb.toString().charAt(i), i);
		}
		return inorderMap;
	}
	
	private void inorderString(TreeNode node, StringBuilder sb) {
		if (node == null) return;
		inorderString(node.left, sb);
		sb.append(node.value);
		inorderString(node.right, sb);
	}
	
	public void printTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		Map<Character, Integer> inorderMap = getInorderMap(root);
		while(!q.isEmpty()) {
			Queue<TreeNode> levelNodes = new LinkedList<>();
			int start = 0;
			StringBuilder sb = new StringBuilder();
			for (TreeNode node: q) {
				int index = inorderMap.get(node.value);
				while(start < index) {
					sb.append(" ");
					start++;
				}
				sb.append(node.value);
				start++;
				if (node.left != null) levelNodes.add(node.left);
				if (node.right != null) levelNodes.add(node.right);				
			}
			
			q = levelNodes;
			System.out.println(sb.toString());
		}
	}
	
	@Test
	public void test1() {
		PrintTree p = new PrintTree();
		TreeNode node = new TreeNode('a');
		node.left = new TreeNode('b');
		node.left.left = new TreeNode('d');
		node.left.right = new TreeNode('e');
		node.left.right.left = new TreeNode('h');
		node.left.right.right = new TreeNode('g');
		node.right = new TreeNode('c');
		node.right.right = new TreeNode('f');
		p.printTree(node);
	}
}
