package code;


public class CompressedStringIterator {
	String compressedStr ;
	int last;
	int count;
	
	CompressedStringIterator(String s) {
		compressedStr = s;
		count = getInitialCount();
	}
	
	public boolean hasNext() {
		if (last < compressedStr.length() || count > 0) {
			return true;
		}
		return false;
	}

	public char next() {
		char result = '-';
		if (hasNext()) {
			if (count == 0) {
				last = last+1;
				while(last < compressedStr.length() && Character.isDigit(compressedStr.charAt(last))) {
					count = count*10 + (compressedStr.charAt(last) - '0');
					last++;
				}
			}
			result = compressedStr.charAt(last);
			count--;
		}
		
		return result;		
	}
	
	private int getInitialCount() {
		int count = 0;
		int i = 1;
		while ( i< compressedStr.length() && Character.isDigit(compressedStr.charAt(i))) {
			count = count*10 + (compressedStr.charAt(i) - '0');
			i++;
		}
		return count;
	}

	public static void main(String args[]) {
		CompressedStringIterator iterator = new CompressedStringIterator("a5b4");
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());



		
	}


}
