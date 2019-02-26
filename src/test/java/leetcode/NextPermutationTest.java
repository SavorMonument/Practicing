package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest
{

	NextPermutation nextPermutation;

	@Before
	public void setUp() throws Exception
	{
		nextPermutation = new NextPermutation();
	}

	@Test
	public void nextPermutation()
	{
		int[] inputDigits = new int[]{1, 2, 3};

		int[] expected = new int[]{1, 3, 2};
		int[] result = nextPermutation.nextPermutation(inputDigits);

		assertArrayEquals(expected, result);
	}

	@Test
	public void nextPermutation2()
	{
		int[] inputDigits = new int[]{3, 2, 1};

		int[] expected = new int[]{1, 2, 3};
		int[] result = nextPermutation.nextPermutation(inputDigits);

		assertArrayEquals(expected, result);
	}

	@Test
	public void nextPermutation3()
	{
		int[] inputDigits = new int[]{1, 1, 5};

		int[] expected = new int[]{1, 5, 1};
		int[] result = nextPermutation.nextPermutation(inputDigits);

		assertArrayEquals(expected, result);
	}
}