package Algorithms;

public class Steque {

    private Node start = null;
    private Node end = null;

    public void push(int value){

        if (size() == 0){
            start = new Node(value);
            end = start;
        } else {

            Node temp = new Node(value);
            temp.next = start;
            start.previous = temp;
            start = temp;
        }
    }

    public int pop(){

        if (size() == 0)
            throw new IllegalStateException("No elements");

        int value = start.value;
        Node temp = start.next;

        if (null != start.next) {
            start.next = null;
            temp.previous = null;
        }
        start = temp;

        return value;
    }

    public void enqueue(int value){

        if (size() == 0) {
            push(value);
        }

        Node temp = new Node(value);

        temp.previous = end;
        end.next = temp;
        end = temp;
    }

    public int size(){

        if (null == start){
            return 0;
        }

        int count = 1;
        Node temp = start;

        while (null != temp.next){
            temp = temp.next;
            count += 1;
        }
        return count;
    }

    private class Node{

        Node next = null;
        Node previous = null;
        int value;

        public Node(int value) {

            this.value = value;
        }
    }

}
