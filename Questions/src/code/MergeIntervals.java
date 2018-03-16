package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
	class Interval {
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) { start = s; end =e;}
		@Override
		public String toString() {
			return ("{" + start + ","+ end + "}");
		}
	}
	
	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		Stack<Interval> intervalStack = new Stack();
		for (Interval interval : intervals) {
			if (intervalStack.isEmpty()) {
				intervalStack.push(interval);
			} else {
				Interval topInterval = intervalStack.peek();
				if (interval.start > topInterval.end) {
					intervalStack.push(interval);
				}
				else {
					topInterval.end = interval.end;
				}
			}
		}
		List<Interval> resultingIntervalList = new ArrayList<Interval>();
		for (Interval i: intervalStack) {
			resultingIntervalList.add(i);
		}
		System.out.println(Arrays.toString(resultingIntervalList.toArray()));
		return resultingIntervalList;
	}
	
	
	public static void main(String args[]) {
		MergeIntervals obj = new MergeIntervals();
		Interval i1 = obj.new Interval(2,5);
		Interval i2 = obj.new Interval(4,7);
		Interval i3 = obj.new Interval(8,10);
		List<Interval> intervalList = new ArrayList<>();
		intervalList.add(i2);
		intervalList.add(i1);
		intervalList.add(i3);
		obj.merge(intervalList);
		
	}
}
