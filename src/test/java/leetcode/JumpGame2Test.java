package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGame2Test
{
	JumpGame2 jumpGame2;

	@Before
	public void setUp() throws Exception
	{
		jumpGame2 = new JumpGame2();
	}

	@Test
	public void jump1()
	{
		int[] input = new int[]{2, 3, 1, 1, 4};

		int expected = 2;
		int result = jumpGame2.jump(input);

		assertEquals(expected, result);
	}

	@Test
	public void jump2()
	{
		int[] input = new int[]{3, 2, 1, 1, 4};

		int expected = 2;
		int result = jumpGame2.jump(input);

		assertEquals(expected, result);
	}

	@Test
	public void jump3()
	{
		int[] input = new int[]{3, 3, 1, 7, 4};

		int expected = 2;
		int result = jumpGame2.jump(input);

		assertEquals(expected, result);
	}
}