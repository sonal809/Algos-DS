package Interviews;

import java.util.Arrays;
/**
 * Find maximum sum subsequence in an array without skipping more than 1 number.
 * @author sonaggarwal
 *
 */
public class MaximumSum {
	static int maximizeRatings(int[] ratings) {
        int[] res = new int[ratings.length+2];
       // res[0] = ratings[0];
       // res[1] = Math.max(res[0] + ratings[1], Math.max(ratings[0], ratings[1]));

        for (int i = ratings.length-1; i >=0; i--) {
            res[i] = Math.max(res[i+1], res[i+2]) + ratings[i];
        }
        
        return Math.max(res[0], res[1]);
    }
	
	static int maximizeRatings2(int[] ratings) {
		int[] res = new int[ratings.length];
		res[0] = ratings[0];
		res[1] = Math.max(ratings[0]+ratings[1], ratings[1]);
		for(int i = 2 ; i < ratings.length; i++) {
			res[i] = Math.max(res[i-1], res[i-2])+ratings[i];
		}
		System.out.println(Arrays.toString(res));
		return Math.max(res[ratings.length-1], res[ratings.length-2]);
	}
	
	public static void main(String args[]) {
		//MaximumSum sum = new MaximumSum();
		int[] arr = {9,-1, -3,4,5};
		int[] arr2 = {-1,-2,-3,-4, -5};
		System.out.println(MaximumSum.maximizeRatings2(arr));
		System.out.println(MaximumSum.maximizeRatings2(arr2));

	}
}
