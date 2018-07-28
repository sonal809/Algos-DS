package strings;
/**
 * The basic concept is to first find a window which contains that pattern and then minimize that window 
 * for the next iteration by removing useless characters 
 * @author sonaggarwal
 *
 */
public class MinimumLengthWindowFromAPattern {

	public String getMinWindow(String s, String p) {
		  int[] hash_pat = new int[256];
		  int[] hash_str = new int[256];
		  
		  for (int i = 0 ; i < p.length(); i++) {
			  hash_pat[p.charAt(i)]++;
		  }
		  int count = 0;
		  int start = 0;
		  int min_len = Integer.MAX_VALUE;
		  int start_index = -1;
		  for (int i = 0 ; i < s.length() ; i++) {
			  hash_str[s.charAt(i)] ++;
			  
			  if ((hash_str[s.charAt(i)] <= hash_pat[s.charAt(i)]) && hash_pat[s.charAt(i)] > 0) {
				  count ++;
			  }
			  
			  if(count == p.length()) {
				  while( hash_pat[s.charAt(start)] == 0
						  || hash_str[s.charAt(start)] > hash_pat[s.charAt(start)]) {
					  if (hash_str[s.charAt(start)] > hash_pat[s.charAt(start)]) {
						  hash_str[s.charAt(start)]--;
						  start ++;
					  }
				  }
				  
				  int len = i - start +1;
				  if (min_len > len) {
					  min_len = len;
					  start_index = start;
				  }
			  }
		  }
		  if(start_index == -1) {
			  System.out.println("No such window exists");
	           return "";
	        }    
	        return s.substring(start_index, start_index + min_len);
		  }
	
	public static void main(String args[]) {
		MinimumLengthWindowFromAPattern mp = new MinimumLengthWindowFromAPattern();
		//System.out.println(mp.getMinWindow("aaabaaacdefg", "abc"));
		System.out.println(mp.getMinWindow("this is a test string", "tist"));

	}
}
