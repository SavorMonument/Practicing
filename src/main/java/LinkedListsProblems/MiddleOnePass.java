package LinkedListsProblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MiddleOnePass {

    public static Integer findMiddle(List<Integer> list){
        assert (list.size() > 0);

        Iterator<Integer> it = list.iterator();
        Iterator<Integer> midIt = list.iterator();
        int index = 1;
        it.next();

        while (it.hasNext()){

            if ((index % 2) == 0){
                midIt.next();
            }
            it.next();
            index++;
        }

        return midIt.next();
    }
}
