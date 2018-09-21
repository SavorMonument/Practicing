package TopCoder.HillClimber;

import org.junit.Test;

import static org.junit.Assert.*;

public class HillClimberTest {

    HillClimber hClimber = new HillClimber();

    @Test
    public void test1(){

        int[] heights = { 1, 2, 3, 2, 2 };
        int expected = 2;

        assertEquals(expected, hClimber.climb(heights));
    }

    @Test
    public void test2(){

        int[] heights = { 1, 2, 2, 3 };
        int expected = 1;

        assertEquals(expected, hClimber.climb(heights));
    }

    @Test
    public void test3(){

        int[] heights = { 1, 8, 9, 12 };
        int expected = 3;

        assertEquals(expected, hClimber.climb(heights));
    }

    @Test
    public void test4(){

        int[] heights = { 10, 4, 4, 2 };
        int expected = 0;

        assertEquals(expected, hClimber.climb(heights));
    }

    @Test
    public void test5(){

        int[] heights = { 10, 8, 4, 9, 11, 14, 15, 3, 7, 8, 10, 6 };
        int expected = 4;

        assertEquals(expected, hClimber.climb(heights));
    }

}