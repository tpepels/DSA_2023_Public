package module1.lists;

public class SingleLinkedList<E> implements ListADT<E> {

    // ==== Implementation without lastElement reference ==== //

    private Node<E> firstNode;
    private int size;

    public SingleLinkedList(){
        // Initialization for an empty list
        firstNode = null;
        size = 0;
    }
    

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public void insertFront(E element) {
        Node<E> newNode = new Node<E>(element, firstNode);
        firstNode = newNode;
        size = size + 1;
    }

    /**
     * Support method which returns the reference of the last node in the list starting from the Node currentnode, passed as argument
     * @param currentNode first node of the list we want to find the last node
     * @return the reference of the last node in the list
     */
    private Node<E> findLastNode(Node<E> currentNode){
        if(currentNode==null){ // Base case 1: if the list in input is empty, there is no last node
            return null;
        }
        if(currentNode.getNext()==null){ // Base case 2: if the list only has one element, this is the last node
            return currentNode;
        }
        return findLastNode(currentNode.getNext()); // Recursive call: if the list has more than one element, the last node is in the list starting from the next node
    }

    @Override
    public void insertBack(E element) {
        if(isEmpty()){      // if the list is empty, we insert in the front
            insertFront(element);
        }else{              // if the list is not empty, we find the last node and append the new element to it
            Node<E> lastNode = findLastNode(firstNode);
            Node<E> newNode = new Node<E>(element, null);
            lastNode.setNext(newNode);
            size = size + 1;
        }

    }

    @Override
    public E removeFront() {
        if(isEmpty()){      // if the list is empty, we cannot remove
            System.out.println("The list is empty");
            return null;
        }else{
            E element = firstNode.getElement();  // we read the first element before we remove it
            firstNode = firstNode.getNext();  // update first element
            size = size - 1;
            return element;
        }
    }

    /**
     * Support method which returns the reference of the second-to-last node in the list starting from the Node currentnode, passed as argument
     * @param currentNode first node of the list we want to find the second-to-last node
     * @return the reference of the second-to-last node in the list
     */ 
    private Node<E> findSecondToLastNode(Node<E> currentNode){
        if(currentNode==null){ // Base case 1: if the list in input is empty, there is no second-to-last node
            return null;
        }
        if(currentNode.getNext()==null){ // Base case 2: if the list only has one element, there is no second-to-last node
            return currentNode;
        } 
        if(currentNode.getNext().getNext()==null){ // Base case 3: if the list only has two elements, this is the second-to-last node
            return currentNode;
        }
        return findSecondToLastNode(currentNode.getNext()); // Recursive call: if the list has more than two elements, the second-to-last node is in the list starting from the next node
    }

    @Override
    public E removeBack() {
        if(isEmpty()){ // if the list is empty, we cannot remove
            System.out.println("The list is empty");
            return null;
        }else if(size==1){ // if the list has only one element, the first element is the last, we can remove it
            return removeFront();
        }else{
            Node<E> secondToLastNode = findSecondToLastNode(firstNode);  // we find the second-to-last element, note that the list has for sure at least 2 elements here
            E element = secondToLastNode.getNext().getElement();            // we read the last element value before we remove it, to return it
            secondToLastNode.setNext(null);                            // we remove the last element
            size = size - 1;
            return element;
        }
    }

    @Override
    public E first() {
        if(isEmpty()){ // if the list is empty, we cannot read
            System.out.println("The list is empty");
            return null;
        }else{
            return firstNode.getElement();
        }
    }

    @Override
    public E last() {
        if(isEmpty()){ // if the list is empty, we cannot read
            System.out.println("The list is empty");
            return null;
        }else{
            return findLastNode(firstNode).getElement();
        }
    }

    /**
     * Support method which finds the element at index indexToFind in the list starting at the Node currentNode, which has index currentIndex.
     * The method should be called on the firstElement of the list, passing 0 as currentIndex, and with a valid indexToFind.
     * The correctness of the indexToFind value is not checked.
     * @param currentNode
     * @param currentIndex
     * @param indexToFind
     * @return
     */
    private E findIndexElement(Node<E> currentNode, int currentIndex, int indexToFind){
        if(currentIndex==indexToFind){ // Base case: if the currentIndex is the indexToFind, we return the element
            return currentNode.getElement();
        }else{
            return findIndexElement(currentNode.getNext(), currentIndex+1, indexToFind); // Recursive call: if not, the indexToFind is in the list starting from the next Node, for which we also update the currentIndex
        }
    }

    @Override
    public E get(int index) {
        if(isEmpty()){ // if the list is empty, we cannot read
            System.out.println("The List is empty");
            return null;
        }else if(index<0){  // if the index is not valid we signal an error
            System.out.println("The index is not valid");
            return null;
        }else if(index >= size){  // if the index is not valid we signal an error
            System.out.println("The List only has " + size + " elements");
            return null;
        }else{  // if the index is valid we can read the corresponding element
            return findIndexElement(firstNode, 0, index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Support method, create a String representation of the list, of the form " -> e_1 -> e_2 -> ... -> e_n -> null"
     * @param currentNode first node of the list we want to convert into a String 
     * @return the String representation of the list
     */
    private String createStringForList(Node<E> currentNode){
        if(currentNode==null){ // Base case: if the list is empty, the String representation is a pointer to null
            return " -> null";
        }else{
            return " -> "+ currentNode.getElement() + createStringForList(currentNode.getNext()); // Recursive call: if the list is not empty, we crate the string for it, reading the value of the element and appending the string obtained for the list staring from the next node
        }
    }

    @Override
    public String toString() {
        return createStringForList(firstNode);
    }
    
}
