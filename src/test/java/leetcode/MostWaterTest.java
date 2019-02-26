package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MostWaterTest
{

	MostWater mostWater;

	@Before
	public void setUp() throws Exception
	{
		mostWater = new MostWater();
	}

	@Test
	public void maxArea_First()
	{
		int[] inputValues = new int[]{1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int result = mostWater.maxArea(inputValues);

		assertEquals(expected, result);
	}

	@Test
	public void maxArea_Second()
	{
		int[] inputValues = new int[]{1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int result = mostWater.maxArea(inputValues);

		assertEquals(expected, result);
	}

	@Test
	public void maxArea_Third()
	{
		int[] inputValues = new int[]{1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int result = mostWater.maxArea(inputValues);

		assertEquals(expected, result);
	}

	@Test
	public void maxArea_Forth()
	{
		int[] inputValues = new int[]{1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int result = mostWater.maxArea(inputValues);

		assertEquals(expected, result);
	}

	@Test
	public void maxArea_Fifth()
	{
		int[] inputValues = new int[]{1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int result = mostWater.maxArea(inputValues);

		assertEquals(expected, result);
	}
}