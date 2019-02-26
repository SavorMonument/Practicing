package SortingAlgoritms;

import tables.Table;

import java.util.Comparator;

public class SortingTests {

    private static java.lang.Integer[] generateRandomElemArray(int size, int rangeLeft, int rangeRight){

        java.lang.Integer[] elem = new java.lang.Integer[size];

        for (int i = 0; i < size; i++) {

            elem[i] = ((int)(Math.random() * (rangeRight - rangeLeft)) + rangeLeft);
        }

        return elem;
    }

    private static<T> void print(T[] elem){

        for (T e : elem) {

            System.out.println(e);
        }
    }

    public static<T> void InsertionSortTest(T[] elements, Comparator<T> comparator){

        Sorter<T> insertionS = new InsertionSort<>(elements, comparator);

        insertionS.sort();
    }


    public static<T> void QuickSortTest(T[] elements, Comparator<T> comparator){

        Sorter<T> quickS = new QuickSort<>(elements, comparator);

        quickS.sort();
    }

    public static<T> void MergeSortTest(T[] elements, Comparator<T> comparator){

        Sorter<T> mergeS = new MergeSort<>(elements, comparator);

        mergeS.sort();
    }

    public static<T> void BubbleSortTest(T[] elements, Comparator<T> comparator){

        Sorter<T> bubbleS = new BubbleSort<>(elements, comparator);

        bubbleS.sort();
    }

    public static<T> String sortAndGetTime(Sorter<T> sorter){

        double time = System.nanoTime();

        sorter.sort();

        return String.format("%.2f", ((System.nanoTime() - time) / 1e+9));
    }

    private static <T> void sortAndPopulate(Table table, Sorter<T> sorter){

        sorter.sort();
//        table.addColumn(sorter.toString());
        table.addElement("Nr of elem", sorter.toString(), sorter.numberOfElem());
        table.addElement("Comparisons", sorter.toString(), ((IntegerComparator)sorter.getComparator()).getCounter());
        table.addElement("Time", sorter.toString(), 0);
    }

    private static <T> void sortAndPopulateThreaded(Table table, Sorter<T> sorter){

        Thread sortT = new Thread(new Runnable() {
            @Override
            public void run() {
                long now = System.nanoTime();
                sorter.sort();
                int timeMs = (int)((now - System.nanoTime()) / 1e+6);
//                table.addColumn(sorter.toString());
                table.addElement("Nr of elem", sorter.toString(), sorter.numberOfElem());
                table.addElement("Comparisons", sorter.toString(), ((IntegerComparator)sorter.getComparator()).getCounter());
                table.addElement("Time", sorter.toString(), timeMs + "ms");
            }
        });

        sortT.start();
    }

    private static Integer[] getElemCopy(Integer[] generatedElem){

        Integer[] elem = new Integer[generatedElem.length];
        System.arraycopy(generatedElem, 0, elem, 0, generatedElem.length);
        
        return elem;
    }

    public static void main(String[] args) {

        int numberOfElem = 20;
        Integer[] generatedArray = generateRandomElemArray(numberOfElem, 0, 100);

//        Table table = new Table();
//        table.addRow("Nr of elem")
//             .addRow("Comparisons")
//             .addRow("Time");

//        sortAndPopulateThreaded(table, new BubbleSort<>(getElemCopy(generatedArray), new IntegerComparator()));
//        sortAndPopulateThreaded(table, new InsertionSort<>(getElemCopy(generatedArray), new IntegerComparator()));
//        sortAndPopulateThreaded(table, new MergeSort<>(getElemCopy(generatedArray), new IntegerComparator()));
//        sortAndPopulateThreaded(table, new QuickSort<>(getElemCopy(generatedArray), new IntegerComparator()));
//        sortAndPopulateThreaded(table, new QuickSortMidPivot<>(getElemCopy(generatedArray), new IntegerComparator()));

//        Sorter<Integer> sorter = new QuickSortMidPivot<>(getElemCopy(generatedArray), new IntegerComparator());
//        Integer[] elem =  sorter.sort();
//
//        for (Integer i: elem){
//
//            System.out.print(i + " ");
//        }

//        table.addColumn("Za");
//        table.addElement("Nr of elem", "Za", 54);
//        table.addElement("Comparisons", "Za", 1234);
//        table.addElement("Time", "Za", 14);
//
//        table.print();
//        while (true) {
//            if ((System.nanoTime() / 1e+9) % 2 == 0) {
//                table.print();
//            }
//        }

    }

    private static boolean isSorted(Integer[] arr){


        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1])
                return false;

        }

        return true;
    }


}