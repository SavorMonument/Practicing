package SortingAlgoritms;

import java.util.Comparator;

public class InsertionSort<T> extends Sorter<T>{

    public InsertionSort(T[] elements, Comparator<T> comp) {

        super(elements, comp);
    }

    @Override
    public T[] sort() {

        doSort();

        return elements;
    }

    private void doSort() {

        int i = 0;
        while (i < elements.length){

            int pos = findPlace(i);
            insert(i, pos);
            i++;
        }
    }

    private void insert(int elemIndex, int pos) {

        T temp = elements[elemIndex];
        System.arraycopy(elements, pos, elements, pos + 1, elemIndex - pos);
        elements[pos] = temp;
    }

    private int findPlace(int elemIndex) {

        int i = 0;

        while ((i < elemIndex) && (comp.compare(elements[i], elements[elemIndex]) < 0)){
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Insertion sort";
    }
}
