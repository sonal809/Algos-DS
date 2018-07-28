package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
     @Override
     public String toString() {
    	 return "["+start+","+end+"]";
     }
 }
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals == null || intervals.size() == 0) {
    		List<Interval> l = new ArrayList<Interval>();
    		l.add(newInterval);
    		return l;
    	}
    	List<Interval> combinedList = new ArrayList<>();
    	boolean newIntervalAdded = false;
    	for (int i = 0; i< intervals.size(); i++) {
    		if(!newIntervalAdded && intervals.get(i).start > newInterval.start) {
    			combinedList.add(newInterval);
    			newIntervalAdded = true;
    		} 
    		combinedList.add(intervals.get(i));
    	}
    	List<Interval> newIntervalList = new ArrayList<>();
    	Interval currInterval = combinedList.get(0);
    	for (int i = 1; i < combinedList.size(); i++) {
    		if (currInterval.end > combinedList.get(i).start) {
    			currInterval = new Interval(currInterval.start, Math.max(combinedList.get(i).end, currInterval.end));
    		} else {
    			newIntervalList.add(currInterval);
    			currInterval = combinedList.get(i);
    		}
    	}
    	newIntervalList.add(currInterval);
    	return newIntervalList;
    }
    
    @Test
    public void test1() {
    	//[[1,3],[6,9]]
    	//[2,5]
    	InsertInterval obj = new InsertInterval();
    	Interval a = new Interval(1,3);
    	Interval b = new Interval(6,9);
    	List<Interval> list = Arrays.asList(a,b);
    	List<Interval> newList = obj.insert(list, new Interval(2,5));
    	System.out.println(Arrays.toString(newList.toArray()));
    }
}
