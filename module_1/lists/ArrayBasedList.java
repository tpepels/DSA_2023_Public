package module_1.lists;

public class ArrayBasedList<E> implements ListADT<E> {

    private E[] elements; // array of E which will be used to store the elements in the list
    private int size; // size of the list
    private int N; // size of the array elements

    public ArrayBasedList() {
        // Initializes the class attributes, for an empty list in an array of 10
        // elements
        N = 10;
        elements = (E[]) new Object[N];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Support method, check if the array is full, in case increases its dimension
     * by 10 and copies all the elements from the old array
     */
    private void increaseArrayDimensionIfFull() {
        if (size == N) {
            N = N + 10;
            E[] newArray = (E[]) new Object[N];

            for (int i = 0; i < (N - 10); i++) {
                newArray[i] = elements[i];
            }

            elements = newArray;
        }
    }

    @Override
    public void insertFront(E element) {
        increaseArrayDimensionIfFull();

        // shift all the elements from the last to the first one position right
        for (int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }

        elements[0] = element;
        size = size + 1;
    }

    @Override
    public void insertBack(E element) {
        increaseArrayDimensionIfFull();

        elements[size] = element;
        size = size + 1;
    }

    @Override
    public E removeFront() {
        if (isEmpty()) { // checking if the list is empty before reading
            System.out.println("The List is empty");
            return null;
        } else {
            E firstElement = (E) elements[0]; // read the element before removing it

            // shift all the elements one position to the left
            for (int i = 0; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }

            elements[size - 1] = null; // ensures the last element is set to null.
            size = size - 1; // note that we could also set the last element to null for memory optimization

            return firstElement;
        }
    }

    @Override
    public E removeBack() {
        if (isEmpty()) { // checking if the list is empty before removing
            System.out.println("The List is empty");
            return null;
        } else {
            E lastElement = (E) elements[size - 1]; // read the element before removing it
            size = size - 1; // note that we could also set the last element to null for memory optimization
            return lastElement;
        }
    }

    @Override
    public E first() {
        if (isEmpty()) { // checking if the list is empty before reading
            System.out.println("The List is empty");
            return null;
        } else {
            return (E) elements[0];
        }
    }

    @Override
    public E last() {
        if (isEmpty()) { // checking if the list is empty before reading
            System.out.println("The List is empty");
            return null;
        } else {
            return (E) elements[size - 1];
        }
    }

    @Override
    public E get(int index) {
        if (isEmpty()) { // checking if the list is empty before reading
            System.out.println("The List is empty");
            return null;
        } else if (index >= size) { // checking if the index is valid before reading
            System.out.println("The List only has " + size + " elements");
            return null;
        } else {
            return (E) elements[index];
        }
    }

    @Override
    public int size() {
        return size;
    }

}
