package code;

import java.util.HashMap;
import java.util.Map;

class Custom {
	public String val;
	Custom(String str) {
		this.val = str;
	}
	
	@Override
	public String toString() {
		return val;
	}
}
public class SkylineProblem {
//    public List<int[]> getSkyline(int[][] buildings) {
//       
//    }
	
	public static void main(String args[]) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("a", 10);
		hashMap.put("b", 20);
		System.out.println(hashMap.values());
		Integer val = hashMap.get("a");
		val = val+1;
		System.out.println(hashMap.values());
		val = new Integer(100);
		System.out.println(hashMap.values());
		
		Map<String, String> hashMap2 = new HashMap<>();
		hashMap2.put("a", "val1");
		hashMap2.put("b", "value2");
		System.out.println(hashMap2.values());
		String h2val2 = hashMap2.get("a");
		h2val2 = "changedVal";
		System.out.println(hashMap2.values());

		Map<String, Custom> map3 = new HashMap<>();
		map3.put("a", new Custom("cval1"));
		map3.put("b", new Custom("cval2"));
		System.out.println(map3.values());
		Custom c = map3.get("a");
		c.val = "changedValue";
		System.out.println(map3.values());
		c = new Custom("this wont be seen");
		System.out.println(map3.values());



	}
}
