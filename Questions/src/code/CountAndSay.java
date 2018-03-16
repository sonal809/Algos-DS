package code;

public class CountAndSay {
	
	public String createCountAndSayNextStrng(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		int len = str.length();
		for (int i = 0; i< str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				count++;
			} else {
				sb.append(count).append(str.charAt(i));
				count = 1;
			}
		}
		sb.append(count).append(str.charAt(len-1));
		return sb.toString();
	}
	
	public String countAndSay(int n) {
		String start = "1";
		String next = "1";
		for (int i=1; i< n; i++) {
			next = createCountAndSayNextStrng(start);
			start = next;
		}
		return next;
	}
	public static void main(String[] args) {
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.createCountAndSayNextStrng("121"));
		System.out.println(obj.countAndSay(3));
		System.out.println(obj.countAndSay(4));
		System.out.println(obj.countAndSay(5));
		System.out.println(obj.countAndSay(6));
		System.out.println(obj.countAndSay(7));
		System.out.println(obj.countAndSay(8));
		System.out.println(obj.countAndSay(9));
		System.out.println(obj.countAndSay(10));
		System.out.println(obj.countAndSay(11));

	}
}
