package Algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StequeTest {

    Steque sQue;

    @Before
    public void SetUp(){

         sQue = new Steque();
    }

    @Test
    public void basicStackTest1(){

        sQue.push(5);

        assertEquals(5, sQue.pop());
    }

    @Test
    public void basicStackTest2(){

        sQue.push(5);
        sQue.push(15);

        assertEquals(15, sQue.pop());
    }


    @Test(expected = IllegalStateException.class)
    public void emptyPop() {

        sQue.pop();
    }

    @Test
    public void basicQueTest1(){

        sQue.enqueue(5);

        assertEquals(5, sQue.pop());
    }

    @Test
    public void basicQueTest2(){

        sQue.enqueue(5);
        sQue.enqueue(15);

        assertEquals(5, sQue.pop());
    }
}