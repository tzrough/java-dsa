package com.hongfei.sort;

public class BubbleSort
{

	public void doSort(int[] A)
	{

		int length = A.length;

		for (boolean sorted = false; sorted = !sorted; length--)
		{

			for (int i = 1; i < length; i++)
			{

				if (A[i - 1] > A[i])
				{

					int temp = A[i - 1];
					A[i - 1] = A[i];
					A[i] = temp;

					sorted = false;
				}
			}
		}

		for (int j = 0; j < A.length; j++)
		{

			System.out.println(A[j]);
		}

	}

	public static void main(String[] args)
	{

		int[] A = { 9, 2, 3, 1, 5, 4, 7 };

		BubbleSort bubbleSort = new BubbleSort();

		bubbleSort.doSort(A);

	}

}
