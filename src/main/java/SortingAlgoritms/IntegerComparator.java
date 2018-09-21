package SortingAlgoritms;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {


    private int counter = 0;

    @Override
    public int compare(Integer o1, Integer o2) {

        counter++;
        return Integer.compare(o1, o2);
    }

    public int getCounter() {
        return counter;
    }
}
