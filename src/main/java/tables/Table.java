package tables;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table
{

	public static void main(String[] args)
	{
		TableBuilder builder = new TableBuilder();
		int side = 4;
		builder.setSquareNumberedTable(side);

		Table table = builder.build();

		for (int i = 0; i < side; i++)
		{
			for (int j = 0; j < side; j++)
			{
				table.addElement(Integer.toString(i), Integer.toString(j), "Ha");
			}
		}
		table.print(System.out);
	}

	private Character whiteSpaceCharacter = '-';
	private int cellSize = 5;

	private List<String> columns = new ArrayList<>();
	private List<String> rows = new ArrayList<>();
	private String[] table;

	//Min number of whiteSpaceCharacters around the value in cells
	private int extraCellPadding = 2;

	private Table()
	{
	}

	public Table addElement(String row, String column, Integer element)
	{
		return addElement(row, column, Integer.toString(element));
	}

	public Table addElement(String row, String column, String element)
	{
		if (null == element)
			throw new IllegalArgumentException("Element is null");

		int nrOfColumns = columns.size();
		int posInRow = getRowPosition(row);
		int posInColumn = getColumnPosition(column);

		table[posInRow * nrOfColumns + posInColumn] = element;

		recalculateCellSizeToFitStr(element);

		return this;
	}

	private int getRowPosition(String row)
	{
		int rowPos;
		if ((null == row) || (-1 == (rowPos = rows.indexOf(row))))
			throw new IllegalArgumentException("Invalid row" + row);
		return rowPos;
	}

	private int getColumnPosition(String column)
	{
		int columnPos;
		if ((column == null) || (-1 == (columnPos = columns.indexOf(column))))
			throw new IllegalArgumentException("Invalid column " + column);
		return columnPos;
	}

	private void addAllRows(String[] rowNames)
	{

		for (String name : rowNames)
			addRow(name);
	}

	private void addRow(String rowName)
	{
		assert !rows.contains(rowName) : "Can't have 2 rows with same name";

		rows.add(rowName);
	}

	private void addAllColumns(String[] columnNames)
	{

		for (String name : columnNames)
			addColumn(name);
	}

	private void addColumn(String columnName)
	{
		assert !columns.contains(columnName) : "Can't have 2 columns with same name";

		columns.add(columnName);
	}

	private void reallocateTable()
	{
		String[] biggerTable = new String[columns.size() * rows.size()];
		Arrays.fill(biggerTable, "");
		table = biggerTable;
	}
//	Used this to copy over the elements from old table to new one but i don't support modifying the table after construction anymore
//
//	private void copyByColumns(String[] from, String[] to, int oldColumnNo, int newColumnNo, int rowNo)
//	{
//
//		for (int i = 0; i < rowNo; i++)
//		{
//			System.arraycopy(from, i * oldColumnNo, to, i * newColumnNo, oldColumnNo);
//		}
//	}

	private void recalculateCellSizeToFitAnyStr()
	{
		for (String s : rows)
		{
			recalculateCellSizeToFitStr(s);
		}

		for (String s : columns)
		{
			recalculateCellSizeToFitStr(s);
		}

		for (String s : table)
		{
			recalculateCellSizeToFitStr(s);
		}
	}

	private void recalculateCellSizeToFitStr(String str)
	{
		int cellEmptySpace = cellSize - (extraCellPadding * 2);
		if (str.length() > cellEmptySpace)
		{
			cellSize = str.length() + (extraCellPadding * 2);
			if (cellSize % 2 == 0)
				cellSize += 1;
		}
	}

	public void printToScreen()
	{

		print(System.out);
	}

	public void print(PrintStream pStream)
	{
		printColumnNames(pStream);
		for (int i = 0; i < rows.size(); i++)
		{
			String rowName = rows.get(i);
			printCell(pStream, rowName);
			printRowValues(pStream, i);
		}
	}

	private void printColumnNames(PrintStream pStream)
	{
		//Top left empty cell
		printCell(pStream, "");
		for (String columnName : columns)
		{
			printCell(pStream, columnName);
		}
		System.out.print("\n");
	}

	private void printRowValues(PrintStream pStream, int rowIndex)
	{
		int startValues = columns.size() * rowIndex;

		for (int j = startValues; j < startValues + columns.size(); j++)
		{
			printCell(pStream, table[j]);
		}
		System.out.print("\n");
	}

	private void printCell(PrintStream pStream, String value)
	{

		int leftPadding = (int) Math.floor(((float) (cellSize - value.length())) / 2);
		int rightPadding = (int) Math.ceil(((float) (cellSize - value.length())) / 2);

		putWhiteSpaces(pStream, leftPadding);
		System.out.print(value);
		putWhiteSpaces(pStream, rightPadding);
	}

	private void printBorderedCell(PrintStream pStream, String value)
	{

		int leftPadding = (int) Math.floor(((float) (cellSize - value.length())) / 2);
		int rightPadding = (int) Math.ceil(((float) (cellSize - value.length())) / 2);

		putWhiteSpaces(pStream, leftPadding);
		System.out.print(value);
		putWhiteSpaces(pStream, rightPadding);
	}

	private void putWhiteSpaces(PrintStream pStream, int number)
	{
		for (int i = 0; i < number; i++)
		{
			pStream.print(whiteSpaceCharacter);
		}
	}

	private void setExtraCellPadding(int extraCellPadding)
	{
		cellSize -= this.extraCellPadding;
		this.extraCellPadding = extraCellPadding;
		cellSize += extraCellPadding;
	}

	private void setWhiteSpaceCharacter(Character whiteSpaceCharacter)
	{
		this.whiteSpaceCharacter = whiteSpaceCharacter;
	}


	public static class TableBuilder
	{
		Table table;

		public TableBuilder()
		{

			table = new Table();
		}

		public void addAllRows(String[] rowNames)
		{
			for (String name : rowNames)
				addRow(name);
		}


		public boolean addRow(String rowName)
		{
			try
			{
				table.addRow(rowName);
			} catch (IllegalArgumentException e)
			{
				return false;
			}

			return true;
		}

		public void addAllColumns(String[] columnNames)
		{

			for (String name : columnNames)
				 addColumn(name);
		}

		public boolean addColumn(String columnName)
		{
			try
			{
				table.addColumn(columnName);
			} catch (IllegalArgumentException e)
			{
				return false;
			}

			return true;
		}

		public void setSquareNumberedTable(int colAndRowNr)
		{
			setNumberedTable(colAndRowNr, colAndRowNr);
		}

		public void setNumberedTable(int columnNumber, int rowNumber)
		{
			for (int i = 0; i < columnNumber; i++)
			{
				table.addColumn(Integer.toString(i));
			}

			for (int i = 0; i < rowNumber; i++)
			{
				table.addRow(Integer.toString(i));
			}
		}

		public void setWhiteSpaceCharacter(Character whiteSpaceCharacter)
		{
			table.whiteSpaceCharacter = whiteSpaceCharacter;
		}

		public void setExtraPadding(int extraPadding)
		{
			table.setExtraCellPadding(extraPadding);
		}

		public Table build()
		{

			if (table.columns.size() > 0 && table.rows.size() > 0)
			{
				table.reallocateTable();
				table.recalculateCellSizeToFitAnyStr();
				return table;
			} else
				return null;
		}
	}
}
