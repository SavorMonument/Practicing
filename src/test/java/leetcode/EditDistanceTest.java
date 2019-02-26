package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest
{

	EditDistance editDistance;

	@Before
	public void setUp() throws Exception
	{
		editDistance = new EditDistance();
	}

	@Test
	public void minDistance1()
	{
		String word1 = "intention";
		String word2 = "execution";

		int expected = 5;
		int result = editDistance.minDistance(word1, word2);

		assertEquals(expected, result);
	}

	@Test
	public void minDistance2()
	{
		String word1 = "asap";
		String word2 = "sape";

		int expected = 2;
		int result = editDistance.minDistance(word1, word2);

		assertEquals(expected, result);
	}

	@Test
	public void minDistance3()
	{
		String word1 = "apes";
		String word2 = "sape";

		int expected = 2;
		int result = editDistance.minDistance(word1, word2);

		assertEquals(expected, result);
	}

	@Test
	public void minDistance4()
	{
		String word1 = "";
		String word2 = "";

		int expected = 0;
		int result = editDistance.minDistance(word1, word2);

		assertEquals(expected, result);
	}

	@Test
	public void minDistance5()
	{
		String word1 = "";
		String word2 = "";

		int expected = 0;
		int result = editDistance.minDistance(word1, word2);

		assertEquals(expected, result);
	}
}