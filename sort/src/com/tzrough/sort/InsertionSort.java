package com.tzrough.sort;

public class InsertionSort extends Sort
{

	//[6,5,3,2,7,1]
	@Override
	public void sort(int[] a)
	{
		int size = a.length;
		
		for (int i = 1; i < size; i++)
		{
			int value = a[i];
			int j = i - 1;
			
			for (; j >= 0; j--)
			{
				if(a[j] > value)
					a[j+1] = a[j];
				else
					break;
			}

			a[j+1] = value;
			
		}
	}

}
	
