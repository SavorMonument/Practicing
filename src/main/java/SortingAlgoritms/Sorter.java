package SortingAlgoritms;

import java.util.Comparator;

public abstract class Sorter<T> {

    protected T[] elements;
    protected Comparator<T> comp;

    protected Sorter(T[] elements, Comparator<T> comp) {

        this.elements = elements;
        this.comp = comp;
    }

    abstract T[] sort();


    protected void swap(int i, int j){

        if (i != j) {
            T temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }

    protected  <T> T[] arrayCopy(T[] from, T[] to, int fromPos, int toPos, int amount){
        assert (from.length > (fromPos + amount)) && (to.length > (toPos + amount));

        int counter = 0;

        while (counter < amount){

            to[toPos] = from[fromPos];
            toPos++;
            fromPos++;
            counter++;
        }

        return  to;
    }

    public int numberOfElem(){
        return elements.length;
    }

    public Comparator<T> getComparator(){
        return comp;
    }

    @Override
    public abstract String toString();
}
