package dp;

import org.junit.Assert;
import org.junit.Test;

public class SplittingSentences {
	
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i< sentence.length; i++) {
    		sb.append(sentence[i]);
    		if(i != sentence.length-1) sb.append(" ");
    	}
    	
    	String str = sb.toString();
    	int strCount = str.length();
    	int count = 0;
    	int charCount = 0;
    	int wordIndex = 0;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (str.charAt(charCount) == ' ' || charCount == 0) {
    				int nextWordLength = j+sentence[wordIndex++].length() + 1; //including space
    				if(j == 0 || charCount == 0) --nextWordLength; //if the first word
    				if(j == 0 && charCount != 0)  {
    					++charCount;
    				}
    				
        			if (nextWordLength > cols) {
        				wordIndex--; //reset wordIndex if the following word cannot fit in the leftover columns
        				break;
        			}
    			}
    			//if sentenceFitted 
    			if (charCount == strCount-1) {
    				charCount = 0;
    				count += 1;
    				wordIndex = 0;
    				j++;
    			} else charCount++;

    			
    		}
    	}
    	
    	return count;
    }
    
    @Test
    public void test() {
    	SplittingSentences ss = new SplittingSentences();
    	String[] sentence = {"I", "had", "apple", "pie"};
    	Assert.assertEquals(1, ss.wordsTyping(sentence, 4, 5));
    }
    
    @Test
    public void test2() {
    	SplittingSentences ss = new SplittingSentences();
    	String[] sentence = {"a", "bcd", "e"};
    	Assert.assertEquals(2, ss.wordsTyping(sentence, 3, 6));
    }
    
    @Test
    public void test3() {
    	SplittingSentences ss = new SplittingSentences();
    	String[] sentence = {"hello", "world"};
    	Assert.assertEquals(1, ss.wordsTyping(sentence, 2, 8));
    }
    
    @Test
    public void test4() {
    	SplittingSentences ss = new SplittingSentences();
    	String[] sentence = {"f","p","a"};
    	Assert.assertEquals(10, ss.wordsTyping(sentence, 8, 7));
    	
    }
}
