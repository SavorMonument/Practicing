package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest
{
	LongestPalindromicSubstring longestPalindromicSubstring;

	@Before
	public void setUp() throws Exception
	{
		longestPalindromicSubstring = new LongestPalindromicSubstring();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void longestPalindrome_First()
	{
		String inputString = "babad";

		String expected = "bab";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Second()
	{
		String inputString = "cbbd";

		String expected = "bb";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Third()
	{
		String inputString = "bb";

		String expected = "bb";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Forth()
	{
		String inputString = "bba";

		String expected = "bb";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Fifth()
	{
		String inputString = "abb";

		String expected = "bb";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Sixth()
	{
		String inputString = "aaaa";

		String expected = "aaaa";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}

	@Test
	public void longestPalindrome_Seventh()
	{
		String inputString = "tattarrattat";

		String expected = "tattarrattat";
		String result = longestPalindromicSubstring.longestPalindrome(inputString);

		assertEquals(expected, result);
	}
}