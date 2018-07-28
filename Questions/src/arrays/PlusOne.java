package arrays;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int sum = digits[digits.length-1] + 1;
        int[] dest = new int[digits.length];
        System.arraycopy( digits, 0, dest, 0, digits.length );

        if (sum < 10) {
            dest[dest.length - 1] = sum;
            return dest;
        } else {
        	int carry = 1;
        	
        	for (int i = digits.length-1; i >= 0; i--) {
        		if (carry == 0) return dest;
        		sum = digits[i]+carry;
        		dest[i] = sum % 10;
        		carry = sum / 10;
        	}
        	if (dest[0] == 0) {
        		int[] newDes = new int[dest.length+1];
                System.arraycopy( dest, 0, newDes, 0, dest.length );
                newDes[0] = 1;
                return newDes;

        	}
        }

        return dest;
    }
    
    public static void main(String args[]) {
    	PlusOne ps1 = new PlusOne();
    	int[] arr = {9,9,9};
    	System.out.println(Arrays.toString(ps1.plusOne(arr)));
    }
}
