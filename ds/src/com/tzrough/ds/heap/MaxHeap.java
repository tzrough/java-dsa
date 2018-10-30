package com.tzrough.ds.heap;

/**
 * 大根堆
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T>
{

	public MaxHeap(T[] data)
	{
		super(data);
	}

	@Override
	public void heapify(T[] data, int heapSize, int i)
	{
		
		int leftChild = leftChild(i);
		int rightChild = rightChild(i);
		
		/*
		 * 先判断左孩子是否越界， 越界则说明
		 * 1> 右孩子也越界
		 * 2> 此节点为叶子节点
		 * 3> 此节点不需要调整位置
		 * 
		 * 临界条件
		 * 左孩子为最后一个节点  leftChild = heapSize - 1
		 * 此时需要判断右孩子是否越界 rightChild <= heapSize - 1
		 */
		if(leftChild > heapSize - 1)
			return;
		
		/*
		 *  最大值下标， 比较范围：
		 *	1> 当前节点(父节点)
		 *	2> 左孩子
		 *	3> 右孩子
		 */
		int largest = -1;
		
		/*
		 * 比较左孩子
		 * 1> 若左孩子值大于父节点，则记录较大值下标为左孩子
		 * 2> 若左孩子值小于父节点，则记录较大值下标为当前节点(父节点)
		 */
		if(data[i].compareTo(data[leftChild]) < 0)
			largest = leftChild;
		else
			largest = i;
		
		/* 比较右孩子
		 * 1> 若右孩子值大于父节点，则记录较大值下标为右孩子
		 * 2> 若右孩子值小于父节点，则记录较大值下标为当前节点(父节点)
		 */
		if(rightChild <= heapSize - 1 && data[largest].compareTo(data[rightChild]) < 0)
			largest = rightChild;
		
		/* 若孩子节点值大于当前节点(父节点)
		 * 1> 将当前节点与孩子节点替换
		 * 2> 调整替换后的孩子节点为父节点的堆
		 * 	    因为此时的孩子节点的值已经替换为之前的父节点的值，以此节点为根的堆，未必是大根堆，需要调整
		 */
		if(i != largest) 
		{
			T temp = data[i];
			data[i] = data[largest];
			data[largest] = temp;
			
			heapify(data, heapSize, largest);
		}
	}
	
	
}
