package TopCoder.BiggestDifference;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class BiggestDifferenceTest {

    @Test
    public void Test1(){

        int[] numbers = new int[]{10, 12, 4, 6, 7, 8, 9, 1};

        assertEquals(5, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test2(){

        int[] numbers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        assertEquals(-1, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test3(){

        int[] numbers = new int[]{22, 43, 1, 33, 1, 1, 1, 1};

        assertEquals(32, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test4(){

        int[] numbers = new int[]{22, 43, 1, 33, 1, 1, 1, 1, 24, 22, 1, 45, 1, 1, 100, 1, 0, 100, 1, 1, 1, 1, 1, 1};

        assertEquals(100, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test5(){

        int[] numbers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        assertEquals(-1, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test6(){

        int[] numbers = new int[80_000_000];

        assertEquals(-1, BiggestDifference.findDifference(numbers));
    }

    @Test
    public void Test7(){

        int[] numbers = generateRandomArray(80_000_000);

        BiggestDifference.findDifference(numbers);
    }

    @Test
    public void Test8(){

        int[] numbers = generateRandomArray(1_000_000);

        BiggestDifference.findDifference(numbers);
    }

    private static int[] generateRandomArray(int length){

        int[] numbers = new int[length];
        Random rng = new Random();

        for (int i = 0; i < length; i++) {

            numbers[i] = rng.nextInt(65_535);
        }

        return numbers;
    }


}