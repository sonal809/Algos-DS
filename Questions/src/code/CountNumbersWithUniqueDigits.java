package code;

/**
 * given c find all x such that 0<=x<10^n and x has all unique digits.
 * Find the count of all x.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 * @author sonaggarwal
 *
 */
public class CountNumbersWithUniqueDigits {
	public int solution(int n) {
		if (n == 0) return 1;
		int result = 10;
		for (int i= 2; i<=n; i++) {
			int options = 9;
			int combinations = 9;
			for (int j = i; options >= 1 && j>1; j--) {
				combinations *= options;
				options -= 1;
			}
			result += combinations;
		}
		return result;
		
	}
	
	public int solutionDP(int n) {
		if (n==0) return 1;
		int[] dp = new int[n];
		dp[0] = 10;
		if (n==1) return dp[0];
		dp[1] = 81;
		int digit = 8;
		for (int i = 2; i< n; i++) {
			if (digit == 0) {
				dp[i] = 0;
			} else {
				dp[i] = dp[i-1] * digit;
				digit--;				
			}
		}
		int result = 0;
		for (int i=0; i< n; i++) {
			result +=dp[i];
		}
		return result;
	}
	
	public static void main(String args[]) {
		CountNumbersWithUniqueDigits obj = new CountNumbersWithUniqueDigits();
		System.out.println(obj.solution(2));
		System.out.println(obj.solution(3));
		System.out.println(obj.solution(4));

		System.out.println(obj.solutionDP(4));

	}
	
}
