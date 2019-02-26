package leetcode;

import tables.Table;

import java.util.Arrays;

public class SpiralMatrix
{
	public int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];

		int horisontalDirection = 1;
		int verticalDirection = 1;

		int i = 0;
		int j = 0;
		int counter = 1;

		while(!(i == n / 2 && j == (n - 1) / 2))
		{
			for (; 0 <= j && j < n && matrix[i][j] == 0; j += horisontalDirection)
			{
				matrix[i][j] = counter;
				counter++;
			}

			horisontalDirection = -horisontalDirection;
			j += horisontalDirection;
			i += verticalDirection;

			for (; 0 <= i && i < n && matrix[i][j] == 0; i += verticalDirection)
			{
				matrix[i][j] = counter;
				counter++;
			}

			verticalDirection = -verticalDirection;
			i += verticalDirection;
			j += horisontalDirection;
		}
		matrix[i][j] = counter;

		return matrix;
	}

	private static void printMatrix(int[][] matrix)
	{
		assert null != matrix && matrix.length > 0;

		Table.TableBuilder tableBuilder = new Table.TableBuilder();
		tableBuilder.setNumberedTable(matrix.length, matrix[0].length);
		Table table = tableBuilder.build();

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				table.addElement(Integer.toString(i), Integer.toString(j), matrix[i][j]);
			}
		}
		table.printToScreen();
	}

	private static void printMatrixLinear(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			System.out.print(Arrays.toString(matrix[i]));
		}
	}

	public static void main(String[] args)
	{
		SpiralMatrix spiralMatrix = new SpiralMatrix();

		printMatrixLinear(spiralMatrix.generateMatrix(4));
	}
}
