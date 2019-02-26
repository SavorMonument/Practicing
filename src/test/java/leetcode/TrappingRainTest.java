package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainTest
{
	TrappingRain trappingRain;

	@Before
	public void setUp() throws Exception
	{
		trappingRain = new TrappingRain();
	}

	@Test
	public void trap1()
	{
		int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		int expected = 6;
		int result = trappingRain.trap(input);

		assertEquals(expected, result);
	}

	@Test
	public void trap2()
	{
		int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 1, 1, 1, 1, 1};

		int expected = 2;
		int result = trappingRain.trap(input);

		assertEquals(expected, result);
	}

	@Test
	public void trap3()
	{
		int[] input = new int[]{0, 1, 0, 2, 0, 0, 1, 1, 1, 1, 1, 1};

		int expected = 3;
		int result = trappingRain.trap(input);

		assertEquals(expected, result);
	}

	@Test
	public void trap4()
	{
		int[] input = new int[]{2, 0, 2};

		int expected = 2;
		int result = trappingRain.trap(input);

		assertEquals(expected, result);
	}

	@Test
	public void trap5()
	{
		int[] input = new int[]{};

		int expected = 0;
		int result = trappingRain.trap(input);

		assertEquals(expected, result);
	}

	@Test
	public void findPillarTest()
	{
		int[] input = new int[]{0, 1, 1};

		int expected = 1;
		int result = trappingRain.findRightPillar(input, 0);

		assertEquals(expected, result);
	}

	@Test
	public void findPillarTest2()
	{
		int[] input = new int[]{1, 1, 1};

		int expected = 1;
		int result = trappingRain.findRightPillar(input, 0);

		assertEquals(expected, result);
	}

	@Test
	public void findPillarTest3()
	{
		int[] input = new int[]{1, 0, 1};

		int expected = 2;
		int result = trappingRain.findRightPillar(input, 0);

		assertEquals(expected, result);
	}

	@Test
	public void findPillarTest4()
	{
		int[] input = new int[]{2, 0, 1, 3};

		int expected = 3;
		int result = trappingRain.findRightPillar(input, 0);

		assertEquals(expected, result);
	}

	@Test
	public void findPillarTest5()
	{
		int[] input = new int[]{2, 0, 0, 0};

		int expected = 1;
		int result = trappingRain.findRightPillar(input, 0);

		assertEquals(expected, result);
	}
}