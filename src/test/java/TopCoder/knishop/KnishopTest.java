package TopCoder.knishop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnishopTest {

    Knishop kShop;

    @Before
    public void SetUp(){
    }



    @Test
    public void getShortestPathTest1(){

        kShop = new Knishop(0, 0);

        assertEquals(new Integer(2), kShop.getShortestPath(2, 3));
    }

    @Test
    public void getShortestPathTest2(){

        kShop = new Knishop(5, 2);

        assertEquals(new Integer(1), kShop.getShortestPath( 7, 0));
    }

    @Test
    public void getShortestPathTest3(){

        kShop = new Knishop(918273645, 987654321);

        assertEquals(new Integer(3), kShop.getShortestPath( 123456789, 123456798));
    }

    @Test
    public void getShortestPathTest4(){

        kShop = new Knishop(42, 47);

        assertEquals(new Integer(0), kShop.getShortestPath( 42, 47));
    }

    @Test
    public void getShortestPathTest5(){

        kShop = new Knishop(10, 10);

        assertEquals(new Integer(2), kShop.getShortestPath(14, 8));
    }
}