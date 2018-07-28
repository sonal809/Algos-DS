package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> q ;
    int size ;
    int currSum;
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        int removed = 0;
    	if (q.size() >= size) {
        	removed = q.remove();
        }
        currSum -= removed;
        q.add(val);
        currSum += val;
        return (double)currSum/q.size();
  
    }
}
