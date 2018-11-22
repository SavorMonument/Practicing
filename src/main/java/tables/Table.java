package tables;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table
{
	//Testing purposes DELETE
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
		new ScreenOutput(pStream).print(pStyle);
	}

	public enum PrintingStyles
	{
		NO_OUTLINE
				{
					char getDelimiter(Delimiter delimiter)
					{
						return Delimiter.NO_DELIMITER.theChar;
					}
				},
		OUTLINE_AROUND_OUTSIDE
				{
					char getDelimiter(Delimiter delimiter)
					{
						switch (delimiter)
						{
							case CROSS:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_TOP:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_RIGHT:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_LEFT:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_BOTTOM:
								return Delimiter.NO_DELIMITER.theChar;
							case HORIZONTAL_INSIDE:
								return Delimiter.NO_DELIMITER.theChar;
							case VERTICAL_INSIDE:
								return Delimiter.NO_DELIMITER.theChar;
							default:
								return delimiter.theChar;
						}
					}
				},
		OUTLINE_AROUND_EACH_CELL
				{
					char getDelimiter(Delimiter delimiter)
					{
						return delimiter.theChar;
					}
				},
		OUTLINE_AROUND_COLUMNS
				{
					char getDelimiter(Delimiter delimiter)
					{
						switch (delimiter)
						{
							case CROSS:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_RIGHT:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_LEFT:
								return Delimiter.NO_DELIMITER.theChar;
							case HORIZONTAL_INSIDE:
								return Delimiter.NO_DELIMITER.theChar;
							default:
								return delimiter.theChar;
						}
					}
				},
		OUTLINE_AROUND_ROWS
				{
					char getDelimiter(Delimiter delimiter)
					{
						switch (delimiter)
						{
							case CROSS:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_TOP:
								return Delimiter.NO_DELIMITER.theChar;
							case TRI_BOTTOM:
								return Delimiter.NO_DELIMITER.theChar;
							case VERTICAL_INSIDE:
								return Delimiter.NO_DELIMITER.theChar;
							default:
								return delimiter.theChar;
						}
					}
				};

		abstract char getDelimiter(Delimiter delimiter);
	}

	private enum Delimiter
	{
		NO_DELIMITER('\u0000'),
		VERTICAL_INSIDE('\u2503'),
		VERTICAL_OUTSIDE('\u2503'),
		HORIZONTAL_INSIDE('\u2501'),
		HORIZONTAL_OUTSIDE('\u2501'),
		TOP_LEFT('\u250F'),
		TOP_RIGHT('\u2513'),
		BOTTOM_LEFT('\u2517'),
		BOTTOM_RIGHT('\u251B'),
		CROSS('\u254B'),
		TRI_LEFT('\u2523'),
		TRI_TOP('\u2533'),
		TRI_RIGHT('\u252B'),
		TRI_BOTTOM('\u253B');

		char theChar;

		Delimiter(char delimiter)
		{
			this.theChar = delimiter;
		}

		public void setTheChar(char theChar)
		{
			this.theChar = theChar;
		}
	}

	class ScreenOutput
	{
		PrintStream pStream;

		public ScreenOutput(PrintStream pStream)
		{
			this.pStream = pStream;
		}

		void print(PrintingStyles style)
		{
			printTopCap(columns.size() + 1, style);

			//A list with the column names and an empty string at the beginning for top left empty cell
			List<String> OutputColumns = new ArrayList<>(columns);
			OutputColumns.add(0, "");
			printValuesInCells(OutputColumns, style.getDelimiter(Delimiter.VERTICAL_OUTSIDE),
					style.getDelimiter(Delimiter.VERTICAL_OUTSIDE), whiteSpaceCharacter,
					style.getDelimiter(Delimiter.VERTICAL_INSIDE));

			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++)
			{
				//If an empty line between values is needed to construct the boxes print it
				if (style == PrintingStyles.OUTLINE_AROUND_EACH_CELL || style == PrintingStyles.OUTLINE_AROUND_ROWS)
					printEmptyCells(columns.size() + 1,
							style.getDelimiter(Delimiter.TRI_LEFT),
							style.getDelimiter(Delimiter.TRI_RIGHT),
							style.getDelimiter(Delimiter.HORIZONTAL_INSIDE),
							style.getDelimiter(Delimiter.CROSS));

				//Constructs a list per row with the values and then print it on screen as cells
				List<String> perRowValues = new ArrayList<>();
				perRowValues.add(rows.get(rowIndex));

				int startValues = columns.size() * rowIndex;
				addIntoList(perRowValues, table, startValues, startValues + columns.size());

				printValuesInCells(perRowValues, style.getDelimiter(Delimiter.VERTICAL_OUTSIDE),
						style.getDelimiter(Delimiter.VERTICAL_OUTSIDE), whiteSpaceCharacter,
						style.getDelimiter(Delimiter.VERTICAL_INSIDE));
			}
			printBottomCap(columns.size() + 1, style);
		}

		void printTopCap(int nrOfValues, PrintingStyles style)
		{
			printEmptyCells(nrOfValues, style.getDelimiter(Delimiter.TOP_LEFT),
					style.getDelimiter(Delimiter.TOP_RIGHT),
					style.getDelimiter(Delimiter.HORIZONTAL_OUTSIDE),
					style.getDelimiter(Delimiter.TRI_TOP));
		}

		void printBottomCap(int nrOfValues, PrintingStyles style)
		{
			printEmptyCells(nrOfValues, style.getDelimiter(Delimiter.BOTTOM_LEFT),
					style.getDelimiter(Delimiter.BOTTOM_RIGHT),
					style.getDelimiter(Delimiter.HORIZONTAL_OUTSIDE),
					style.getDelimiter(Delimiter.TRI_BOTTOM));
		}

		void printValuesInCells(List<String> values, char startC, char endC,
								char whiteSpaceC, char horizontalCellDelimiterC)
		{
			printChars(1, startC);
			for (int i = 0; i < values.size(); i++)
			{
				printCell(values.get(i), whiteSpaceC);
				if (i != values.size() - 1)
					printChars(1, horizontalCellDelimiterC);
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
				if (c != Delimiter.NO_DELIMITER.theChar)
					pStream.print(c);
			}
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
