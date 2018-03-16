package code;
import org.junit.Assert; 

public class Anagrams {
	private int noOfChars = 256;
	public boolean areAnagrams(String str1, String str2) {
		int[] count1 = new int[noOfChars];
		int[] count2 = new int[noOfChars];
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		for (int i=0; i<str1.length();i++) {
			count1[str1.charAt(i)]++;
 			count2[str2.charAt(i)]++;
		}
		
		for (int i =0; i< count1.length; i++){
			if (count1[i] != count2[i]){
				return false;
			}
				
		}
		return true;
	}
	


	public static void main(String args[]) {
		Anagrams obj = new Anagrams();
		Assert.assertTrue(obj.areAnagrams("triangle","integral"));
		Assert.assertFalse(obj.areAnagrams("abd", "ab"));
		
	}
}