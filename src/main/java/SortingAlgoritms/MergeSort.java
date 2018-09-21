package SortingAlgoritms;

import java.util.Comparator;

public class MergeSort<T> extends Sorter<T> {

    public MergeSort(T[] elements, Comparator comp) {

        super(elements, comp);
    }

    public T[] sort(){

        doSort(0, elements.length - 1);

        return (T[])elements;
    }

    private void doSort(int left, int right) {

        if (left < right){

            int midPoint = (right + left) / 2;

            doSort(left, midPoint);
            doSort(midPoint + 1, right);

            merge(left, right, midPoint + 1);
        }
    }

    private void merge(int left, int right, int midPoint){

        int leftLength = midPoint - left;
        int rightLength = right - midPoint + 1;

        T[] leftElements = (T[])(new Object[leftLength]);
        T[] rightElements = (T[])(new Object[rightLength]);

        arrayCopy(elements, leftElements, left, 0, leftLength);
        arrayCopy(elements, rightElements, midPoint, 0, rightLength);

        int leftIndex = 0;
        int rightIndex = 0;
        int originalIndex = left;

        while ((leftIndex < leftLength) && (rightIndex < rightLength)){

            if (comp.compare(leftElements[leftIndex], (rightElements[rightIndex])) <= 0){

                elements[originalIndex] = leftElements[leftIndex];
                leftIndex++;
            } else {
                elements[originalIndex] = rightElements[rightIndex];
                rightIndex++;
            }
            originalIndex++;
        }

        for (; leftIndex < leftLength; leftIndex++) {

            elements[originalIndex] = leftElements[leftIndex];
            originalIndex++;
        }

        for (; rightIndex < rightLength; rightIndex++) {

            elements[originalIndex] = rightElements[rightIndex];
            originalIndex++;
        }
    }

    @Override
    public String toString() {
        return "Merge sort";
    }
}
