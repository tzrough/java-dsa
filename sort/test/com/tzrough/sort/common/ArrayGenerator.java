package com.tzrough.sort.common;

import java.util.Random;

import com.sun.org.apache.regexp.internal.recompile;

public class ArrayGenerator
{
	
	public static int[] generate(int size)
	{
		
		int[] a = new int[size];
		Random random = new Random();
		
		for (int i = 0; i < size; i++)
		{
			a[i] = random.nextInt();
		}
		
		return a;
	}
	
}
