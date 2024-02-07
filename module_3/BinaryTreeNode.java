package module_3;

public interface BinaryTreeNode<E extends Comparable<E>> {

    /**
     * Gets the element of the node
     * 
     * @return the value of the element of the node
     */
    public E getElement();

    /**
     * Updates the value of the element of the node
     * 
     * @param element the new value to assign to the element of the node
     */
    public void setElement(E element);

    /**
     * Access the parent of the current node
     * 
     * @return the parent node of the current node. If the current node is the root,
     *         an error message
     *         is printed.
     */
    public BinaryTreeNode<E> getParent();

    /**
     * Access the left child of the current node
     * 
     * @return the left child node of the current node. If the current node doesn't
     *         have a left child,
     *         an error message is printed.
     */
    public BinaryTreeNode<E> getLeftChild();

    /**
     * Access the right child of the current node
     * 
     * @return the right child node of the current node. If the current node doesn't
     *         have a right child,
     *         an error message is printed.
     */
    public BinaryTreeNode<E> getRightChild();

    /**
     * Add a left child for the current node, containing the specified element. If
     * the current node
     * already has a left child, an error message is printed.
     */
    public void addLeftChild(E element);

    /**
     * Add a right child for the current node, containing the specified element. If
     * the current node
     * already has a right child, an error message is printed.
     */
    public void addRightChild(E element);

    /**
     * Delete the current node. If the node cannot be deleted it prints an error
     * message.
     */
    public void delete();

    /**
     * Checks if the current node has a left child.
     * 
     * @return true if the current node has a left child, false otherwise.
     */
    public boolean hasLeftChild();

    /**
     * Checks if the current node has a right child.
     * 
     * @return true if the current node has a right child, false otherwise.
     */
    public boolean hasRightChild();

}
