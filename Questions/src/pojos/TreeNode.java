package pojos;

public class TreeNode {
	public TreeNode right;
	public TreeNode left;
	public int val;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
