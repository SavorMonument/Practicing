package SortingAlgoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {

    private Character whiteSpaceCharacter = '-';
    private List<String> columns = new ArrayList<>();
    private List<String> rows = new ArrayList<>();
    private String[] table;

    private int cellLength = 5;
    private int extraPadding = 2;

    public Table addRow(String rowName){

        rows.add(rowName);

        String[] biggerTable = generateInitializedArray(columns.size() * rows.size(), "");
        copyByColumns(table, biggerTable, columns.size(), columns.size(), rows.size() - 1);
        table = biggerTable;

        recalculateCellSizeToFitStr(rowName);

        return this;
    }

    public Table addColumn(String columnName){

        columns.add(columnName);

        String[] biggerTable = generateInitializedArray(columns.size() * rows.size(), "");
        copyByColumns(table, biggerTable, columns.size() - 1, columns.size(), rows.size());
        table = biggerTable;

        recalculateCellSizeToFitStr(columnName);

        return this;
    }

    private String[] generateInitializedArray(int size, String s){

        String[] array = new String[size];
        Arrays.fill(array, s);

        return array;
    }

    private void copyByColumns(String[] from, String[] to, int oldColumnNo, int newColumnNo, int rowNo){

        for (int i = 0; i < rowNo; i++) {

            System.arraycopy(from, i * oldColumnNo, to, i * newColumnNo, oldColumnNo);
        }
    }

    public Table addElement(String row, String column, Integer element){

        return addElement(row, column, Integer.toString(element));
    }

    public Table addElement(String row, String column, String element){
        assert (element != null);

        int columnSize = columns.size();
        int posInRow = findRow(row);
        int posInColumn = findColumn(column);

        table[posInRow * columnSize + posInColumn] = element;

        recalculateCellSizeToFitStr(element);

        return this;
    }

    private int findRow(String row){

        int rowPos;

        if  ((null == row) || (-1 == (rowPos = rows.indexOf(row))))
            throw new IllegalArgumentException("Invalid row" + row);

        return rowPos;
    }

    private int findColumn(String column){

        int columnPos;

        if  ((column == null) || (-1 == (columnPos = columns.indexOf(column))))
            throw new IllegalArgumentException("Invalid row" + column);

        return columnPos;
    }

    private void recalculateCellSizeToFitStr(String str){

        if (str.length() > cellLength - extraPadding){

            cellLength = str.length() + extraPadding;
            if (cellLength % 2 != 0)
                cellLength += 1;
        }
    }

    public void print(){

        printColumns();

        for (int i = 0; i < rows.size(); i++) {

            printStringWithPadding(rows.get(i));
            printRowValues(i);
        }

    }

    private void printRowValues(int rowNo){

        int startJ = columns.size() * rowNo;

        for (int j = startJ; j < startJ + columns.size(); j++) {

            printStringWithPadding(table[j]);
        }
        System.out.print("\n");

    }

    private void printColumns() {

        putSpaces(cellLength);
        for (int i = 0; i < columns.size(); i++) {

            printStringWithPadding(columns.get(i));
        }
        System.out.print("\n");
    }

    private void printStringWithPadding(String s){

        int leftPadding = (cellLength - s.length()) / 2;
        int rightPadding = (s.length() % 2 == 1) ? (leftPadding + 1) : leftPadding;

        putSpaces(leftPadding);
        System.out.print(s);
        putSpaces(rightPadding);
    }

    private void putSpaces(int number) {

        for (int i = 0; i < number; i++) {
                System.out.print(whiteSpaceCharacter);
        }
    }

    public void setExtraPadding(int extraPadding) {

        cellLength -= this.extraPadding;
        this.extraPadding = extraPadding;
        cellLength += extraPadding;
    }

    public void setWhiteSpaceCharacter(Character whiteSpaceCharacter) {

        this.whiteSpaceCharacter = whiteSpaceCharacter;
    }
}
