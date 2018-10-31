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
	
	/** 获取根节点下标 **/
	public int parent(int i) 
	{
		if(i == 0)
			return -1;
		else
			return (i - 1) / 2;
	}

	/** 获取左孩子节点下标 **/
	public int leftChild(int i) 
	{
		return (i + 1) * 2 - 1;
	}

	/** 获取右孩子节点下标 **/
	public int rightChild(int i) 
	{
		return (i + 1) * 2;
	}
	
	/**
	 * 调整堆中某个节点的位置
	 * @param data 		存入堆的数据
	 * @param heapsize  此变量用于重构部分堆节点
	 * @param i  		堆中需要调整位置的元素下标
	 */
	public abstract void heapify(T[] data, int heapsize, int i);
	
	/** 重建堆结构 **/
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
	
	/**
	 * 排序思路
	 * 1> 将大根(小根)堆根节点置换到堆尾
	 * 2> 将大根(小根)堆大小缩小1，去除最后一个节点
	 * 3> 将缩小后的大根(小根)堆重新构建
	 * 4> 重复1-3步骤，直至堆只剩下两个节点
	 */
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
	
	/**
	 * 交换堆的两个节点
	 */
	public void swap(int index1, int index2) 
	{
		T temp = data[index1];
		
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	/**
	 * 向堆中添加新的节点 
	 */
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

	/**
	 * 打印堆中的节点
	 */
	public void print() 
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.println(data[i]);
		}
	}
	
}
