package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {
	
	public static char[] reverseWords(char[] arr) {
		List<String> wordList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			StringBuilder word = new StringBuilder();
			while (i < arr.length && arr[i] != ' ') {
				word.append(arr[i]);
				i++;
			}
			wordList.add(word.toString());
			if (i < arr.length && arr[i] == ' ') {
				wordList.add(" ");
			}
		}
		int index = 0;
		char[] result = new char[arr.length];
		for (int j = wordList.size() - 1; j >= 0; j--) {
			String a = wordList.get(j);
			for (int i = 0; i < a.length(); i++) {
				result[index++] = a.charAt(i);
			}
		}
		return result;
	}
	
	public static char[] reverseWords2(char[] arr) {
		char[] result = arr.clone();
		int j = 0;
		for(int i=0; i< arr.length; i++) {
			if(arr[i] == ' ' || i == arr.length -1) {
				int end = i== arr.length-1? i : i-1;
				reverse(result, j, end);				
				j = i+1;
			}
		}
		reverse(result, 0, result.length-1);
		return result;
	}
	
	private static void reverse(char[] arr, int start, int end) {
		while(start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		char[] array = {'h','i',' ', 'w','o','r','l','d'};
		System.out.println(Arrays.toString(ReverseWords.reverseWords(array)));
		char[] array2 = {'o','n','e', ' ', 't','w','o',' ','t','h','r','e','e'};
		System.out.println(Arrays.toString(ReverseWords.reverseWords(array2)));
		
		
		System.out.println(Arrays.toString(ReverseWords.reverseWords2(array2)));


	}
		}

