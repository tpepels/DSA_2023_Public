package module_1.lists;

public interface ListADT<E> {

    /**
     * Check if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Insert the element passed as argument at the first position of the list
     * 
     * @param element the element to insert in the list
     */
    public void insertFront(E element);

    /**
     * Insert the element passed as argument at the last position of the list
     * 
     * @param element the element to insert in the list
     */
    public void insertBack(E element);

    /**
     * Remove the front element of the List, returning it
     * 
     * @return the value of the first element, removed from the List
     */
    public E removeFront();

    /**
     * Remove the last element of the List, returning it
     * 
     * @return the value of the last element, removed from the List
     */
    public E removeBack();

    /**
     * Read the front element of the List, returning it
     * 
     * @return the value of the first element of the List
     */
    public E first();

    /**
     * Read the last element of the List, returning it
     * 
     * @return the value of the last element of the List
     */
    public E last();

    /**
     * Read the element at the specified position of the List, returning it
     * 
     * @param index index of the element to read
     * @return the value of the element of the List at position index
     */
    public E get(int index);

    /**
     * Retrieve the size of the list, i.e., the number of elements in the list
     * 
     * @return the size of the list
     */
    public int size();
}
