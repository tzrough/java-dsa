package com.tzrough.ds;

import org.junit.Test;

import com.tzrough.ds.heap.MaxHeap;

public class HeapTest
{
	@Test
	public void test1() 
	{
		Integer[] data = {6,7,2,3,9,5,4};
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(data);
		
		maxHeap.add(1);
		
		maxHeap.print();
	}
	
	@Test
	public void test2() 
	{
		Integer[] data = {6,7,2,3,9,5,4};
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(data);
		
		maxHeap.sort();
		
		maxHeap.print();
	}

}
