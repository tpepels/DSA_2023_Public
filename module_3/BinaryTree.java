package module_3;

public interface BinaryTree<E extends Comparable<E>> {

    /**
     * Access the root node of the binary tree
     * 
     * @return the root node of the binary tree
     */
    BinaryTreeNode<E> getRoot();

    /**
     * Add an element E as root node of the binary tree.
     * If the root element is already present it prints an error message.
     */
    public void addRoot(E element);

    /**
     * Check if this tree has a root or is empty.
     * 
     * @return true if the tree has a root element, false if the tree is empty.
     */
    public boolean hasRoot();
}
