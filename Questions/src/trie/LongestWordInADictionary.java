package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * answer = apple
 * Longest word that can be made from other words in the dictionary one character at a time.
 * @author sonaggarwal
 *
 */
class Node {
	char c;
	Map<Character, Node> children;
	boolean isEnd;
	int index;
	Node() {
		children = new HashMap<>();
	}
	Node(char ch) {
		this();
		c = ch;
	}
	
	
}
public class LongestWordInADictionary {
	private void insert(String word, Node root, int index) {
		Map<Character, Node> children = root.children;
		for (Character ch : word.toCharArray()) {
			if (!children.containsKey(ch)) {
				children.put(ch, new Node(ch));
			} 
			root = children.get(ch);
			children = root.children;
		}
		root.isEnd = true;
		root.index = index;
	}
	public String longestWord(String[] words) {
		Node trie = new Node();
		int i = 0;
		for (String word: words) {
			insert(word, trie, i++);
		}
		//Now find the longest word in the trie where each node has isEnd is true.
		return dfs(trie, words);

	}
	
	private String dfs(Node root, String[] words) {

		String res = "";	
		if(root.isEnd == true) res =  words[root.index];
			
			if (root.isEnd == true || root.c == 0){
				for (Node child : root.children.values()) {
					String temp = dfs(child, words);
					if (temp.length() > res.length() || temp.length() == res.length() && temp.compareTo(res) < 0) {
						res = temp;
					}
				}
			} 
			return res;
	}
	
	public static void main(String args[]) {
		LongestWordInADictionary ld = new LongestWordInADictionary();
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(ld.longestWord(words));
		String[] words2 = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
		System.out.println(ld.longestWord(words2));
		String[] words3 = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd","otif"};
		System.out.println(ld.longestWord(words3));

		//"eyjuo"
		//eyjuoi

	}
}
