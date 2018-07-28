package code;

import java.util.Arrays;

public class MeetingRooms {
	 public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}
	 
	   public int minMeetingRooms(Interval[] intervals) {
	        int[] start = new int[intervals.length];
	        int[] end = new int[intervals.length];
	        
	       
	        for (int i = 0; i < intervals.length; i++ ) {
	        	start[i] = intervals[i].start;
	        	end[i] = intervals[i].end;
	        }
	        
	        Arrays.sort(start);
	        Arrays.sort(end);
	        int rooms = 0;
	        int endIndex = 1;
	        for (int i = 1 ; i < start.length ; i++) {
	        	if (start[i] > end[endIndex]) {
	        		rooms++;
	        	} else endIndex++;
	        }
	        return rooms;
	    }
}
