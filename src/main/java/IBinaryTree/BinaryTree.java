package IBinaryTree;

public class BinaryTree {

    private Node head;

    public void addInt(int elem){

        if (null == head)
            head = new Node().value(elem);
        else
            head.insert(elem);
    }

    public void delete(int elem){

        if (null != head)
            head.delete(elem);
    }


    public boolean contains(int elem){

        if (null == head)
            return false;
        else
            return head.contains(elem);
    }

    public void printInOrder(){

        if (null != head)
            head.print();

    }

    private class Node {

        public int value;
        public Node left;
        public Node right;

        public Node value(int value){
            this.value = value;
            return this;
        }

        public void insert(int addValue){

            if (addValue <= value){
                if (null == left)
                    left = new Node().value(addValue);
                else
                    left.insert(addValue);
            } else
                if (null == right)
                    right = new Node().value(addValue);
                else
                    right.insert(addValue);

        }

        public boolean contains(int checkV){

            if (checkV == value)
                return true;

            if ((checkV <= value) && (null != left))
                return left.contains(checkV);
            else
                if (null != right)
                    return right.contains(checkV);

            return false;
        }

        public void print(){

            if (null != left)
                left.print();

            System.out.println(value);

            if (null != right)
                right.print();
        }

        public void delete(int deleteV){

            if ((deleteV <= value) && (null != left)){
                if (deleteV == left.value){
                    if (null != left.right) {
                        Node branch = left.left;
                        left = left.right;
                        left.reinsert(branch);
                    } else{
                        left = left.left;
                    }
                } else
                    left.delete(deleteV);
            } else
                if (null != right){
                    if (deleteV == right.value){
                        if (null != right.right) {
                            Node branch = right.left;
                            right = right.right;
                            right.reinsert(branch);
                        } else {
                            right = right.left;
                        }

                    }else
                        right.delete(deleteV);
                }
        }

        private void reinsert(Node node){

            if (null == node)
                return;

            insert(node.value);

            if (null != node.left){
                reinsert(node.left);
            }

            if (null != node.right){
                reinsert(node.right);
            }
        }
    }
}
