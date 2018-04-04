package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
	List<String> result = new ArrayList<String>();
	List<String> [] words = new ArrayList[s.length()+1];
	words[0] = new ArrayList<>();
	for (int i = 0 ; i < s.length(); i++) {
		if(words[i] != null) {
			for (int j = i + 1; j <= s.length(); j++) {
				String s_j = s.substring(i, j);
				if(!wordDict.contains(s_j)) {
					continue;
				}
				if (words[j] == null) {
					words[j] = new ArrayList<>();
				}
				if(!words[j].contains(s_j)) {
					words[j].add(s_j);
				}
			}
		}
		
	}
	if (words[s.length()] != null) {	
		dfs(words, result, "", s.length());
	}
	return result;		
	}
	
	private void dfs(List<String> [] words, List<String> result, String curr, int i) {
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	    if(words[i] == null) {
	    	return;
	    }
	    for(String s: words[i]){
	        String combined = s + " "+ curr;
	        dfs(words, result, combined, i-s.length());
	    }
	}


	public static void main(String args[]) {
		WordBreak wb = new WordBreak();
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog", "at"));
		wb.wordBreak(s, wordDict);
		
	}
}
