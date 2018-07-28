package strings;

public class IsSubsequence {
	
	   static boolean isSubSequence(String str1, String str2)
	    {
	        int j = 0;
	        int m = str1.length();
	        int n = str2.length();
	        // Traverse str2 and str1, and compare current character 
	        // of str2 with first unmatched char of str1, if matched 
	        // then move ahead in str1
	        for (int i=0; i<n&&j<m; i++)
	            if (str1.charAt(j) == str2.charAt(i))
	                j++;
	 
	        // If all characters of str1 were found in str2
	        return (j==m); 
	    }
	   
	   public static void main(String args[]) {
		   System.out.println(isSubSequence("abc", "abdfosahbjkc"));
	   }
}
