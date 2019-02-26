package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanTest
{

	Roman roman;

	@Before
	public void setUp() throws Exception
	{
		roman = new Roman();
	}

	@Test
	public void intToRoman_First()
	{
		int input = 1;

		String expected = "I";
		String result = roman.intToRoman(input);

		assertEquals(expected, result);
	}

	@Test
	public void intToRoman_Second()
	{
		int input = 3;

		String expected = "III";
		String result = roman.intToRoman(input);

		assertEquals(expected, result);
	}

	@Test
	public void intToRoman_Third()
	{
		int input = 4;

		String expected = "IV";
		String result = roman.intToRoman(input);

		assertEquals(expected, result);
	}


	@Test
	public void intToRoman_Fourth()
	{
		int input = 58;

		String expected = "LVIII";
		String result = roman.intToRoman(input);

		assertEquals(expected, result);
	}

	@Test
	public void intToRoman_Fifth()
	{
		int input = 1994;

		String expected = "MCMXCIV";
		String result = roman.intToRoman(input);

		assertEquals(expected, result);
	}
}