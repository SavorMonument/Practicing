package leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class atoiTest
{

	Atoi atoi;

	@Before
	public void setUp() throws Exception
	{
		atoi = new Atoi();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void myAtoi_First()
	{
		String input = "42";

		int expected = 42;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Second()
	{
		String input = "    -42";

		int expected = -42;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Third()
	{
		String input = "4193 with words";

		int expected = 4193;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Forth()
	{
		String input = "words with 4193";

		int expected = 0;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Fifth()
	{
		String input = "-91283472332";

		int expected = -2147483648;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Sixth()
	{
		String input = "+1";

		int expected = 1;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Seventh()
	{
		String input = "";

		int expected = 0;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Eight()
	{
		String input = "+-2";

		int expected = 0;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Ninth()
	{
		String input = "2147483646";

		int expected = 2147483646;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Tenth()
	{
		String input = "2147483648";

		int expected = 2147483647;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Eleventh()
	{
		String input = "-2147483648";

		int expected = -2147483648;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}

	@Test
	public void myAtoi_Twelveth()
	{
		String input = "   2147483648";

		int expected = 2147483647;
		int result = atoi.myAtoi(input);

		assertEquals(expected, result);
	}
}