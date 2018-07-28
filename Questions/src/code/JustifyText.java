package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifyText {
	private String justifyText(List<String> words, int maxWidth, int wordCount, int count, boolean lastLine) {
		int spaceCount = wordCount-1;
		StringBuilder sb = new StringBuilder();
		if (wordCount == 1) {
			//left justified.
			sb.append(words.get(0));
			while(sb.length() < maxWidth) sb.append(" ");
			return sb.toString();
		}
		if(lastLine) {
			for (String word: words) {
				sb.append(word).append(" ");
			}
			while(sb.length() < maxWidth) {
				sb.append(" ");
			}
			if (sb.length() > maxWidth) {
				sb.setLength(maxWidth);
			}
			return sb.toString();
		}
		int avgSpaceWidth = (maxWidth-count)/spaceCount;
		int totalLength = avgSpaceWidth * spaceCount + count;
		int noOfSpacesLeft = maxWidth - totalLength;
		

		StringBuilder spaceStringBuilder = new StringBuilder();
		for (int i = 0; i< avgSpaceWidth; i++) {
			spaceStringBuilder.append(" ");
		}
		String spaceString = spaceStringBuilder.toString();
		for (int i = 0; i < words.size()-1; i++) {
			sb.append(words.get(i)).append(spaceString);
			if (noOfSpacesLeft > 0) {
				sb.append(" "); noOfSpacesLeft -= 1;
			}
		}

		sb.append(words.get(words.size()-1));
		return sb.toString();
	}
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> fragment = new ArrayList<>();
        int count = 0;
        int wordCount = 0;
        for (String word : words) {
        	if (count + word.length()+wordCount > maxWidth) {
        		String justifiedText = justifyText(fragment, maxWidth, wordCount, count, false);
        		result.add(justifiedText);
        		fragment = new ArrayList<>();
        		wordCount = 0;
        		count = 0;
        	}
    		fragment.add(word);
    		wordCount += 1;
    		count += word.length();
        	
        }
		String lastFragment = justifyText(fragment, maxWidth, wordCount, count, true);
		result.add(lastFragment);
        return result;
    }
    
    public static void main(String args[]) {
    	JustifyText jt = new JustifyText();
    	String[] words = {"What","must","be","acknowledgment","shall","be"};
    //	System.out.println(Arrays.toString(jt.fullJustify(words, 16).toArray()));
    	String[] words2 = {"Science","is","what","we","understand","well","enough","to","explain",
    	         "to","a","computer.","Art","is","everything","else","we","do"};
    	System.out.println(Arrays.toString(jt.fullJustify(words2, 20).toArray()));
    	String[] words3 = {"This", "is", "an", "example", "of", "text", "justification."};
    	System.out.println(Arrays.toString(jt.fullJustify(words3, 16).toArray()));


    }
}
