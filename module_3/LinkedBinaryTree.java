package module_3;

public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {

    private LinkedBinaryTreeNode<E> pseudoRoot;

    public LinkedBinaryTree() {
        pseudoRoot = new LinkedBinaryTreeNode<E>(
                null, null, null, null);
    }

    @Override
    public BinaryTreeNode<E> getRoot() {
        return pseudoRoot.getLeftChild();
    }

    @Override
    public void addRoot(E element) {
        if (hasRoot()) {
            System.out.println("The tree has already a root.");
        } else {
            pseudoRoot.addLeftChild(element);
        }
    }

    @Override
    public boolean hasRoot() {
        return (getRoot() != null);
    }

    @Override
    public String toString() {
        return getStringForTree(getRoot());
    }

    private String getStringForTree(BinaryTreeNode<E> treeNode) {
        if (treeNode == null) {
            return "";
        } else {
            return getStringForTree(treeNode.getLeftChild()) +
                    treeNode.getElement() + "; " +
                    getStringForTree(treeNode.getRightChild());
        }
    }
}
