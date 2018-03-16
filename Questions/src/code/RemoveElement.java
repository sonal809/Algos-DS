package code;
import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 * @author sonaggarwal
 *
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int first = 0;
        int last = nums.length - 1;
        while(first <= last) {
            if (nums[first] == val) {
                while(nums[last] == val && last > 0) {
                    last -= 1;
                }
                if (last < first || last == 0) return first--;
                int temp = nums[last];
                nums[last] = nums[first];
                nums[first] = temp;
            }
            first++;
        }
        return first;
    }
    
    public static void main(String[] args) {
    	RemoveElement re = new RemoveElement();
    	int[] arr = {3,2,2,3};
    	System.out.println(re.removeElement(arr, 3));
    	System.out.println(Arrays.toString(arr));
    	int[] arr2 = {2,2,2,3,3};
    	System.out.println(re.removeElement(arr2, 3));
    	System.out.println(Arrays.toString(arr2));
    	int[] arr3 = {1};
    	System.out.println(re.removeElement(arr3, 1));
    	System.out.println(Arrays.toString(arr3));


    }
}
