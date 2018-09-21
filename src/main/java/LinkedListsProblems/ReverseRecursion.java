package LinkedListsProblems;

public class ReverseRecursion {

    public static void main(String[] args) {

        LinkedListT list = new LinkedListT();

        list.addAtBegin(1);
        list.addAtBegin(2);
        list.addAtBegin(3);
        list.addAtBegin(4);

        list.print();
        list.reverse();
        list.print();


    }

    public static class LinkedListT {

        public Node head;

        public LinkedListT() {
            head = null;
        }

        public void addAtBegin(int data) {
            Node n = new Node(data);
            n.next = head;
            head = n;

        }

        public void print(){

            Node printingNode = head;

            while (printingNode != null){

                System.out.print(printingNode.data + " ");
                printingNode = printingNode.next;
            }
            System.out.print("\n");
        }

        public void reverse(){

            reverse(null, head);
        }

        private void reverse(Node previous, Node current){

            Node next = current.next;
            current.next = previous;

            if (next == null)
                head = current;
            else
                reverse(current, next);
        }

        private class Node {
            public int data;
            public Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    }
}
