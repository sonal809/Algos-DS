package Interviews;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * Problem:

You’re given an input file. Each line consists of a timestamp (unix epoch in seconds) and 
a url separated by ‘|’ (pipe operator). The entries are not in any chronological order. 
Your task is to produce a daily summarized report on url hit count, organized daily (use GMT) 
with the earliest date appearing first. For each day, you should display the number of times 
each url is visited in the order of highest hit count to lowest count. Your program should take in 
one command line argument: input file name. The output should be printed to stdout. 
You can assume that the cardinality (i.e. number of distinct values) of hit count values 
and the number of days are much smaller than the number of unique URLs. You may also assume 
that number of unique URLs can fit in memory, but not necessarily the entire file.
 * @author sonaggarwal
 * 1407564301|www.nba.com
1407478021|www.facebook.com
1407478022|www.facebook.com
1407481200|news.ycombinator.com
1407478028|www.google.com
1407564301|sports.yahoo.com
1407564300|www.cnn.com
1407564300|www.nba.com
1407564300|www.nba.com
1407564301|sports.yahoo.com
1407478022|www.google.com
1407648022|www.twitter.com
 *
 */
class CustomDate implements Comparable<CustomDate>{
	int year;
	int day;
	int month;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append(this.month).append("/").append(this.day).append("/").append(this.year).append(" GMT").toString();		
	}
	
	@Override
	public boolean equals(Object d) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.year, this.day, this.month);
	}
	
	CustomDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.month = cal.get(Calendar.MONTH);
		this.year = cal.get(Calendar.YEAR);
	}

	@Override
	public int compareTo(CustomDate o) {
		if (this.year != o.year) return this.year - o.year;
		if (this.month != o.month) return this.month - o.month;
		return this.day - o.day;
	}
	
}
class ValueComparator implements Comparator<String>{
	 
	Map<String, Integer> map = new HashMap<String, Integer>();
 
	public ValueComparator(Map<String, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(String s1, String s2) {
		return map.get(s2).compareTo(map.get(s1));	
	}
}
public class Nyansa {
	
	public List<String> getLinesFromFile(String path) throws IOException {
		List<String> lines = new ArrayList<>();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(path);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        lines.add(line);
		    }
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return lines;
	}
	
	public void printHitCount(List<String> urls) {
		Map<CustomDate, Map<String, Integer>> urlDateCountMap = new TreeMap<>();
		for (String line: urls) {
			String[] urlLine = line.split("\\|");
			//System.out.println("1st entry "+urlLine[0]+ Arrays.toString(urlLine));
			long unixTime = Long.parseLong(urlLine[0].trim());
			String url = urlLine[1];
			Date date = new Date(unixTime*1000L);
			CustomDate customDate = new CustomDate(date);
			if(urlDateCountMap.containsKey(customDate)) {
				Map<String, Integer> urlCountMap = urlDateCountMap.get(customDate);
				int count = 1;
				if (urlCountMap.containsKey(url)) {
					count = urlCountMap.get(url) + 1;
				} urlCountMap.put(url, count);
				
			} else {
				Map<String, Integer> urlCountMap = new HashMap<>();
				urlCountMap.put(url, 1);
				urlDateCountMap.put(customDate, urlCountMap);
			}
			
		}
		//printing
		for (CustomDate date : urlDateCountMap.keySet()) {
			System.out.println(date);
			Map<String, Integer> sortedByCountMap = createSortedMap(urlDateCountMap.get(date));
			if (sortedByCountMap == null) continue;
			for (String url : sortedByCountMap.keySet()) {
				System.out.print(" ");
				System.out.print(url);
				System.out.print(" ");
				System.out.print(urlDateCountMap.get(date).get(url));
				System.out.println();
			}
		}
		
	}
	
	private Map<String, Integer> createSortedMap(Map<String, Integer> unsortedMap) {
		if (unsortedMap == null) return null;
		Comparator<String> comparator = new ValueComparator(unsortedMap);
		
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(unsortedMap);
		return result;
	}
	
	public static void main(String args[]) {
		Nyansa obj = new Nyansa();
		List<String> lines;
		try {
			lines = obj.getLinesFromFile("/Users/sonaggarwal/workspace/Practice/Questions/src/Interviews/urls");
			System.out.println(Arrays.toString(lines.toArray()));
			obj.printHitCount(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
