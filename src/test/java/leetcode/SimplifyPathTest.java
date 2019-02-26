package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimplifyPathTest
{
	SimplifyPath simplifyPath;

	@Before
	public void setUp() throws Exception
	{
		simplifyPath = new SimplifyPath();
	}

	@Test
	public void simplify1()
	{
		String inputPath = "/../";

		String expected = "/";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify2()
	{
		String inputPath = "/home//foo/";

		String expected = "/home/foo";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify3()
	{
		String inputPath = "/a/./b/../../c/";

		String expected = "/c";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify4()
	{
		String inputPath = "/a/../../b/../c//.//";

		String expected = "/c";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify5()
	{
		String inputPath = "/a//b////c/d//././/..";

		String expected = "/a/b/c";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify6()
	{
		String inputPath = "/home/";

		String expected = "/home";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}

	@Test
	public void simplify()
	{
		String inputPath = "";

		String expected = "/";
		String result =  simplifyPath.simplifyPath(inputPath);

		assertEquals(expected, result);
	}
}