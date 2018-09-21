package SortingAlgoritms;

import java.util.Comparator;

public class BubbleSort <T> extends Sorter<T> {

    public BubbleSort(T[] elements, Comparator<T> comp) {

        super(elements, comp);
    }

    public T[] sort(){

        doSort();

        return elements;
    }

    private void doSort(){

        boolean isDone = false;

        while (!isDone) {

            isDone = true;
            for (int i = 0; i < elements.length - 1; i++) {
                if (comp.compare(elements[i], (elements[i + 1])) > 0){

                    swap(i, i + 1);
                    isDone = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Bubble sort";
    }
}
