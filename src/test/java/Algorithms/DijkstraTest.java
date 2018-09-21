package Algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraTest {


    @Test
    public void dTest1(){

        String equation = "1 + ( ( 2 + 3 ) * ( 4 * 5 ) )";

        assertEquals(101.0, Dijkstra.solve(equation), 0.001);
    }

    @Test
    public void dTest2(){

        String equation = "( 1 + 5.0 ) / 2.0";

        assertEquals(3.0, Dijkstra.solve(equation), 0.001);
    }

}