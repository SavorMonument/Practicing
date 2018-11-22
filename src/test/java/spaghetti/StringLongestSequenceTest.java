package spaghetti;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringLongestSequenceTest {

	StringLongestSequence test;


	@Test
	public void emptyString(){

		test = new StringLongestSequence("");

		String expected = "";
		String result = test.getResult();

		assertEquals(expected, result);
	}

	@Test
	public void test1(){

		test = new StringLongestSequence("abcbbbbcccbdddadacb");

		String expected = "bcbbbbcccb";
		String result = test.getResult();

		assertEquals(expected, result);
	}

}