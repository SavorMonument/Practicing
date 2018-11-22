package tables;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table
{

	public static void main(String[] args)
	{
		final int side = 4;

		TableBuilder builder = new TableBuilder();
		builder.setSquareNumberedTable(side);
		builder.setWhiteSpaceCharacter(' ');
		builder.setPrintingStyle(PrintingStyles.OUTLINE_AROUND_ROWS);

		Table table = builder.build();

		for (int i = 0; i < side; i++)
		{
			for (int j = 0; j < side; j++)
			{
				table.addElement(Integer.toString(i), Integer.toString(j), "Hah");
			}
		}
		table.pStyle = PrintingStyles.NO_OUTLINE;
		table.print(System.out);
		table.pStyle = PrintingStyles.OUTLINE_AROUND_OUTSIDE;
		table.print(System.out);
		table.pStyle = PrintingStyles.OUTLINE_AROUND_ROWS;
		table.print(System.out);
		table.pStyle = PrintingStyles.OUTLINE_AROUND_COLUMNS;
		table.print(System.out);
		table.pStyle = PrintingStyles.OUTLINE_AROUND_EACH_CELL;
		table.print(System.out);
	}

	private PrintingStyles pStyle = PrintingStyles.NO_OUTLINE;

	private char whiteSpaceCharacter = '-';

	//Initial cell size it should get resized according to the values and padding of the table
	private int cellSize = 5;

	private List<String> columns;
	private List<String> rows;
	private String[] table;

	//Min number of whiteSpaceCharacters around the cell value
	private int extraCellPadding = 2;

	private Table()
	{
		columns = new ArrayList<>();
		rows = new ArrayList<>();
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

	public void print(PrintStream pStream)
	{
		switch (pStyle)
		{
			case NO_OUTLINE:
			{
				new NormalPrinting(pStream).print();
			}
			break;
			case OUTLINE_AROUND_EACH_CELL:
			{
				new AroundEachCellPrinting(pStream).print();
			}
			break;
			case OUTLINE_AROUND_OUTSIDE:
			{
				new AroundPrinting(pStream).print();
			}
			break;
			case OUTLINE_AROUND_COLUMNS:
			{
				new AroundEachColumnPrinting(pStream).print();
			}
			break;
			case OUTLINE_AROUND_ROWS:
			{
				new AroundEachRowPrinting(pStream).print();
			}
			break;
		}
	}

	public enum PrintingStyles
	{
		NO_OUTLINE,
		OUTLINE_AROUND_OUTSIDE,
		OUTLINE_AROUND_EACH_CELL,
		OUTLINE_AROUND_COLUMNS,
		OUTLINE_AROUND_ROWS
	}

	private enum Delimiters
	{
		NO_DELIMITER('\u0000'),
		VERTICAL('\u2503'),
		HORIZONTAL('\u2501'),
		TOP_LEFT('\u250F'),
		TOP_RIGHT('\u2513'),
		BOTTOM_LEFT('\u2517'),
		BOTTOM_RIGHT('\u251B'),
		CROSS('\u254B'),
		TRI_LEFT('\u2523'),
		TRI_TOP('\u2533'),
		TRI_RIGHT('\u252B'),
		TRI_BOTTOM('\u253B');

		char delimiter;

		Delimiters(char delimiter)
		{
			this.delimiter = delimiter;
		}
	}

	abstract class Printing
	{
		PrintStream pStream;

		Printing(PrintStream pStream)
		{
			this.pStream = pStream;
		}

		abstract void print();

		void printCell(String value)
		{
			printCell(value, whiteSpaceCharacter);
		}

		void printCell(String value, char whiteSpace)
		{
			int leftPadding = (int) Math.floor(((float) (cellSize - value.length())) / 2);
			int rightPadding = (int) Math.ceil(((float) (cellSize - value.length())) / 2);

			printChars(leftPadding, whiteSpace);
			System.out.print(value);
			printChars(rightPadding, whiteSpace);
		}

		void printChars(int times, char c)
		{
			for (int i = 0; i < times; i++)
			{
				if (c != Delimiters.NO_DELIMITER.delimiter)
					pStream.print(c);
			}
		}

		void printValuesAsCells(List<String> values, char startC, char endC,
								char whiteSpaceC, char delimiterC)
		{
			printChars(1, startC);
			for (int i = 0; i < values.size(); i++)
			{
				printCell(values.get(i), whiteSpaceC);
				if (i != values.size() - 1)
					printChars(1, delimiterC);
			}
			printChars(1, endC);
			printChars(1, '\n');
		}

		void printEmptyCells(int nrOfCells, char startC, char endC,
							 char whiteSpaceC, char delimiterC)
		{
			printChars(1, startC);
			for (int i = 0; i < nrOfCells; i++)
			{
				printCell("", whiteSpaceC);
				if (i != nrOfCells - 1)
					printChars(1, delimiterC);
			}
			printChars(1, endC);
			printChars(1, '\n');
		}

		<T> List<T> addIntoList(List<T> valueList, T[] valueArray, int start, int end)
		{
			assert (start > 0 && start < valueArray.length) : "Invalid start";
			assert (end > start && end < valueArray.length) : "Invalid end";

			for (int i = start; i < end; i++)
			{
				valueList.add(valueArray[i]);
			}

			return valueList;
		}
	}

	class NormalPrinting extends Printing
	{

		NormalPrinting(PrintStream pStream)
		{
			super(pStream);
		}

		void print()
		{
			printColumnNames(pStream);
			for (int i = 0; i < rows.size(); i++)
			{
				String rowName = rows.get(i);
				printCell(rowName);
				printRowValues(pStream, i);
			}
		}

		private void printColumnNames(PrintStream pStream)
		{
			//Top left empty cell
			printCell("");
			for (String columnName : columns)
			{
				printCell(columnName);
			}
			System.out.print("\n");
		}

		private void printRowValues(PrintStream pStream, int rowIndex)
		{
			int startValues = columns.size() * rowIndex;

			for (int j = startValues; j < startValues + columns.size(); j++)
			{
				printCell(table[j]);
			}
			System.out.print("\n");
		}
	}

	class AroundPrinting extends Printing
	{
		public AroundPrinting(PrintStream pStream)
		{
			super(pStream);
		}

		void print()
		{
			printTopCap(columns.size() + 1);

			//A list with and empty string at the beginning for top left empty cell
			List<String> OutputColumns = new ArrayList<>(columns);
			OutputColumns.add(0, "");
			printValuesAsCells(OutputColumns, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
					whiteSpaceCharacter, Delimiters.NO_DELIMITER.delimiter);

			//Constructs a list per row with the values and then prints it on screen
			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++)
			{
				List<String> perRowValues = new ArrayList<>();
				perRowValues.add(rows.get(rowIndex));

				int startValues = columns.size() * rowIndex;
				addIntoList(perRowValues, table, startValues, startValues + columns.size());

				printValuesAsCells(perRowValues, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
						whiteSpaceCharacter, Delimiters.NO_DELIMITER.delimiter);
			}
			printBottomCap(columns.size() + 1);
		}

		void printTopCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.TOP_LEFT.delimiter, Delimiters.TOP_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.NO_DELIMITER.delimiter);
		}

		void printBottomCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.BOTTOM_LEFT.delimiter, Delimiters.BOTTOM_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.NO_DELIMITER.delimiter);
		}
	}

	class AroundEachCellPrinting extends Printing
	{
		AroundEachCellPrinting(PrintStream pStream)
		{
			super(pStream);
		}

		void print()
		{
			printTopCap(columns.size() + 1);

			//A list with and empty string at the beginning for top left empty cell
			List<String> OutputColumns = new ArrayList<>(columns);
			OutputColumns.add(0, "");
			printValuesAsCells(OutputColumns, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
					whiteSpaceCharacter, Delimiters.VERTICAL.delimiter);

			//Constructs a list per row with the values and then prints it on screen
			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++)
			{
				printEmptyCells(columns.size() + 1, Delimiters.TRI_LEFT.delimiter, Delimiters.TRI_RIGHT.delimiter,
						Delimiters.HORIZONTAL.delimiter, Delimiters.CROSS.delimiter);

				List<String> perRowValues = new ArrayList<>();
				perRowValues.add(rows.get(rowIndex));

				int startValues = columns.size() * rowIndex;
				addIntoList(perRowValues, table, startValues, startValues + columns.size());

				printValuesAsCells(perRowValues, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
						whiteSpaceCharacter, Delimiters.VERTICAL.delimiter);
			}
			printBottomCap(columns.size() + 1);
		}

		void printTopCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.TOP_LEFT.delimiter, Delimiters.TOP_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.TRI_TOP.delimiter);
		}

		void printBottomCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.BOTTOM_LEFT.delimiter, Delimiters.BOTTOM_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.TRI_BOTTOM.delimiter);
		}
	}

	class AroundEachColumnPrinting extends Printing
	{
		AroundEachColumnPrinting(PrintStream pStream)
		{
			super(pStream);
		}

		void print()
		{
			printTopCap(columns.size() + 1);

			//A list with and empty string at the beginning for top left empty cell
			List<String> OutputColumns = new ArrayList<>(columns);
			OutputColumns.add(0, "");
			printValuesAsCells(OutputColumns, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
					whiteSpaceCharacter, Delimiters.VERTICAL.delimiter);

			//Constructs a list per row with the values and then prints it on screen
			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++)
			{
				List<String> perRowValues = new ArrayList<>();
				perRowValues.add(rows.get(rowIndex));

				int startValues = columns.size() * rowIndex;
				addIntoList(perRowValues, table, startValues, startValues + columns.size());

				printValuesAsCells(perRowValues, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
						whiteSpaceCharacter, Delimiters.VERTICAL.delimiter);
			}
			printBottomCap(columns.size() + 1);
		}

		void printTopCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.TOP_LEFT.delimiter, Delimiters.TOP_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.TRI_TOP.delimiter);
		}

		void printBottomCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.BOTTOM_LEFT.delimiter, Delimiters.BOTTOM_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.TRI_BOTTOM.delimiter);
		}
	}

	class AroundEachRowPrinting extends Printing
	{
		AroundEachRowPrinting(PrintStream pStream)
		{
			super(pStream);
		}

		void print()
		{
			printTopCap(columns.size() + 1);

			//A list with and empty string at the beginning for top left empty cell
			List<String> OutputColumns = new ArrayList<>(columns);
			OutputColumns.add(0, "");
			printValuesAsCells(OutputColumns, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
					whiteSpaceCharacter, Delimiters.NO_DELIMITER.delimiter);

			//Constructs a list per row with the values and then prints it on screen
			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++)
			{
				printEmptyCells(columns.size() + 1, Delimiters.TRI_LEFT.delimiter, Delimiters.TRI_RIGHT.delimiter,
						Delimiters.HORIZONTAL.delimiter, Delimiters.NO_DELIMITER.delimiter);

				List<String> perRowValues = new ArrayList<>();
				perRowValues.add(rows.get(rowIndex));

				int startValues = columns.size() * rowIndex;
				addIntoList(perRowValues, table, startValues, startValues + columns.size());

				printValuesAsCells(perRowValues, Delimiters.VERTICAL.delimiter, Delimiters.VERTICAL.delimiter,
						whiteSpaceCharacter, Delimiters.NO_DELIMITER.delimiter);
			}
			printBottomCap(columns.size() + 1);
		}

		void printTopCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.TOP_LEFT.delimiter, Delimiters.TOP_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.NO_DELIMITER.delimiter);
		}

		void printBottomCap(int nrOfValues)
		{
			printEmptyCells(nrOfValues, Delimiters.BOTTOM_LEFT.delimiter, Delimiters.BOTTOM_RIGHT.delimiter,
					Delimiters.HORIZONTAL.delimiter, Delimiters.NO_DELIMITER.delimiter);
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

		public void setPrintingStyle(PrintingStyles pStyle)
		{
			table.pStyle = pStyle;
		}

		public void setWhiteSpaceCharacter(char whiteSpaceCharacter)
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
