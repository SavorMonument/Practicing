package spaghetti;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringShuffleTest {

	StringShuffle test = new StringShuffle();


	@Test
	public void test1(){

		String input = "ABCDAABCD";

		String expected = "ABABACDCD";
		String result = test.getResult(input);

		assertEquals(expected, result);
	}

	@Test
	public void test2(){

		String input = "AABC";

		String expected = "ABAC";
		String result = test.getResult(input);

		assertEquals(expected, result);
	}
}