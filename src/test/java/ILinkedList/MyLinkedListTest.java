package ILinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    MyLinkedList<Integer> linkedTest;

    @Before
    public void setUp() throws Exception {

        linkedTest = new MyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty(){

        assert (linkedTest.isEmpty());
    }

    @Test
    public void pushFront(){

        linkedTest.pushFront(4);
        linkedTest.pushFront(5);
        linkedTest.pushFront(6);

        assertEquals (3, linkedTest.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueAt_NegativeIndex(){

        linkedTest.elemAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueAt_BadIndex(){

        linkedTest.elemAt(1);
    }

    @Test
    public void valueAt(){

        linkedTest.pushFront(1);
        linkedTest.pushFront(2);


        System.out.println(18 >> 1);
        assertEquals(1, (int)linkedTest.elemAt(1));
    }
}