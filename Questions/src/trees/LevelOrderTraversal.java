package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pojos.TreeNode;
import util.TreeNodeUtil;

public class LevelOrderTraversal {
	
	public static List<List<TreeNode>> bfs(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<>();
		List<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		result.add(queue);
		while(!queue.isEmpty()) {
			List<TreeNode> levelNodes = new ArrayList<>();
			for (TreeNode node: queue) {
				if (node.left != null) levelNodes.add(node.left);
				if (node.right != null) levelNodes.add(node.right);				
			}
			if (!levelNodes.isEmpty()) {
				result.add(levelNodes);
			}
			queue = levelNodes;
		}
		return result;
	}
	
	public static List<List<TreeNode>> dfs(TreeNode node) {
		List<List<TreeNode>> result = new ArrayList<>();
		dfsHelper(node, result, 0);
		return result;
	}
	
	private static void dfsHelper(TreeNode node, List<List<TreeNode>> result, int level) {
		if(node != null) {
			List<TreeNode> levelNodes = new ArrayList<TreeNode>();
			if(result.size() > level) {
				levelNodes = result.get(level);				
			} else result.add(level, levelNodes);
			levelNodes.add(node);

			dfsHelper(node.left, result, level+1);
			dfsHelper(node.right, result, level+1);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(50);
		TreeNodeUtil.insertBST(node, 30);
		TreeNodeUtil.insertBST(node, 80);
		TreeNodeUtil.insertBST(node, 20);
		TreeNodeUtil.insertBST(node, 35);
		TreeNodeUtil.insertBST(node, 60);
		TreeNodeUtil.insertBST(node, 90);
		TreeNodeUtil.insertBST(node, 15);
		
		List<List<TreeNode>> result =LevelOrderTraversal.dfs(node);
		for (List<TreeNode> levelNodes : result) {
			System.out.println(Arrays.toString(levelNodes.toArray()));
		}
		
		List<List<TreeNode>> resultbfs =LevelOrderTraversal.bfs(node);
		for (List<TreeNode> levelNodes : resultbfs) {
			System.out.println(Arrays.toString(levelNodes.toArray()));
		}
	}
}
