package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateFiles {
  
	public List<List<String>> findDuplicate(String[] paths) {
     Map<String, List<String>> map = new HashMap<>();
		for (String filePath : paths) {
        	String[] chunks = filePath.split("\\s+");
        	for (int i = 1; i< chunks.length; i++) {
        		String fileContent = chunks[i].substring(chunks[1].indexOf("(")+1,chunks[i].indexOf(")"));
        		List<String> filePaths = new ArrayList<>();
        		if(map.containsKey(fileContent)) {
        			filePaths = map.get(fileContent);
        		}
        		String fileName = chunks[i].substring(0, chunks[i].indexOf("("));
        		filePaths.add(new StringBuilder().append(chunks[0]).append("/").append(fileName).toString());
        		map.put(fileContent, filePaths);
        		
        	}
        }
		
		List<List<String>> result = new ArrayList<>();
		for (String fileContent : map.keySet()) {
			if(map.get(fileContent).size() > 1)
			result.add(map.get(fileContent));
		}
		
		return result;
    }
	
	public static void main(String args[]){
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		DuplicateFiles df = new DuplicateFiles();
		System.out.println(Arrays.deepToString(df.findDuplicate(paths).toArray()));
	}
}
