import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;


public class TwoSum {
	private Map<Integer, Integer> treeMap ;
	/** Initialize your data structure here. */
   
	public TwoSum() {
        treeMap = new TreeMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
         if(treeMap.containsKey(number)) {
        	 treeMap.put(number, treeMap.get(number)+1);
         } else treeMap.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : treeMap.keySet()) {
        	if (key > value/2) break;
        	int next = value - key;
        	if (next == key ) {
        		if( treeMap.get(key) > 1) return true;
        		else return false;
        	}
        	if( treeMap.containsKey(next)) return true;
        
        }
        return false;
    }
    
    
    @Test
    public void test() {
    	TwoSum obj = new TwoSum();
    	obj.add(0);
    	Assert.assertFalse(obj.find(0));
    }
}
