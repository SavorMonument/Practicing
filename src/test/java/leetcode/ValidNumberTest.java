package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidNumberTest
{
	ValidNumber validNumber;

	@Before
	public void setUp() throws Exception
	{
		validNumber = new ValidNumber();
	}

	@Test
	public void isNumber1()
	{
		String input = "0";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber2()
	{
		String input = "0.1";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber3()
	{
		String input = "abc";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber4()
	{
		String input = "1   a";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber5()
	{
		String input = "2e10";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber6()
	{
		String input = " -90e3   ";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber7()
	{
		String input = "  1e";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber8()
	{
		String input = "e3";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber9()
	{
		String input = " 6e-1";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber10()
	{
		String input = "99e2.5";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber11()
	{
		String input = "53.5e93";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber12()
	{
		String input = " --6";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber13()
	{
		String input = " -+3";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber14()
	{
		String input = " 95a54e53";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber15()
	{
		String input = " ";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}

	@Test
	public void isNumber16()
	{
		String input = ".1";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber17()
	{
		String input = "3.";

		boolean result = validNumber.isNumber(input);

		assertTrue(result);
	}

	@Test
	public void isNumber18()
	{
		String input = "1e1e1";

		boolean result = validNumber.isNumber(input);

		assertFalse(result);
	}
}