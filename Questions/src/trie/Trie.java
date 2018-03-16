package trie;

import java.util.HashMap;

public class Trie {
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String s) {
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
		boolean isPresent = false;
		TrieNode t = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(t.children.containsKey(c)) {
				t = t.children.get(c);
			}
			if(i == word.length() - 1 && t.endOfWord == true) {
				isPresent = true;
			}
		}
		return isPresent;
	}
	
	public void printTrieStrings() {
		printTrieStringsHelper(new StringBuilder(), root);
	}
	
	private void printTrieStringsHelper(StringBuilder sb, TrieNode node) {
		if(node.endOfWord) {
			System.out.println(sb.toString());
		}
		for(char i : node.children.keySet()) {
			StringBuilder child = new StringBuilder(sb.toString());
			child.append(i);
			printTrieStringsHelper(child, node.children.get(i));
		}
	}
	public static void main(String args[]) {
		Trie t = new Trie();
		t.insert("sonal");
		t.insert("sinchan");
		t.insert("sona");
		t.insert("xyzxyz");
		t.insert("xyz");
		t.insert("sin");
		
		t.printTrieStrings();
		System.out.println("Search String -> hello "+ t.search("hello"));
		System.out.println("Search String -> xyzx "+ t.search("xyzx"));
		System.out.println("Search String -> xyz "+ t.search("xyz"));

		
		
	}
}
