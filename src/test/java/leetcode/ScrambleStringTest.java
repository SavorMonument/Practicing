package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScrambleStringTest
{
	ScrambleString scrambleString;

	@Before
	public void setUp() throws Exception
	{
		scrambleString = new ScrambleString();
	}

	@Test
	public void scramble()
	{
		String inputString = "great";
		String inputScramble = "rgeat";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void scramble2()
	{
		String inputString = "great";
		String inputScramble = "rgeaf";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertFalse(result);
	}

	@Test
	public void scramble3()
	{
		String inputString = "abcde";
		String inputScramble = "caebd";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertFalse(result);
	}

	@Test
	public void scramble4()
	{
		String inputString = "a";
		String inputScramble = "a";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void scramble5()
	{
		String inputString = "b";
		String inputScramble = "b";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void scramble6()
	{
		String inputString = "";
		String inputScramble = "";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void scramble7()
	{
		String inputString = "abb";
		String inputScramble = "bab";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void scramble8()
	{
		String inputString = "abc";
		String inputScramble = "bca";

		boolean result = scrambleString.isScramble(inputString, inputScramble);

		assertTrue(result);
	}

	@Test
	public void isAnagram()
	{
		String s1 = "fasd";
		String s2 = "dsaf";

		assertTrue(scrambleString.isAnagram(s1, s2));
	}

	@Test
	public void isAnagram2()
	{
		String s1 = "fasd";
		String s2 = "dstf";

		assertFalse(scrambleString.isAnagram(s1, s2));
	}

	@Test
	public void isAnagram3()
	{
		String s1 = "a";
		String s2 = "a";

		assertTrue(scrambleString.isAnagram(s1, s2));
	}

	@Test
	public void isAnagram4()
	{
		String s1 = "b";
		String s2 = "a";

		assertFalse(scrambleString.isAnagram(s1, s2));
	}
}