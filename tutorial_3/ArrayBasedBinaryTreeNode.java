package tutorial_3;

public class ArrayBasedBinaryTreeNode<E extends Comparable<E>> implements BinaryTreeNode<E> {

    private int index;
    private ArrayBasedBinaryTree<E> myTree;

    public ArrayBasedBinaryTreeNode(int index, ArrayBasedBinaryTree<E> myTree) {
        this.index = index;
        this.myTree = myTree;
    }

    @Override
    public E getElement() {
        return myTree.getElementByIndex(index);
    }

    @Override
    public void setElement(E element) {
        myTree.setElementByIndex(element, index);
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        int parentIndex = (index - 1) / 2;
        return new ArrayBasedBinaryTreeNode<E>(parentIndex, myTree);
    }

    @Override
    public BinaryTreeNode<E> getLeftChild() {
        if(!hasLeftChild()){
            return null;
        }else{
            int leftIndex = getLeftChildIndex();
            return new ArrayBasedBinaryTreeNode<>(leftIndex, myTree);
        }
    }

    @Override
    public BinaryTreeNode<E> getRightChild() {
        if(!hasRightChild()){
            return null;
        }else{
            int rightIndex = getRightChildIndex();
            return new ArrayBasedBinaryTreeNode<>(rightIndex, myTree);
        }
    }

    @Override
    public void addLeftChild(E element) {
        if(hasLeftChild()){
            System.out.println("The node already has a left child");
        }else{
            int leftIndex = getLeftChildIndex();
            myTree.addElementByIndex(element, leftIndex);
        }
    }

    @Override
    public void addRightChild(E element) {
        if(hasRightChild()){
            System.out.println("The node already has a right child");
        }else{
            int rightIndex = getRightChildIndex();
            myTree.addElementByIndex(element, rightIndex);
        }
    }

    @Override
    public void delete() {
        if(hasLeftChild() && hasRightChild()){
            System.out.println("The node has two children and cannot be removed");
        }else{
            ArrayBasedBinaryTreeNode<E> toMove = null;
            if(hasLeftChild()){
                // we need to copy the left child in this node, then remove the left child
                toMove = (ArrayBasedBinaryTreeNode<E>) getLeftChild();
            }else if(hasRightChild()){
                toMove = (ArrayBasedBinaryTreeNode<E>) getRightChild();
            }

            if(toMove == null){
                // leaf node, we can just remove it
                myTree.removeElementByIndex(index);
            }else{
                // move the subtree starting in the child to the current node
                myTree.removeNodeAndMoveSubTree(toMove, index);
            }
        }
    }

    @Override
    public boolean hasLeftChild() {
        int leftIndex = getLeftChildIndex();
        return (myTree.isValidIndex(leftIndex) && myTree.getElementByIndex(leftIndex)!=null);
    }

    @Override
    public boolean hasRightChild() {
        int rightIndex = getRightChildIndex();
        return (myTree.isValidIndex(rightIndex) && myTree.getElementByIndex(rightIndex)!=null);
    }

    private int getLeftChildIndex(){
        return 2 * index + 1;
    }
    
    private int getRightChildIndex(){
        return 2 * index + 2;
    }

    public int getIndex() {
        return index;
    }
}
