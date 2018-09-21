package IVector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.*;

public class MyVectorTest {

    MyVector<Integer> vec;

    @Before
    public void setUp() throws Exception {

        vec = new MyVector<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void tempVectorRefrence(){

        Vector<Integer> vec = new Vector<>();

        vec.add(10);

    }

    @Test
    public void add(){

        vec.add(5);

        assert (vec.at(0) == 5);
    }

    @Test
    public void add_WithIndex(){

        vec.add(4);
        vec.add(5, 0);

        assert (vec.at(0) == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_WithGap(){

        vec.add(3);
        vec.add(10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_OnNegativeIndex(){

        vec.add(5, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void at_InvalidIndex(){

        vec.at(vec.size());
    }

    @Test
    public void isEmpty_OnAnEmptyVector(){

        assert (vec.isEmpty());
    }

    @Test
    public void isEmpty(){

        vec.add(3);

        assert (!vec.isEmpty());
    }

    @Test
    public void delete_OneElemInVec(){

        vec.add(10);
        vec.delete(0);

        assert (vec.size() == 0);
    }

    @Test
    public void delete_MultipleElem(){

        vec.add(10);
        vec.add(13);
        vec.add(120);

        vec.delete(1);

        assert (vec.at(1) == 120);
    }

    @Test
    public void delete_MultipleElem2(){

        vec.add(10);
        vec.add(13);
        vec.add(120);

        vec.delete(2);

        assert (vec.at(1) == 13);
    }

    @Test
    public void delete_MultipleElem_TestSize(){

        vec.add(10);
        vec.add(13);

        vec.delete(1);

        assert (vec.size() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_noElem(){

        vec.delete(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_IndexOutOfBounds(){

        vec.add(4);

        vec.delete(1);
    }

    @Test
    public void delete_ByObject(){

        vec.add(6);
        vec.add(5);

        vec.delete((Integer) 6);

        assert (vec.at(0) == 5);
    }

    @Test
    public void delete_ByObjectMultiple(){

        vec.add(6);
        vec.add(5);
        vec.add(6);
        vec.add(6);

        vec.delete((Integer) 6);

        assert (vec.size() == 1);
    }

    @Test
    public void delete_ShrinkTest(){

        vec.add(6);
        vec.add(6);
        vec.add(6);
        vec.add(6);
        vec.add(6);
        vec.add(6);
        vec.add(3);
        vec.add(3);

        vec.delete((Integer) 6);

        assert (vec.getCapacity() == 4);
    }

    @Test
    public void trest(){


    }

}