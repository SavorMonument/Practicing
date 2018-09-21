package IMultiCoreProc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MulticoreProcessingTest {

    MulticoreProcessing mProcessing = new MulticoreProcessing();

    @Test
    public void test0(){

        long jobLength = 2000;
        int corePenalty = 5;
        int[] speed = {40, 20};
        int[] cores = {2, 4};

        int expected = 30;

        assertEquals(expected, mProcessing.fastestTime(jobLength, corePenalty, speed, cores));
    }

    @Test
    public void test1(){

        long jobLength = 2000;
        int corePenalty = 5;
        int[] speed = {10, 20};
        int[] cores = {2, 4};

        int expected = 40;

        assertEquals(expected, mProcessing.fastestTime(jobLength, corePenalty, speed, cores));
    }

    @Test
    public void test2(){

        long jobLength = 1000;
        int corePenalty = 0;
        int[] speed = {10};
        int[] cores = {3};

        int expected = 34;

        assertEquals(expected, mProcessing.fastestTime(jobLength, corePenalty, speed, cores));
    }

    @Test
    public void test3(){

        long jobLength = 10000;
        int corePenalty = 5;
        int[] speed = {39, 37, 44};
        int[] cores = {8, 16, 6};

        int expected = 63;

        assertEquals(expected, mProcessing.fastestTime(jobLength, corePenalty, speed, cores));
    }

}