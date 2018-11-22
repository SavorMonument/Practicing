package Algorithms;

public class MoveToFrontQueue1340 {

    private Node start = null;

    public MoveToFrontQueue1340() { }

    public MoveToFrontQueue1340(MoveToFrontQueue1340 que) {

        MoveToFrontQueue1340 tempQue = new MoveToFrontQueue1340();

        while (que.size() != 0){
            tempQue.push(que.pop());
        }

        while (tempQue.size() != 0){
            int tempValue = tempQue.pop();

            push(tempValue);
            que.push(tempValue);
        }
    }

    public void push(int value){

        if (size() == 0){
            start = new Node(value);
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

    public void pushFront(int value){

        int index;
        if ((index = search(value)) != -1){
            delete(index);
        }
        push(value);
    }

    public int search(int value){
        assert size() > 0 : "que empty";

        Node temp = start;
        int index = 0;

        while(null != temp && value != temp.value){
            temp = temp.next;
            index += 1;
        }

        if (null != temp)
            return index;

        return -1;
    }

    public void delete(int index){

        if (index >= size())
            throw new IllegalArgumentException("No elements at that index");

        if (index == 0)
            pop();
        else {
            Node temp = start;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            removeNode(temp);
        }
    }

    //Remove the node from que (not the first one)
    private void removeNode(Node node){
        assert null != node: "Invalid node";

        if (null != node.previous){
            node.previous.next = node.next;
        }
        if (node.next != null){
            node.next.previous = node.previous;
        }
        node.previous = null;
        node.next = null;
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

    public void stdPrint(){
        assert size() > 0 : "numOfNodes is 0";

        Node temp = start;

        while (null != temp){

            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private class Node{

        Node next = null;
        Node previous = null;
        int value;

        public Node(int value) {

            this.value = value;
        }
    }

    public static void main(String[] args) {

        MoveToFrontQueue1340 que = new MoveToFrontQueue1340();

        que.push(5);
        que.push(2);
        que.push(3);
        que.push(1);

        MoveToFrontQueue1340 notherOne = new MoveToFrontQueue1340(que);
        notherOne.pop();
        notherOne.stdPrint();
        System.out.println();
        que.stdPrint();
        //System.out.println("Index " + que.search(10));
    }
}
