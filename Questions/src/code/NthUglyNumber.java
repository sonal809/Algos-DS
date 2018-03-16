package code;

/**
 * 
 * https://leetcode.com/problems/ugly-number-ii/description/
 * @author sonaggarwal
 *
 */
public class NthUglyNumber {
	public static boolean isUgly(int n) {
		int[] factors = {2,3,5};
		int i = 0;
		if(n == 1) {
			return true;
		}
		while(i < 3 || n > factors[i]) {
			System.out.println("Value of n "+ n+" i "+ i);
			if(n == 1) {
				return true;
			}
			if (n % factors[i] > 0) {
				i++;
			}
			n = n / factors[i];
		}
		return false;
	}
	
	public static int nthUglyNumber(int n) {
		int i = 0; int j =0; int k =0;
		int count = 1;
		int[] ug = new int[n];
		ug[0] = 1;
 	 	while(count < n) {
 	 		int num_i = 2*ug[i];
 	 		int num_j = 3*ug[j];
 	 		int num_k = 5*ug[k];
 	 		ug[count] = Math.min(Math.min(num_i, num_j), num_k);
 	 		if(ug[count] == num_i) {
 	 			i++;
 	 		}
 	 		if(ug[count] == num_j) {
 	 			j++;
 	 		}
 	 		if(ug[count] == num_k) {
 	 			k++;
 	 		}
 	 		count++;
 	 	}
		return ug[count-1];
	}
	
	public static void main(String args[]) {
		//System.out.println(NthUglyNumber.nthUglyNumber(10));
		System.out.println(NthUglyNumber.isUgly(14));
	}
}
