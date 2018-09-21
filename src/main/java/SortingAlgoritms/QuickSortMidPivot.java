package SortingAlgoritms;

import java.util.Comparator;

public class QuickSortMidPivot<T> extends Sorter<T> {


    public QuickSortMidPivot(T[] elements, Comparator<T> comp) {
        super(elements, comp);
    }

    @Override
    public T[] sort() {

        doSort(0, elements.length - 1);

        return elements;
    }

    private void doSort(int low, int high){

        int index = quick(low, high);

        if (low < index - 1)

            quick(low, index - 1);

        if (index < high)

            quick(index, high);
    }

    private int quick(int low, int high) {

        T pivot = elements[(low + high) / 2];

        int i = low;
        int j = high;

        while (i < j){

            while (comp.compare(elements[j], pivot) > 0)
                j--;
            while ((comp.compare(elements[i], pivot) <= 0) && (i <= j))
                i++;

            if (i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Quick sort mid pivot";
    }
}
