package trie;

import java.util.HashMap;

public class WordDictionary {

    TrieNode root = new TrieNode();
    
    public void addWord(String s) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			children = t.children;

			if (i == s.length() - 1) {
				t.endOfWord = true;
			}
		}

	}	
    
    public boolean search(String word) {
    	return search(word, root);
    }
	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    private boolean search(String word, TrieNode node) {
    	int i = 0;
		for(i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (Character key : node.children.keySet()) {
					if (search(word.substring(i+1), node.children.get(key))) {
						return true;
					}
				}
			}
			if(node.children.containsKey(c)) {
				node = node.children.get(c);
			} else return false;
		}
		if(i == word.length() && node.endOfWord == true) {
			return true;
		}
		return false;
    }
    
    public static void main(String args[]) {
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("mad");
    	wd.addWord("bad");
    	wd.addWord("dad");
    	System.out.println(wd.search(".ad"));
    	System.out.println(wd.search(".fad"));
    	System.out.println(wd.search("..d"));
    	System.out.println(wd.search("d.d"));
    	System.out.println(wd.search("d.m"));




    }
    
}
