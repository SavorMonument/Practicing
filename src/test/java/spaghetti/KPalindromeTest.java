package spaghetti;

import org.junit.Test;

import static org.junit.Assert.*;

public class KPalindromeTest {

	KPalindrome kPal = new KPalindrome();

	@Test
	public void smallString(){

		String input = "a";
		int k = 0;

		boolean expected = true;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}

	@Test
	public void smallString1(){

		String input = "a";
		int k = 1;

		boolean expected = false;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}

	@Test
	public void test1(){

		String input = "abxa";
		int k = 1;

		boolean expected = true;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}

	@Test
	public void test2(){

		String input = "abdxa";
		int k = 1;

		boolean expected = false;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}

	@Test
	public void test3(){

		String input = "abbxa";
		int k = 1;

		boolean expected = true;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}

	@Test
	public void test4(){

		String input = "ab1b2x2zz99mzz33xb44ba";
		int k = 8;

		boolean expected = true;
		boolean result = kPal.getResult(input, k);

		assertEquals(expected, result);
	}
}