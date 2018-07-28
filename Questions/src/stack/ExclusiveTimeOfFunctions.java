package stack;

import java.util.List;
import java.util.Stack;
/**
 * TODO Incomplete.
 * @author sonaggarwal
 *
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        String[] job_1 = logs.get(0).split(":");
        stack.push(Integer.parseInt(job_1[0]));
        int i = 1;
        int time = Integer.parseInt(job_1[2]);
        int[] res = new int[n];
        res[0] = time;
        while(i < logs.size()) {
        	String[] next = logs.get(i).split(":");
        	//Push if start, pop if end. Now how to update time and res is important.
        	//Always res[stack.peek()] is updated.
        	if (next[1].equals("start")) {
        		if(!stack.isEmpty()) {
        			
        		}
        	}
        }
        
        return res;
    }
}
