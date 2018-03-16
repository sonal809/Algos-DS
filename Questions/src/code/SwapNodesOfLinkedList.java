package code;

import pojos.ListNode;
import util.ListNodeUtil;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


 * @author sonaggarwal
 *
 */

public class SwapNodesOfLinkedList {
	public ListNode swapPairs(ListNode head) {
		ListNode node = head;
		head = node.next;
		ListNode node1 = node;
		ListNode node2 = node.next;
		while(node.next != null && node.next.next != null) {
			ListNode node3 = node.next.next;
			node2.next = node1;
			node1.next = node2.next;
			node1 = node2;
			node = node3;
		}
		if (node.next != null) {
			node2.next = node;
			node.next = null;
			node = node2;
		}
		return head;
    }
	
	public static void main(String args[]) {
		SwapNodesOfLinkedList obj = new SwapNodesOfLinkedList();
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {2,1,4,3,5};
		ListNode head1 = ListNodeUtil.createLinkedList(arr1);
		ListNode head2 = ListNodeUtil.createLinkedList(arr2);
		System.out.println(head1);
		System.out.println(head2);
		System.out.println(obj.swapPairs(head1));
	}
}
