package module_3;

public class LinkedBinaryTreeNode<E extends Comparable<E>> implements BinaryTreeNode<E> {
    private E element;
    private LinkedBinaryTreeNode<E> leftChild;
    private LinkedBinaryTreeNode<E> rightChild;
    private LinkedBinaryTreeNode<E> parent;

    public LinkedBinaryTreeNode(
            E element,
            LinkedBinaryTreeNode<E> leftChild,
            LinkedBinaryTreeNode<E> rightChild,
            LinkedBinaryTreeNode<E> parent) {

        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    @Override
    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    @Override
    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    @Override
    public void addLeftChild(E element) {
        if (hasLeftChild()) {
            System.out.println("The node already has a left child");
        } else {
            leftChild = new LinkedBinaryTreeNode<E>(
                    element, null, null, this);
        }
    }

    @Override
    public void addRightChild(E element) {
        if (hasRightChild()) {
            System.out.println("The node already has a right child");
        } else {
            rightChild = new LinkedBinaryTreeNode<E>(
                    element, null, null, this);
        }
    }

    @Override
    public void delete() {
        if (hasLeftChild() && hasRightChild()) {
            System.out.println("The node has two children and cannot be deleted");
        } else {
            LinkedBinaryTreeNode<E> child = null;

            if (hasLeftChild()) {
                child = leftChild;
            } else {
                child = rightChild;
            }

            if (parent.getLeftChild() == this) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }
        }
    }

    private void setLeftChild(LinkedBinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    private void setRightChild(LinkedBinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean hasLeftChild() {
        return (leftChild != null);
    }

    @Override
    public boolean hasRightChild() {
        return (rightChild != null);
    }

}
