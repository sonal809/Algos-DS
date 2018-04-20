package arrays;

public class IsSubsequence {
    
	public boolean isSubsequence(String s, String t) {
		
		int t_start = 0;
		int t_curr = 0;
		int s_start = 0;
		int s_curr = 0;
		while(t_curr < t.length()) {
			if(s.charAt(s_curr) == t.charAt(t_curr)) {
				s_curr++;
				t_curr++;
			}
			if (s.charAt(s_curr) != t.charAt(t_curr)) {
				
			}
		}
		return false;   
    }
}
