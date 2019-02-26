package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfSortedArraysTest
{
	MedianOfSortedArrays medianOfSortedArrays;

	@Before
	public void setUp()
	{
		medianOfSortedArrays = new MedianOfSortedArrays();
	}

	@Test
	public void findMedianSortedArrays_First()
	{
		int[] firstArray = new int[]{1, 3};
		int[] secondArray = new int[]{2};

		double expected = 2.0;
		double result = medianOfSortedArrays.findMedianSortedArrays(firstArray, secondArray);

		assertEquals(expected, result, 0.01);
	}

	@Test
	public void findMedianSortedArrays_Second()
	{
		int[] firstArray = new int[]{1, 2};
		int[] secondArray = new int[]{3, 4};

		double expected = 2.5;
		double result = medianOfSortedArrays.findMedianSortedArrays(firstArray, secondArray);

		assertEquals(expected, result, 0.01);
	}

	@Test
	public void findMedianSortedArrays_Third()
	{
		int[] firstArray = new int[]{4, 5};
		int[] secondArray = new int[]{1, 2, 3};

		double expected = 3.0;
		double result = medianOfSortedArrays.findMedianSortedArrays(firstArray, secondArray);

		assertEquals(expected, result, 0.01);
	}
}