package com.tzrough.ds.heap;

public abstract class Heap<T extends Comparable<T>>
{
	T[] data;
	int heapSize;
	
	public Heap(T[] data)
	{
		this.data = data;
		this.heapSize = data.length;
		build(heapSize);
	}
	
	public int parent(int i) 
	{
		if(i == 0)
			return -1;
		else
			return (i - 1) / 2;
	}

	
	public int leftChild(int i) 
	{
		return (i + 1) * 2 - 1;
	}

	
	public int rightChild(int i) 
	{
		return (i + 1) * 2;
	}
	
	
	/**
	 * @param data 	存入堆的数据
	 * @param    i  堆中需要调整位置的元素下标
	 */
	public abstract void heapify(T[] data, int heapsize, int i);
	
	public void build(int heapSize) 
	{
		int lastParentIndex = parent(heapSize - 1);
		
		// 从最后一个有孩子的父节点开始
		// 从右到左， 从下到上， 逐个调整位置
		for(int i = lastParentIndex; i >= 0; i--)
		{
			heapify(data, heapSize, i);
		}
	}
	
	public T[] sort() 
	{
		int lastIndex = heapSize - 1;
		
		while (lastIndex > 0)
		{
			swap(0, lastIndex);
			build(lastIndex--);
		}
		
		if (data[0].compareTo(data[1]) > 0)
			swap(0, 1);
		
		return data;
	}
	
	
	public void swap(int index1, int index2) 
	{
		T temp = data[index1];
		
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	
	@SuppressWarnings("unchecked")
	public void add(T t) 
	{
		T[] originHeap = data;
		data = (T[]) new Comparable[++heapSize];
		
		for (int i = 0; i < originHeap.length; i++)
		{
			data[i] = originHeap[i];
		}
		
		data[heapSize - 1] = t;
		build(heapSize);
	}

	
	public void print() 
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.println(data[i]);
		}
	}
	
}
