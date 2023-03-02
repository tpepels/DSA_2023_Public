package tutorial_3;

public class TestBinaryTree {
    public static void main(String[] args) {
        // BinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
        BinaryTree<Integer> tree = new ArrayBasedBinaryTree<Integer>();

        // Create a binary tree
        tree.addRoot(3);

        tree.getRoot().addLeftChild(2);
        tree.getRoot().addRightChild(5);

        tree.getRoot().getLeftChild().addLeftChild(1);
        tree.getRoot().getLeftChild().addRightChild(7);

        tree.getRoot().getRightChild().addLeftChild(11);
        tree.getRoot().getRightChild().addRightChild(-7);

        System.out.println(tree);

        // test delete a leaf
        tree.getRoot().getRightChild().getRightChild().delete();

        System.out.println(tree);

        // test delete an internal node
        tree.getRoot().getRightChild().delete();

        System.out.println(tree);
        System.out.println(tree.getRoot().getRightChild().getElement());

        // test delete an internal node with two children
        tree.getRoot().getLeftChild().delete();

        System.out.println(BinaryTreeUtils.computeHeight(tree));

        // ad node and compute height
        tree.getRoot().getLeftChild().getLeftChild().addLeftChild(6);
        System.out.println(BinaryTreeUtils.computeHeight(tree));

        System.out.println(tree);

        // compute odd numbers
        System.out.println(BinaryTreeUtils.computeOddNumbers(tree));

        // test if proper binary tree
        System.out.println(BinaryTreeUtils.isProperBinaryTree(tree));
        tree.getRoot().getLeftChild().getLeftChild().addRightChild(-6);
        System.out.println(BinaryTreeUtils.isProperBinaryTree(tree));

        System.out.println(tree);

        // compute odd numbers between two levels (note that the first level is level 0)
        System.out.println(BinaryTreeUtils.computeOddNumbersBetweenLevels(tree, 1,2));
    }
}
