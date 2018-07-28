package strings;


public class WildCardPatternMatch {
	
	public boolean isPatternMatch(String s, String pattern, int s_index, int p_index) {
		if (p_index == pattern.length()) {
			return true;
		}
		if(p_index > pattern.length() || s_index >= s.length()) {
			return false;
		}
		if (s.charAt(s_index) == pattern.charAt(p_index)) {
			return isPatternMatch(s, pattern, s_index+1, p_index+1);
		}
		if(pattern.charAt(p_index) == '?') {
			return isPatternMatch(s, pattern, s_index+1, p_index+1);
		}
		if(pattern.charAt(p_index) == '*') {
			return isPatternMatch(s, pattern, s_index, p_index+1) || //* is an empty string
					isPatternMatch(s, pattern, s_index+1, p_index);
		}
		return false;
	}
	
	public static void main(String args[]){
		WildCardPatternMatch wp = new WildCardPatternMatch();
		System.out.println(wp.isPatternMatch("abcde", "ab*f", 0, 0));
		System.out.println(wp.isPatternMatch("abcde", "ab*e", 0, 0));
		System.out.println(wp.isPatternMatch("abcdebc", "ab*e?f", 0, 0));
		System.out.println(wp.isPatternMatch("abcdebc", "ab*e?c", 0, 0));


	}
}
