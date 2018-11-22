package spaghetti;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestAlphabetSubStringTest {

	ShortestAlphabetSubString test = new ShortestAlphabetSubString();


	@Test
	public void empty(){
		String str = "";
		String alphabet = "";

		String expected = "";
		String result = test.getResult(str, alphabet);

		assertEquals(expected, result);
	}

	@Test
	public void test1(){
		String str = "a";
		String alphabet = "a";

		String expected = "a";
		String result = test.getResult(str, alphabet);

		assertEquals(expected, result);
	}

	@Test
	public void test2(){
		String str = "abbcac";
		String alphabet = "abc";

		String expected = "bca";
		String result = test.getResult(str, alphabet);

		assertEquals(expected, result);
	}

	@Test
	public void test3(){
		String str = "aabbccba";
		String alphabet = "abc";

		String expected = "cba";
		String result = test.getResult(str, alphabet);

		assertEquals(expected, result);
	}

	@Test
	public void test4(){
		String str = "abbcaaaaaaaaaaaaaabc";
		String alphabet = "abc";

		String expected = "bca";
		String result = test.getResult(str, alphabet);

		assertEquals(expected, result);
	}
}