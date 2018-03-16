package heaps.tests;

import java.util.Arrays;

import heaps.Heap;

import org.junit.Test;

public class HeapTest {
	Heap heap = new Heap();
	
	@Test
	public void testMaxHeap() {
		int[] nums = {5,7,6,1,2,9};
		heap.buildMaxHeap(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	@Test
	public void testMaxHeap2() {
		int[] nums = {5,7,6,1,2};
		heap.buildMaxHeap(nums);
		System.out.println(Arrays.toString(nums));
	}
	
}
