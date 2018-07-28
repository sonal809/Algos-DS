package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Subsets {
	
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0 ; i <= nums.length ; i++) {
			result.addAll(createSubsetsOfLength(nums, i));
		}
		return result;
    }	
	public List<List<Integer>> createSubsetsOfLength(int[] array, int length) {
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> curr = new HashSet<>();
		createSubsetsHelper(array, result, curr, length, 0);
		return result;
	}
	
	private void createSubsetsHelper(int[] array,List<List<Integer>> result, Set<Integer> curr, int length, int start) {
		if (curr.size() == length) {
			result.add(new ArrayList<>(curr));
			return;
		}
		for (int i = start ; i < array.length; ++i) {
			curr.add(array[i]);
			createSubsetsHelper(array, result, curr, length, i+1);
			curr.remove(array[i]);
		}
	}
	
	@Test
	public void test1() {
		Subsets s1 = new Subsets();
		int[] array = {1,2,3};
		System.out.println(Arrays.deepToString(s1.createSubsetsOfLength(array, 2).toArray()));
		System.out.println(Arrays.deepToString(s1.subsets(array).toArray()));

	}
}
