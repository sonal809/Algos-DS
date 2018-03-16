package code;
/**
 * Given an array with positive integers. And you start from the first index. The number at each index represents your maximum jump length at that position.
	Goal: reach the last index in the minimum number of jumps.
	For example:
	Given array A = [2,3,1,1,4]
	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
You can assume that you can always reach the last index.

 * @author sonaggarwal
 *
 */
public class MinimumJumps {
	
	public int getMinJumps(int[] array) {
		int jumps[] = new int[array.length];
		for (int i =0 ; i<array.length; i++) {
			int indexJumps =0;
			int j = i;
			while (j<array.length-1) {
				if (array[j] == 0) {
					indexJumps = Integer.MAX_VALUE-i;
					break;
				}
				j += array[j];
				indexJumps++;
			}
			jumps[i] = i + indexJumps;
		}
		return minimum(jumps);
	}
	
	public int jump(int[] A) {
	    int sc = 0;
	    int e = 0;
	    int max = 0;
	    for(int i=0; i<A.length-1; i++) {
	        max = Math.max(max, i+A[i]);
	        if( i == e ) {
	            sc++;
	            e = max;
	        } 
	    }
	    return sc;
	}
	
	private int minimum(int[] jumps) {
		int minimum = jumps[0];
		for (int i=0; i<jumps.length-1;i++) {
			if (jumps[i]<minimum) {
				minimum = jumps[i];
			}
		}
		return minimum;
	}
	
public static void main(String args[]) {
		MinimumJumps mj = new MinimumJumps();
		int[] arr1 = {4,1,1,3,1,1,1};
		System.out.println(mj.jump(arr1));
		int[] arr2 = {2,3,0,1,4};
	//	System.out.println(mj.getMinJumps(arr2));

		
	}
}
