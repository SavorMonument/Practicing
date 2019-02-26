package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RExpressionMatchingTest
{
	RExpressionMatching matching;

	@Before
	public void setUp() throws Exception
	{
		matching = new RExpressionMatching();
	}

	@Test
	public void isMatch_First()
	{
		String inputString = "a";
		String expression = "a";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Second()
	{
		String inputString = "aa";
		String expression = "a";

		boolean expected = false;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Third()
	{
		String inputString = "aa";
		String expression = "a.";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Forth()
	{
		String inputString = "aa";
		String expression = "a*";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Fifth()
	{
		String inputString = "mississippi";
		String expression = "mis*is*p*.";

		boolean expected = false;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Sixth()
	{
		String inputString = "aab";
		String expression = "c*a*b";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Seventh()
	{
		String inputString = "mississippi";
		String expression = "mis*is*ip*.";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Eight()
	{
		String inputString = "aab";
		String expression = "a*a*b";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Ninth()
	{
		String inputString = "aab";
		String expression = "c*a*b";

		boolean expected = true;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}

	@Test
	public void isMatch_Tenth()
	{
		String inputString = "aab";
		String expression = "ab";

		boolean expected = false;
		boolean result = matching.isMatch(inputString, expression);

		assertEquals(expected, result);
	}
}