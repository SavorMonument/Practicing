package TopCoder.ArmySize;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArmySizeTest {

    ArmySize aSize;

    @Before
    public void SetUp(){

        aSize = new ArmySize();
    }

    @Test
    public void getSumTest1(){

        String[] givenQ = new String[] {"Lots", "Lots"};
        String[] expectedQ = new String[] {"Lots", "Horde"};
        String[] result = aSize.getSum(givenQ);

        Arrays.sort(expectedQ);
        Arrays.sort(result);

        assert(Arrays.equals(expectedQ, result));
    }

    @Test
    public void getSumTest2(){

        String[] givenQ = new String[] {"Throng", "Few", "Few"};
        String[] expectedQ = new String[] {"Throng", "Swarm"};
        String[] result = aSize.getSum(givenQ);

        Arrays.sort(expectedQ);
        Arrays.sort(result);

        assert(Arrays.equals(expectedQ, result));
    }

    @Test
    public void getSumTest3(){

        String[] givenQ = new String[] {"Few", "Few", "Few", "Few", "Several"};
        String[] expectedQ = new String[] {"Several", "Pack", "Lots"};
        String[] result = aSize.getSum(givenQ);

        Arrays.sort(expectedQ);
        Arrays.sort(result);

        assert(Arrays.equals(expectedQ, result));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getSumTest_InvalidQualifier(){

        String[] givenQ = new String[] {"Fe", "Few", "Few", "Few", "Several"};

        aSize.getSum(givenQ);
    }
}