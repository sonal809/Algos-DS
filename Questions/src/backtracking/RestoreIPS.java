package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * Input: "25525511135"
	Output: ["255.255.11.135", "255.255.111.35"]
 * @author sonaggarwal
 *
 */
public class RestoreIPS {
    public List<String> restoreIpAddresses(String s) {
    	List<String> ips = new ArrayList<>();
    	if(s.length() < 4) return ips;
    	for (int a = 1; a <=3 ; a++) {
    		String A = s.substring(0, a);
			if (!isValid(A)) continue;
    		for (int b = 1; b<= 3; b++) {
    			if (a+b >= s.length()) continue;
    			String B = s.substring(a,a+b);
				if (!isValid(B)) continue;
    			for (int c = 1 ; c <=3 ; c++) {
    					if (a+b+c >= s.length() ) continue;
    					String C = s.substring(a+b,a+b+c);
    					if ((s.length() - (a+b+c+1) )+1 > 3) continue;
    					String D = s.substring(a+b+c, s.length());
    					if (isValid(C) && isValid(D) ) {
    						StringBuilder sb = new StringBuilder();
    						sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
    						ips.add(sb.toString());
    					}
    				}
    		}
    	}
    	return ips;

    }
    
    private boolean isValid(String s) {
    	int val = Integer.parseInt(s);
    	if (s.charAt(0) == '0' && s.length() > 1) return false; 
    	return val < 256 && val >= 0;
    }
    
	public List<String> restoreIpAddresses2(String s) {
    	List<String> ips = new ArrayList<>();
    	restoreIpHelper(ips, new StringBuilder(), s, 0, 4);
    	return ips;
    }
    
    public void restoreIpHelper(List<String> ips, StringBuilder sb, String s, int index, int count) {
    	if ( count == 1) {
    		int last = Integer.parseInt(s.substring(index, s.length()));
    		if (last < 256 && last >= 0) {
    			sb.append(last);
    			ips.add(sb.toString());
    		} else return;

    	}
    	for (int i = index+1; i < s.length(); i++) {
    		int ipComponent = Integer.parseInt(s.substring(index, i));
    		int length = i - index + 1;
    		if (ipComponent < 256 && ipComponent >= 0) {
    			sb.append(ipComponent+".");
    			restoreIpHelper(ips, sb, s, i, --count);
    			sb.replace(index,length, "");
    		}
    	}
    }
    
    @Test
    public void test1() {
    	List<String> ips = restoreIpAddresses("25525511135");
    	String[] result = {"255.255.11.135", "255.255.111.35"};
    	Assert.assertTrue(ips.contains(result[0]));
    	Assert.assertTrue(ips.contains(result[1]));

    }
    
    @Test
    public void test2() {
    	List<String> ips = restoreIpAddresses("0000");
    	Assert.assertTrue(ips.contains("0.0.0.0"));
    	
    }
    
    @Test
    public void test3() {
    	List<String> ips = restoreIpAddresses("010010");
    	System.out.println(Arrays.toString(ips.toArray()));

    }
    
    
}
