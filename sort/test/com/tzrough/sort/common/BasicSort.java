package com.tzrough.sort.common;

import com.tzrough.sort.Sort;
import com.tzrough.sort.constant.DataAmount;

public class BasicSort
{
	private static int verifyGroupNum = 10;

	protected Sort sortType;
	private long startTime;
	private long endTime;
	
	/**
	 * 验证算法正确性
	 */
	protected void verifySorted()
	{
		int[] a = new int[DataAmount.oneK];
		
		System.out.println("*****************************");
		System.out.println("");
		System.out.println(sortType.getClass().getSimpleName() + " Test Result ");
		System.out.println("");
		System.out.println("*****************************");
		
		for (int i = 0; i < verifyGroupNum; i++)
		{
			a = ArrayGenerator.generate(DataAmount.oneK);
			sortType.sort(a);
			System.out.print("Group " + i + " is SORTED:" + String.valueOf(verify(a)).toUpperCase());
			System.out.print("      *");
			System.out.println("");
		}
		
		System.out.println("*****************************");
	}
	
	/**
	 * @param a
	 * 验证数组是否已按 升序 排列
	 */
	private boolean verify(int[] a) 
	{
		boolean flag = true;
		
		for (int i = 0; i < a.length - 1; i++)
		{
			if(a[i+1] < a[i]) 
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	
	public void sortAndPrintRunTime(int[] a)
	{
		int dataAmount = a.length;
		
		startTime = System.currentTimeMillis();
		
		sortType.sort(a);
		
		endTime = System.currentTimeMillis();
		
		long runtime = endTime - startTime;
		
		String runtimeStr = runtime > 1000 ? runtime / 1000 + " s" : runtime + " ms";
		
		System.out.println(sortType.getClass().getSimpleName() + " sort " + dataAmount + " number uses " + runtimeStr);
	}
	
	

}
