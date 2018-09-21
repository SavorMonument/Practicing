package SortingAlgoritms;

import java.util.Comparator;

public class QuickSort<T> extends Sorter<T> {

    public QuickSort(T[] elements, Comparator<T> comp) {

        super(elements, comp);
    }

    public T[] sort(){

        doSort(0, elements.length - 1);

        return elements;
    }

    private void doSort(int low, int high){

        if (high > low){

            int pivot = partition(low, high);

            doSort(low, pivot - 1);
            doSort(pivot + 1, high);
        }
    }

    private int partition(int low, int high) {

        T pivot = elements[high];

        int i = low;

        for (int j = low; j < high; j++) {

            if (comp.compare(elements[j], pivot) < 0){

                swap(i, j);
                i++;
            }
        }

        swap(i, high);

        return i;
    }

    @Override
    public String toString() {
        return "Quick sort";
    }
}
