package IVector;

import java.util.Arrays;

public class MyVector<T> {

    private final int INCREMENT = 8;
    private int capacity = 8;
    private int length = 0;
    private T[] vec;

    public MyVector() {

        vec = (T[]) new Object[capacity];
    }

    public void delete(T elem){

        for (int i = 0; i < size(); i++){

            if (vec[i].equals(elem)) {
                delete(i);
                i--;
            }
        }
    }

    public void delete(int index){

        if ((index < 0) || (index >= size()))
            throw new IllegalArgumentException(String.format("Index out of bounds, index: %d, Size: %d", index, size()));

        if ((size() > 1) && (index < size() - 1))
            moveElementsToTheLeft(index);

        length--;
        shrinkIfNeeded();
    }

    private void shrinkIfNeeded(){

        if ((capacity / 4) < length)
            return;

        capacity = capacity / 2;
        T[] shrankVec = (T[]) new Object[capacity];

        vec = arrayCopy(vec, shrankVec);
    }

    public T at(int index){

        if ((index < 0) || (index >= size()))
            throw new IllegalArgumentException(String.format("Index out of bounds, index: %d, Size: %d", index, size()));

        return vec[index];
    }

    public int getCapacity() {

        return capacity;
    }

    public boolean isEmpty() {

        return size() == 0;
    }

    public int size() {

        return length;
    }
    
    public void add(T elem){

        add(elem, size());
    }

    public void add(T elem, int index){

        if ((index < 0) || (index > size()))
            throw new IllegalArgumentException(String.format("Index out of bounds, index: %d, Size: %d", index, size()));

        if (emptySlots() < 1)
            vec = expandVectorAndCalculateCapacity(1);

        if (index < size())
            moveElementsToTheRight(index, 1);

        length++;

        vec[index] = elem;
    }

    private void moveElementsToTheLeft(int index){
        assert ((index >= 0) && (index < size() - 1) && (size() > 1));

        for (int i = index; i < size() - 1; i++){
            vec[i] = vec[i + 1];
        }
    }
    
    private void moveElementsToTheRight(int index, int moveAmount){
        assert (index >= 0) && (index < size());

        for (int i = index; i < size(); i++){
            vec[i + moveAmount] = vec[i];
        }
    }

    private T[] expandVectorAndCalculateCapacity(int slotsNeeded) {
        assert  (slotsNeeded > emptySlots());

        capacity = calculateCapacity(slotsNeeded);
        T[] expandedVec = (T[]) new Object[capacity];

        vec = arrayCopy(vec, expandedVec);

        return vec;
    }

    private T[] arrayCopy(T[] copyFrom, T[] copyTo) {
        assert (copyTo.length >= size());

        for (int i = 0; i < size(); i++) {
            copyTo[i] = copyFrom[i];
        }

        return copyTo;
    }

    private int calculateCapacity(int slotsNeeded){

        slotsNeeded -= emptySlots();
        int expansionSize = slotsNeeded + (INCREMENT - (slotsNeeded % INCREMENT));

        return capacity + expansionSize;
    }

    private int emptySlots(){

        return capacity - size();
    }

    public <E> E[] getVec(E[] arr) {
        return (E[]) Arrays.copyOf(vec, length);
    }

}
