package com.tzrough.sort;

public class BubbleSort extends Sort
{
	
	// 升序
	public void sort(int[] a)
	{
		boolean flag = false;

		int size = a.length;
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size - i - 1; j++)
			{
				if (a[j] > a[j+1] )
				{
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					flag = true;
				}
			}
			
			if (!flag)
				break;
		}
		
	}
	
}
