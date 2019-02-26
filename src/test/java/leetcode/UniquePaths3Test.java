package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePaths3Test
{
	UniquePaths3 uniquePaths3;
	
	@Before
	public void setUp() throws Exception
	{
		uniquePaths3 = new UniquePaths3();
	}

	@Test
	public void pathTest()
	{
		int[][] inputMatrix = new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};

		int expected = 2;
		int result = uniquePaths3.uniquePathsIII(inputMatrix);

		assertEquals(expected, result);
	}

	@Test
	public void pathTest1()
	{
		int[][] inputMatrix = new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,0,2}};

		int expected = 4;
		int result = uniquePaths3.uniquePathsIII(inputMatrix);

		assertEquals(expected, result);
	}

	@Test
	public void pathTest2()
	{
		int[][] inputMatrix = new int[][]{{0, 1}, {2, 0}};

		int expected = 0;
		int result = uniquePaths3.uniquePathsIII(inputMatrix);

		assertEquals(expected, result);
	}

	@Test
	public void pathTest3()
	{
		int[][] inputMatrix = new int[][]{{1, 0}, {2, 0}};

		int expected = 1;
		int result = uniquePaths3.uniquePathsIII(inputMatrix);

		assertEquals(expected, result);
	}


}