package leetcode;

import tables.Table;

import java.util.Arrays;

public class UniquePaths3
{

	public int uniquePathsIII(int[][] grid)
	{
		int starti = 0;
		int startj = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == 1)
				{
					starti = i;
					startj = j;
				}

		return walk(grid, starti, startj);
	}

	private int walk(int[][] grid, int i, int j)
	{
		int path = 0;
		if (grid[i][j] == 2)
			if (areAllVisited(grid))
				return 1;
			else
				return 0;

		grid[i][j] = 1;
		if (i + 1 < grid.length && (grid[i + 1][j] == 0 || grid[i + 1][j] == 2))
			path += walk(grid, i + 1, j);
		if (j + 1 < grid[i].length && (grid[i][j + 1] == 0 || grid[i][j + 1] == 2))
			path += walk(grid, i, j + 1);
		if (i - 1 > -1 && (grid[i - 1][j] == 0 || grid[i - 1][j] == 2))
			path += walk(grid, i - 1, j);
		if (j - 1 > -1 && (grid[i][j - 1] == 0 || grid[i][j - 1] == 2))
			path += walk(grid, i, j - 1);
		grid[i][j] = 0;

		return path;
	}

	private static int[][] matrixCopy(int[][] grid)
	{
		int[][] clone = new int[grid.length][];

		for (int i = 0; i < grid.length; i++)
			clone[i] = Arrays.copyOf(grid[i], grid[i].length);

		return clone;
	}

	private boolean areAllVisited(int[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == 0)
					return false;

		return true;
	}

	private static void printMatrix(int[][] matrix)
	{
		assert null != matrix && matrix.length > 0;

		Table.TableBuilder tableBuilder = new Table.TableBuilder();
		tableBuilder.setNumberedTable(matrix[0].length, matrix.length);
		tableBuilder.setWhiteSpaceCharacter(' ');
		Table table = tableBuilder.build();

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				table.addElement(Integer.toString(i), Integer.toString(j), matrix[i][j]);
		table.printToScreen();
		System.out.println();
	}
}
