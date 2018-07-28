package strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> perms = new ArrayList<>();
        letterCasePermutation(S, new StringBuilder(), 0, perms);
        return perms;
    }
    
    public void letterCasePermutation(String S, StringBuilder sb , int start, List<String> perms) {
        if (start >= S.length()) {
        	perms.add(sb.toString());
        	return;
        }
        
        for (int i = start; i < S.length(); i++) {
        	if(Character.isLetter(S.charAt(i))) {
        		sb.append(Character.toUpperCase(S.charAt(i)));
        		letterCasePermutation(S, sb, i+1, perms);
        		sb.deleteCharAt(i);
        	} else sb.append(S.charAt(i));
        }
    }
    
    public static void main(String args[]) {
    	LetterCasePermutation lt = new LetterCasePermutation();
    	lt.letterCasePermutation("a1b1");
    }
}
