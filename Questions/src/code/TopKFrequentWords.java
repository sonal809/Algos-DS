package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Word implements Comparable<Word>{
	String word;
	
	int count;

	@Override
	public int compareTo(Word o) {
		if (this.count == o.count) {
			return o.word.compareTo(this.word);
		}
		else return this.count - o.count;
	}
	
	Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
}
//Create a minheap of k items.
public class TopKFrequentWords {
	
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Word> minHeap = new PriorityQueue<>(k);
        for (String word: words) {
        	int count = 1;
        	if(map.containsKey(word)) {
        		count = map.get(word) +1; 
        	}
        	map.put(word, count);
        }
        
        for (String word : map.keySet()) {
    		minHeap.add(new Word(word, map.get(word)));
        	if (minHeap.size() > k) {
        		minHeap.poll();
        	} 
        	
        }
        
        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
        	result.add(minHeap.poll().word);
        }
        Collections.reverse(result);
        return result;
        
    }
    
    public static void main(String args[]) {
    	String[] words1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    	String[] words2 = {"i", "love", "leetcode", "i", "love", "coding"};
    	String[] words3 = {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
    	TopKFrequentWords sol = new TopKFrequentWords();
    	System.out.println(Arrays.toString(sol.topKFrequent(words1, 4).toArray()));
    	System.out.println(Arrays.toString(sol.topKFrequent(words2, 1).toArray()));
    	System.out.println(Arrays.toString(sol.topKFrequent(words3, 14).toArray()));


    }
}
