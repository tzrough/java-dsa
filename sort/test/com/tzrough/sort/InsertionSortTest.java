package com.tzrough.sort;

import org.junit.Before;
import org.junit.Test;

import com.tzrough.sort.common.ArrayGenerator;
import com.tzrough.sort.common.BasicSort;
import com.tzrough.sort.constant.DataAmount;

public class InsertionSortTest extends BasicSort
{
	@Before
	public void init() 
	{
		this.sortType = new InsertionSort();
	}
	
	@Test
	public void verifySorted()
	{
		super.verifySorted();
	}
	
	
	@Test
	public void test() 
	{
		super.sortAndPrintRunTime(ArrayGenerator.generate(DataAmount.oneK));
		super.sortAndPrintRunTime(ArrayGenerator.generate(DataAmount.tenK));
		super.sortAndPrintRunTime(ArrayGenerator.generate(DataAmount.oneM));
		super.sortAndPrintRunTime(ArrayGenerator.generate(DataAmount.tenM));
	}

}
