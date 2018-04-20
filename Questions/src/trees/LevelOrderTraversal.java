package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import pojos.TreeNode;
import util.TreeNodeUtil;

public class LevelOrderTraversal {
	
	public static List<List<TreeNode>> bfs(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<>();
		List<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		result.add(queue);
		while(!queue.isEmpty()) {
			List<TreeNode> levelNodes = new ArrayList<>();
			for (TreeNode node: queue) {
				if (node.left != null) levelNodes.add(node.left);
				if (node.right != null) levelNodes.add(node.right);				
			}
			if (!levelNodes.isEmpty()) {
				result.add(levelNodes);
			}
			queue = levelNodes;
		}
		return result;
	}
	
	public static List<List<TreeNode>> dfs(TreeNode node) {
		List<List<TreeNode>> result = new ArrayList<>();
		dfsHelper(node, result, 0);
		return result;
	}
	
	private static void dfsHelper(TreeNode node, List<List<TreeNode>> result, int level) {
		if(node != null) {
			List<TreeNode> levelNodes = new ArrayList<TreeNode>();
			if(result.size() > level) {
				levelNodes = result.get(level);				
			} else result.add(level, levelNodes);
			levelNodes.add(node);

			dfsHelper(node.left, result, level+1);
			dfsHelper(node.right, result, level+1);
		}
		
	}
	
	 static Set<String> validWords = new HashSet<>();
	    
	    class Value {
	        int freq;
	        List<Integer> sentences;
	        
	        Value(int freq, int sentenceNo) {
	            this.freq = freq;
	            if (sentences == null) {
	                sentences = new ArrayList();
	            }
	            sentences.add(sentenceNo);
	        }
	        
	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{").append(this.freq).append(":");
	            for(int i = 0; i< this.sentences.size()-1; i++) {
	                sb.append(this.sentences.get(i));
	                sb.append(",");
	            }
	            sb.append(this.sentences.get(this.sentences.size()-1));
	            sb.append("}");
	            return sb.toString();
	        }
	    }
	    /*
	     * Complete the function below.
	     */

	    private static void initializeDict() {
	        validWords.add("i.e.");
	    }
	    static void generateAndPrintConcordance(String[] inputLines) {
	        
	        
	        System.out.println(inputLines.length);
	        
	        int size = inputLines.length;
	        int sentenceNo = 1;
	        boolean endOfSentence = false;
	        Map<String, Value> map = new TreeMap<>(); 
	        for (String inputLine: inputLines) {
	            String[] words = inputLine.split("\\s+");
	            for (String word: words) {
	                if (endOfSentence) {
	                    sentenceNo += 1;
	                    endOfSentence = false;
	                }
	                if (!validWords.contains(word)) {
	                    if (word.endsWith(".")) {
	                        endOfSentence = true;
	                        word.substring(0, word.length()-1);
	                    }
	                    if(word.endsWith(",")) {
	                        word.substring(0, word.length() - 1);
	                    }
	                    if (map.get(word) != null) {
	                        Value val = map.get(word);
	                        val.freq += 1;
	                        val.sentences.add(sentenceNo);
	                    }
	                    else {
	                    	LevelOrderTraversal obj = new LevelOrderTraversal();
	                    	LevelOrderTraversal.Value val = obj.new Value(1, sentenceNo);
	                        map.put(word, val);
	                    }
	                }
	            }
	        }
	        for(String word : map.keySet()){
	        	word.toLowerCase();
	            System.out.println(word + ": "+ map.get(word));
	        }
	        
	    }
	    
	public static void main(String[] args) {
		TreeNode node = new TreeNode(50);
		TreeNodeUtil.insertBST(node, 30);
		TreeNodeUtil.insertBST(node, 80);
		TreeNodeUtil.insertBST(node, 20);
		TreeNodeUtil.insertBST(node, 35);
		TreeNodeUtil.insertBST(node, 60);
		TreeNodeUtil.insertBST(node, 90);
		TreeNodeUtil.insertBST(node, 15);
		
		List<List<TreeNode>> result =LevelOrderTraversal.dfs(node);
		for (List<TreeNode> levelNodes : result) {
			System.out.println(Arrays.toString(levelNodes.toArray()));
		}
		
		List<List<TreeNode>> resultbfs =LevelOrderTraversal.bfs(node);
		for (List<TreeNode> levelNodes : resultbfs) {
			System.out.println(Arrays.toString(levelNodes.toArray()));
		}
	}
}
