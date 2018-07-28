package matrix;

import java.util.Arrays;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


 Write an implementation for this method:
 https://docs.scipy.org/doc/numpy-1.14.0/reference/generated/numpy.eye.html


 k=-2

 0,0,0    100
 0,0,0    010
 1,0,0    001

 k=-1

 0,0,0
 1,0,0
 0,1,0

 k=0
 1,0,0
 0,1,0
 0,0,1

 k=1
 0,1,0
 0,0,1
 0,0,0

 k=2
 0,0,1
 0,0,0
 0,0,0

 */

class ShiftDiagonal {
	public int[][] makeDiaganalOnes(int n, int m, int k) {
		int[][] res = new int[n][m];
		int i = 0;
		int j = 0;
		if (k < 0) {
			i = Math.abs(k);
		} else
			j = k;

		while (i < n && i >= 0 && j >= 0 && j < m && Math.abs(k) < m) {
			res[i++][j++] = 1;
		}

		return res;
	}

	public static void main(String[] args) {
		ShiftDiagonal sol = new ShiftDiagonal();
		int[][] res = sol.makeDiaganalOnes(3, 3, 1);
		System.out.println(Arrays.deepToString(res));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(3, 3, -1)));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(3, 3, 0)));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(2, 3, 0)));

		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(0, 3, 0)));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(0, 0, 6)));

		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(3, 6, -8)));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(6, 3, -1)));
		System.out.println(Arrays.deepToString(sol.makeDiaganalOnes(6, 3, 1)));

	}
}
