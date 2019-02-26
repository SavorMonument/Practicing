package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest
{

	Division division;

	@Before
	public void setUp() throws Exception
	{
		division = new Division();
	}

	@Test
	public void division_Test1()
	{
		int dividend = 10;
		int divisor = 3;

		int expected = 3;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test11()
	{
		int dividend = 9;
		int divisor = 3;

		int expected = 3;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test12()
	{
		int dividend = 9;
		int divisor = 4;

		int expected = 2;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test2()
	{
		int dividend = 7;
		int divisor = -3;

		int expected = -2;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test3()
	{
		int dividend = (int)2e+9;
		int divisor = (int)1.5e+9;

		int expected = 1;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test4()
	{
		int dividend = Integer.MAX_VALUE;
		int divisor = Integer.MAX_VALUE;

		int expected = 1;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test5()
	{
		int dividend = Integer.MAX_VALUE;
		int divisor = Integer.MAX_VALUE / 2;

		int expected = 2;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test6()
	{
		int dividend = Integer.MAX_VALUE - 2;
		int divisor = Integer.MAX_VALUE / 2;

		int expected = 1;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test7()
	{
		int dividend = Integer.MIN_VALUE;
		int divisor = Integer.MIN_VALUE;

		int expected = 1;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}

	@Test
	public void division_Test8()
	{
		int dividend = Integer.MIN_VALUE;
		int divisor = -1;

		int expected = Integer.MAX_VALUE;
		int result = division.divide(dividend, divisor);

		assertEquals(expected, result);
	}
}