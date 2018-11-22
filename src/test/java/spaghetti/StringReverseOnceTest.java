package spaghetti;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverseOnceTest {

	StringReverseOnce once;

	@Before
	public void before(){

	}

	@Test
	public void emptyString(){

		once = new StringReverseOnce("");

		String expeted = "";
		String result = once.getResult();

		assertEquals(expeted, result);
	}

	@Test
	public void test1(){

		once = new StringReverseOnce("aabdceaaabbbcd");

		String expeted = "dcbae";
		String result = once.getResult();

		assertEquals(expeted, result);
	}

	@Test
	public void test2(){

		once = new StringReverseOnce("aaaabbcddddccbbdaaeee");

		String expeted = "eadbc";
		String result = once.getResult();

		assertEquals(expeted, result);
	}

	@Test
	public void test3(){

		once = new StringReverseOnce("aaafffcccddaabbeeddhhhaaabbccddaaaa");

		String expeted = "adcbhef";
		String result = once.getResult();

		assertEquals(expeted, result);
	}

	@Test
	public void oneLetterMultiple(){

		once = new StringReverseOnce("aaaaaaaaa");

		String expeted = "a";
		String result = once.getResult();

		assertEquals(expeted, result);
	}
}