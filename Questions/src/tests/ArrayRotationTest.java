package tests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import code.ArrayRotation;

public class ArrayRotationTest {
	ArrayRotation obj = new ArrayRotation();
	
	@Test
	public void test1() {
		int[] nums = {2, 3, -4, -1, 6, -9};
		obj.arrayRotate(nums);
		int[] expected = {-9,6 -4 ,3,-1,2};
		printArray(nums);
		Assert.assertTrue(Arrays.equals(expected, nums));
		
	}
	
	private void printArray(int[] nums) {
		for(int n : nums) {
			System.out.print(n +" ");
		}
	}
}
