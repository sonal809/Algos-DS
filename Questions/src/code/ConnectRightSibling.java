package code;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/tabs/description
 * @author sonaggarwal
 *
 */
public class ConnectRightSibling {
	public static class Node {
		Node right;
		Node left;
		int val;
	}
	
	public static class QObj {
		TreeLinkNode n;
		public int level;
		QObj(TreeLinkNode n, int level) {
			this.n = n;
			this.level = level;
		}
		public TreeLinkNode getNode() {
			return n;
		}
	}
	
	class TreeLinkNode {
		TreeLinkNode right;
		TreeLinkNode left;
		public TreeLinkNode sibling;
		int val;
		
		TreeLinkNode(int val) {
			this.val = val;
		}
		
		TreeLinkNode(Node n) {
			this.right = new TreeLinkNode(n.right.val);
			this.left = new TreeLinkNode(n.left.val);
			this.val = n.val;
		}
		
	}
	
	public void connectSiblings(TreeLinkNode root) {
		Queue<QObj> queue = new LinkedList<QObj>();
		queue.add(new QObj(root,0));
		while(!queue.isEmpty()) {
			QObj qobj = queue.poll();
			TreeLinkNode treeNode = qobj.getNode();
			if (treeNode.left != null) {				
				queue.add(new QObj(treeNode.left, qobj.level+1));
			}
			if (treeNode.right != null) {
				queue.add(new QObj(treeNode.right, qobj.level+1));
			}
			if (queue.peek() != null && queue.peek().level == qobj.level) {
				treeNode.sibling = queue.peek().getNode();
			}
			
		}
	}
}
