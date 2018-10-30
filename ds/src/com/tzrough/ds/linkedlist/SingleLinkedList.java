package com.tzrough.ds.linkedlist;


public class SingleLinkedList
{
	// 链表大小
	private int size;
	// 头节点
	private Node head;

	
	public void add2Head(Object data) 
	{
		Node newNode = new Node(data);
		
		if(size == 0)
			head = newNode;
		else 
		{
			newNode.next = head;
			head = newNode;
		}
		
		size++;
	}
	
	public void add2Tail(Object data) 
	{
		
	}
	
	
	/**
	 * 在指定位置插入节点
	 */
	public void add(int index, Node node) 
	{
		if(index < 0 || index > size - 1) 
		{
			System.out.println("越界");
			return;
		}
		
		int curIndex = 0;
		Node curNode = head;
		
		while(head.next != null) 
		{
			if(index == curIndex++) 
			{
				node.next = curNode.next;
				curNode.next = node;
				size++;
				return;
			}
		}
		
		curNode = curNode.next;
	}
	
	
	public static void main(String[] args)
	{
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		singleLinkedList.add2Head("A");
		singleLinkedList.add2Head("B");
		singleLinkedList.add2Head("C");
		
		
		Node node = new Node("D");
		singleLinkedList.add(1, node);
				
	}
}
