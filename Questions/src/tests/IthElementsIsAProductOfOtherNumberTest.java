package tests;

import org.junit.Assert;
import org.junit.Test;

import code.IthElementIsAProductOfOtherNumbers;

public class IthElementsIsAProductOfOtherNumberTest {
	
	@Test
	public void test() {
		int[] nums = {2,3,4,5,6};
		int[] result = createResultArray(nums);
		Assert.assertArrayEquals(result, IthElementIsAProductOfOtherNumbers.solution(nums));
	}
	
	private int[] createResultArray(int[] nums) {
		int[] result = new int[nums.length];
		int product = 1;
		for (int i=0; i<nums.length; i++) {
			product *= nums[i];
		}
		for (int i=0; i<nums.length; i++) {
			result[i] = product/nums[i];
		}
		return result;
	}
}
