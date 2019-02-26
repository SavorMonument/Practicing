package spaghetti;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordInitTest {

	WordInit test = new WordInit();

	@Test
	public void test1(){
		String[] init = new String[]{"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo"};
		String prefix = "H";

		String[] expected = new String[] {"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo"};
		String[] result = test.getResult(init, prefix);

		assertArrayEquals(expected, result);
	}

	@Test
	public void test2(){
		String[] init = new String[]{"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo"};
		String prefix = "HW";

		String[] expected = new String[] {"HelloWorld", "HelloWorldMars"};
		String[] result = test.getResult(init, prefix);

		assertArrayEquals(expected, result);
	}

	@Test
	public void test3(){
		String[] init = new String[]{"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo"};
		String prefix = "Ho";

		String[] expected = new String[] {};
		String[] result = test.getResult(init, prefix);

		assertArrayEquals(expected, result);
	}

	@Test
	public void test4(){
		String[] init = new String[]{"HelloMars", "HelloWorld", "HelloWorldMars", "HiHo"};
		String prefix = "HeWorM";

		String[] expected = new String[] {"HelloWorldMars"};
		String[] result = test.getResult(init, prefix);

		assertArrayEquals(expected, result);
	}
}