package code;

/**
 * Delete the nth node from the end of a linked list
 * @author sonaggarwal
 *
 */
public class NthNodeLinkedList {
	class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
		Node(){
			
		}

	}
	public Node createLinkedList(int[] arr) {
		Node head = new Node();
		Node temp = head;		
		for (int val : arr) {
			temp.next = new Node(val);
			temp = temp.next;
		}
		return head.next;
	}
	
	public void printList(Node n) {
		while(n != null) {
			System.out.print( n.value +"->" );
			n = n.next;
		}
		System.out.println();
	}
	
	public Node deleteNthNode(Node head, int n) {
		if (head == null) {
			return null;
		}
		Node first = head;
		Node second = head;
		for (int i = 1; i< n+1; i++ ) {
			first = first.next;
		}
		//remove the first element
		if (first == null) {
			return head.next;
		}
		
		while(first.next != null) {
			second = second.next;
			first = first.next;
		}
		second.next = second.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		NthNodeLinkedList obj = new NthNodeLinkedList();
		Node head = obj.createLinkedList(arr);
		obj.printList(head);
		obj.deleteNthNode(head, 2);
		obj.printList(head);
		
		int[] arr2 = {1,2,3,4,5};
		Node head2 = obj.createLinkedList(arr2);
		obj.printList(head2);
		head2 = obj.deleteNthNode(head2, 5);
		obj.printList(head2);

	}
}
