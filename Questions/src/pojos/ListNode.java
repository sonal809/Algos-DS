package pojos;


public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode node = this;
		while(node != null) {
			sb.append(node.val).append(" -> ");
			node = node.next;
		}
		return sb.toString();
	}
}
