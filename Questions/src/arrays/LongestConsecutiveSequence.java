package arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequence {
    
	public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		Integer[] boxedArray = IntStream.of(nums).boxed().toArray(Integer[]::new);
		Collections.addAll(numSet, boxedArray);
		int maxLength = 1;
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			int currLength = 1;
			if (numSet.contains(curr-1)) continue;
			while (numSet.contains(++curr)) {
				currLength += 1;
			}
			if (currLength > maxLength) {
				maxLength = currLength;
			}
		}
		return maxLength;
		
		

    }
	
	@Test
	public void test() {
		LongestConsecutiveSequence ls = new LongestConsecutiveSequence();
		int[] nums = {100, 4, 200, 1, 3, 2};
		Assert.assertEquals(4, ls.longestConsecutive(nums));
	}
}
