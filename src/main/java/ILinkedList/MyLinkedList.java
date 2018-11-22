package ILinkedList;

import java.util.List;

public class MyLinkedList<T> {

    private MyLinkedList<T> previous;
    private MyLinkedList<T> next;
    private int size;

    private T elem;

    public MyLinkedList() {
    }

    private MyLinkedList(T elem, MyLinkedList previous, MyLinkedList next){

        this.elem = elem;
        this.previous = previous;
        this.next = next;
    }

    public int size(){

        return size;
    }

    public boolean isEmpty(){

        return size() == 0;
    }

    public T elemAt(int index){

        return listAt(index).elem;
    }

    private MyLinkedList<T> listAt(int index){

        if ((index < 0) || (index >= size()))
            throw new IllegalArgumentException(String.format("Invalid index, index: %d, numOfNodes: %d",
                    index, size()));

        MyLinkedList<T> current = next;
        int i = 0;
        while (i != index){
            current = current.next;
            i++;
        }

        return current;
    }

    public void pushFront(T elem){

        if (size() == 0)
            next = new MyLinkedList<T>(elem, this, null);
        else {
            MyLinkedList<T> tempNext = next;
            next = new MyLinkedList<T>(elem, this, tempNext);
            tempNext.previous = next;
        }

        size += 1;
    }

    public T popFront(){

        MyLinkedList<T> tempNext = next;

        next = tempNext.next;
        next.previous = this;

        return tempNext.elem;
    }
}
