package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.programcreek.com/2012/12/leetcode-word-ladder/ BFS to find the
 * shortest path from start word to end word
 * 
 * @author sonaggarwal
 *
 */
class QNode {
	String word;
	int len;

	QNode(String word) {
		this.word = word;
		this.len = 1;
	}

	QNode(String word, int len) {
		this.word = word;
		this.len = len;
	}
}

public class WordLadder {

	public int minimumTransformations(String startWord, String endWord, Set<String> dict) {
		int res = 0;
		Queue<QNode> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(new QNode(startWord));
		visited.add(startWord);
		if (!dict.contains(endWord))
			return res;
		while (!queue.isEmpty()) {
			QNode curr = queue.poll();
			System.out.println(curr.word);
			if (curr != null) {
				if (curr.word.equals(endWord)) {
					return curr.len;
				} else {
					for (int i = 0; i < curr.word.toCharArray().length; i++) {
						char[] charArray = curr.word.toCharArray();
						for (char c = 'a'; c < 'z'; c++) {
							char originalChar = charArray[i];
							charArray[i] = c;
							String newWord = new String(charArray);
							if (dict.contains(newWord) && !visited.contains(newWord)) {
								queue.add(new QNode(newWord, curr.len + 1));
								visited.add(newWord);
							}
							charArray[i] = originalChar;
						}
					}
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		WordLadder wl = new WordLadder();
		Set<String> dict = new HashSet<>(Arrays.asList("hot", "dot", "dog",
				"lot", "log"));
		System.out.println(wl.minimumTransformations("hit", "cog", dict));
	}
}
