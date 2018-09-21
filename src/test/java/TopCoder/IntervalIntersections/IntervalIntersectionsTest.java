package TopCoder.IntervalIntersections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalIntersectionsTest {

    IntervalIntersections iInter;

    @Before
    public void SetUp(){

        iInter = new IntervalIntersections();
    }

    @Test
    public void testNo1(){

        int[] numbers = {3, 6, 1, 2};
        int expected = 1;
        int result = iInter.minLength(numbers[0], numbers[1], numbers[2], numbers[3]);

        assertEquals(expected, result);
    }

    @Test
    public void testNo2(){

        int[] numbers = {1, 2, 3, 6};
        int expected = 1;
        int result = iInter.minLength(numbers[0], numbers[1], numbers[2], numbers[3]);

        assertEquals(expected, result);
    }

    @Test
    public void testNo3(){

        int[] numbers = {1, 10, 2, 5};
        int expected = 0;
        int result = iInter.minLength(numbers[0], numbers[1], numbers[2], numbers[3]);

        assertEquals(expected, result);
    }

    @Test
    public void testNo4(){

        int[] numbers = {4, 5, 1, 4};
        int expected = 0;
        int result = iInter.minLength(numbers[0], numbers[1], numbers[2], numbers[3]);

        assertEquals(expected, result);
    }

    @Test
    public void testNo5(){

        int[] numbers = {1, 1, 1000000, 1000000};
        int expected = 999999;
        int result = iInter.minLength(numbers[0], numbers[1], numbers[2], numbers[3]);

        assertEquals(expected, result);
    }
}