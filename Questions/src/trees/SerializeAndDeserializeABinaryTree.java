package trees;

import java.util.LinkedList;
import java.util.Queue;

import pojos.TreeNode;

public class SerializeAndDeserializeABinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode curr = queue.poll();
        	if (curr == null) {
        		break;
        	}
        	if(curr.val == Integer.MIN_VALUE) {
        		sb.append("null,");
        		continue;
        	}
        	sb.append(curr.val).append(",");
        	if(curr.left != null) {
        		queue.add(curr.left);
        	} else queue.add(new TreeNode(Integer.MIN_VALUE));
        	if(curr.right != null) {
        		queue.add(curr.right);
        	} else queue.add(new TreeNode(Integer.MIN_VALUE));
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] nodes = data.split(",");
        if(nodes.length == 0) {
        	return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int i = -1;
        while(i < (nodes.length-2)/2) {
        	TreeNode curr = nodeList.poll();
        	i++;
        	if (!nodes[2*i+1].equals("null")) {
        		int left = Integer.parseInt(nodes[2*i+1]);
        		if (left > Integer.MIN_VALUE) {
        			TreeNode leftNode = new TreeNode(left);
        			curr.left = leftNode;
        			nodeList.add(leftNode);
        		}
        		
        	}
        	if (!nodes[2*i+2].equals("null")) {
        		int right = Integer.parseInt(nodes[2*i+2]);
        		if(right > Integer.MIN_VALUE) {
        			TreeNode rightNode = new TreeNode(right);
        			curr.right = rightNode;
        			nodeList.add(rightNode);
        		}       	
        	}
        }
        return root;
        
    }
    
    public static void main(String args[]) {
    	SerializeAndDeserializeABinaryTree obj = new SerializeAndDeserializeABinaryTree();
    	String input1 = "1,2,3,null,null,4,5,null,null,null,null";
    	TreeNode root = obj.deserialize(input1);
    	System.out.println(obj.serialize(root));
    	String input2 = "1,2,3,null,null,4,5,null,null,6,7,null,null,null,null";
    	TreeNode root2 = obj.deserialize(input2);
    	System.out.println(obj.serialize(root2));
    }
}
