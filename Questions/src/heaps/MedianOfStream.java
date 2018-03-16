package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
	
    
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder()); 
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
    public void addNum(int num) {
    	if(minHeap.size() > 0 && num > minHeap.peek()) {
    		minHeap.add(num);
    	}
    	else {
    		maxHeap.add(num);
    	}
        if (maxHeap.size() > minHeap.size()) {
        	minHeap.add(maxHeap.remove());       	
        } else if (minHeap.size() > maxHeap.size()) {
        	maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
        	return minHeap.peek();
        } else if(maxHeap.size() > minHeap.size()) {
        	return maxHeap.peek();
        }
        else return ((minHeap.peek() + maxHeap.peek())/2.0);
    }
    
    
    public static void main(String args[]) {
    	MedianOfStream obj = new MedianOfStream();
    	obj.addNum(1);
    	System.out.println(obj.findMedian());
    	obj.addNum(2);
    	System.out.println(obj.findMedian());
    	obj.addNum(3);
    	System.out.println(obj.findMedian());
    	//obj.addNum(1);
    	//System.out.println(obj.findMedian());

    }
}
