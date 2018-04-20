package code;

import java.util.HashMap;
import java.util.Map;

class DLLNode {
    DLLNode next;
    DLLNode prev;
    public int key;
    public int val;
    
    DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
    
}
public class LRUCache {
    Map<Integer, DLLNode> map;
    DLLNode head;
    DLLNode tail;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.get(key) == null) return -1;
        DLLNode node = map.get(key);
        //remove node from its previous position:
        if(node != head) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        if (next != null) next.prev = prev;        	
        if(prev != null) prev.next = next;
        
        //bring it to head
	        DLLNode nextNode = head;
	        node.next = nextNode;
	        nextNode.prev = node;
	        head = node;
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        DLLNode node = new DLLNode(key, value);
        System.out.println(key+" -- "+value);
        if (size >= capacity && head != null) {
            DLLNode tail = head;
            while(tail.next != null) {
                tail = tail.next;
                System.out.println("Node value ->"+tail.val);
            }
            map.remove(tail.key);
            if (tail.prev == null) {
            	head = null;
            } else {
            	DLLNode newTail = tail.prev;
            	newTail.next = null;
            }
            size--;
        }
        if (head == null) {
            head = node;
        }
        else {
            DLLNode nextNode = head;
            node.next = nextNode;
            nextNode.prev = node;
            head = node;
        }
        if (map.get(key) != null) {
            DLLNode oldNode = map.get(key);
            DLLNode prev = oldNode.prev;
            DLLNode next = oldNode.next;
            prev.next = next;
            next.prev = prev;
        }
        map.put(key, node);
        size++;

    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(2, 1);
    	cache.put(3, 2);
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(2));

    	cache.put(4, 3);
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));


    	
    	
    }
}
