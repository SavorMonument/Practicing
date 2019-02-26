package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest
{

	ReverseInteger reverseInteger;

	@Before
	public void setUp() throws Exception
	{
		reverseInteger = new ReverseInteger();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void reverse_First()
	{
		int input = 123;

		int expected = 321;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Second()
	{
		int input = 120;

		int expected = 21;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Third()
	{
		int input = -123;

		int expected = -321;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Forth()
	{
		int input = 0;

		int expected = 0;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Fifth()
	{
		int input = 2147483647;

		int expected = 0;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Sixth()
	{
		int input = 1147483649;

		int expected = 0;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Seventh()
	{
		int input = -2147483648;

		int expected = 0;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Eight()
	{
		int input = 1563847412;

		int expected = 0;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Nine()
	{
		int input = 563847412;

		int expected = 214748365;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}

	@Test
	public void reverse_Ten()
	{
		int input = 1111841412;

		int expected = 2141481111;
		int result = reverseInteger.reverse(input);

		assertEquals(expected, result);
	}
}