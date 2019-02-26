package IMergeSort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sort(){

        int arr[] = {44, 62, 13, 5, 1, 90, 46, 4};
        int expected[] = {1, 4, 5, 13, 44, 46, 62, 90};

        MergeSort.sort(arr, 0, arr.length - 1);

//        assert(Arrays.compare(expected, arr) == 0);
    }
}