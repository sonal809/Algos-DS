package util;

import pojos.ListNode;

public class ListNodeUtil {
	
	public static ListNode createLinkedList(int[] arr) {
		ListNode head = new ListNode(arr[0]);
		ListNode node = head;
		for (int i=1; i< arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		return head;
	}
}
