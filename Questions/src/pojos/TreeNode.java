package pojos;

public class TreeNode {
	public TreeNode right;
	public TreeNode left;
	public int value;
	
	public TreeNode(int val) {
		this.value = val;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
