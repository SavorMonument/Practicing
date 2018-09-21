package LinkedListsProblems;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MiddleOnePassTest {

    @Test
    public void findMiddleOdd(){

        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(Integer.valueOf(3), MiddleOnePass.findMiddle(list));
    }

    @Test
    public void findMiddleEven(){

        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals(Integer.valueOf(3), MiddleOnePass.findMiddle(list));
    }
}