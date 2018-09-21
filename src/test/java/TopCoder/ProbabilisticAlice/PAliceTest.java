package TopCoder.ProbabilisticAlice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PAliceTest {

    PAlice pAlice;

    @Before
    public void SetUp(){

        pAlice = new PAlice();
    }

    @Test
    public void computeExpectationsTest1() {

        String[] grid = new String[] {"..", ".."};


        assertEquals(0.0, pAlice.computeExpectations(grid, 1, 2), 0.01);
    }

    @Test
    public void computeExpectationsTest2() {

        String[] grid = new String[] {".T", ".."};


        assertEquals(1.0, pAlice.computeExpectations(grid, 1, 2), 0.01);
    }

    @Test
    public void computeExpectationsTest3() {

        String[] grid = new String[] {".T", ".."};


        assertEquals(0.021739130434782705, pAlice.computeExpectations(grid, 46, 47), 0.01);
    }

    @Test
    public void computeExpectationsTest4() {

        String[] grid = new String[] {".....T.", "....T..", "T..T..."};


        assertEquals(-1.0, pAlice.computeExpectations(grid, 2, 3), 0.01);
    }

    @Test
    public void computeExpectationsTest5() {

        String[] grid = new String[] {"....T.", "...TT.", ".T....", "...T..", "......"};


        assertEquals(5.417334860633832, pAlice.computeExpectations(grid, 3, 7), 0.01);
    }
}