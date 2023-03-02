package tutorial_3;

public class ArrayBasedBinaryTree<E extends Comparable<E>>  implements BinaryTree<E>{
    private int N; // size of the array of elements
    Object[] elements; // array of elements
    private int size; // number of elements in the tree

    public ArrayBasedBinaryTree(){
        // initializes an empty tree
        N = 8; // size of the array of elements
        elements = new Object[N];
        size = 0;
    }
    @Override
    public BinaryTreeNode<E> getRoot() {
        // the root is in the index 0, we need to check if the tree has elements first
        if(size <= 0){
            System.out.println("The tree is empty");
            return null;
        }else{
            return new ArrayBasedBinaryTreeNode<E>(0, this);
        }
    }

    @Override
    public void addRoot(E element) {
        // the root is in the index 0, we need to check if the tree has elements first
        if(size > 0){ // We already have a root
            System.out.println("The tree is not empty");
        }else{
            elements[0] = element;
            size++;
        }
        
    }

    @Override
    public boolean hasRoot() {
        return size > 0;
    }

    public boolean isValidIndex(int index){
        return (index >=0 && index < N);
    }

    public E getElementByIndex(int index){
        if(!isValidIndex(index)){
            System.out.println("The index is not valid");
            return null;
        }else{
            return (E) elements[index];
        }
    }

    public void setElementByIndex(E element, int index){
        if(!isValidIndex(index)){
            System.out.println("The index is not valid");
        }else{
            elements[index] = element;
        }
    }

    public void addElementByIndex(E element, int index){
        if(index >= N){
            increaseArraySize();
        }

        elements[index] = element;
        size++;
    }
    
    private void increaseArraySize(){
        
        Object[] newElements = new Object[N*2];
        for(int i=0; i < N; i++){
            newElements[i] = elements[i];
        }
        N=N*2;
        elements = newElements;
    }

    public void removeElementByIndex(int index){
        if(!isValidIndex(index)){
            System.out.println("The index is not valid");
        }else{
            elements[index] = null;
            size--;
        }
    }

    public void removeNodeAndMoveSubTree(ArrayBasedBinaryTreeNode<E> rootSubTree, int newIndex) {
        moveSubTree(rootSubTree, newIndex);
        size--;
    }
    /** This recursive function move the subtree starting in the rootSubTree node in the position 
     * specified by the newIndex attribute.
     * 
     * It first read the currentIndex of the rootSubTree node in order to determine the new indeces 
     * of the children (used in the recursive calls).
     * Then, it removes the node from the current poisition in the array.
     * 
     * Then, it moves the subtrees of the children (if these exist), using recursively itself. The new 
     * index of each child is determined using the newIndex of the rootSubTree node.
     * 
     * Finally, it assign the rootSubTree to its newIndex, and update its myIndex attribute
     */
    public void moveSubTree(ArrayBasedBinaryTreeNode<E> rootSubTree, int newIndex) {
        
        int currentIndex = rootSubTree.getIndex();
        elements[newIndex] = elements[currentIndex];
        elements[currentIndex] = null;

        // recursive calls on the subtrees
        if(rootSubTree.hasLeftChild()){
            moveSubTree((ArrayBasedBinaryTreeNode<E>) rootSubTree.getLeftChild(), 2*newIndex + 1);
        }
        if(rootSubTree.hasRightChild()){
            moveSubTree((ArrayBasedBinaryTreeNode<E>) rootSubTree.getRightChild(), 2*newIndex + 2);
        }  
    }

    @Override
    public String toString() {
        return getStringForNode(getRoot(), 0) + 
            "\n\n" + 
            getArrayAsString() + "\n";
    }

    public String getStringForNode(BinaryTreeNode<E> treeNode, int level){
        String returnString = "";
        
        if(treeNode.hasLeftChild()){
            returnString+= getStringForNode(treeNode.getLeftChild(), level+1);
        }

        for(int i=0; i<level;i++)
            returnString+= "   ";
        returnString+= treeNode.getElement() + "\n";

        if(treeNode.hasRightChild()){
            returnString+= getStringForNode(treeNode.getRightChild(), level+1);
        }

        return returnString;
    }

    public String getArrayAsString() {
        String returnString = "";
        for(int i=0; i<N; i++){
            returnString += elements[i] + "-";
        }
        return returnString;
    }


}
