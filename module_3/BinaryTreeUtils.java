package module_3;

public class BinaryTreeUtils {

    public static <E extends Comparable<E>> int computeHeight(BinaryTree<E> tree) {
        return computeHeightFromNode(tree.getRoot());
    }

    private static <E extends Comparable<E>> int computeHeightFromNode(BinaryTreeNode<E> treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return 1 + Math.max(computeHeightFromNode(treeNode.getLeftChild()),
                    computeHeightFromNode(treeNode.getRightChild()));
        }
    }

    public static <E extends Comparable<E>> int computeOddNumbers(BinaryTree<E> tree) {
        return computeOddNumbersFromNode(tree.getRoot());
    }

    private static <E extends Comparable<E>> int computeOddNumbersFromNode(BinaryTreeNode<E> treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return computeOddNumbersFromNode(treeNode.getLeftChild()) +
                    computeOddNumbersFromNode(treeNode.getRightChild()) +
                    ((Integer) treeNode.getElement() % 2);
        }
    }

    public static <E extends Comparable<E>> boolean isProperBinaryTree(BinaryTree<E> tree) {
        return isProperBinaryTreeFromNode(tree.getRoot());
    }

    private static <E extends Comparable<E>> boolean isProperBinaryTreeFromNode(BinaryTreeNode<E> treeNode) {
        if (treeNode == null) {
            return true;
        } else if (!treeNode.hasLeftChild() && !treeNode.hasRightChild()) {
            return true;
        } else if (treeNode.hasLeftChild() && treeNode.hasRightChild()) {
            return (isProperBinaryTreeFromNode(treeNode.getLeftChild()) &&
                    isProperBinaryTreeFromNode(treeNode.getRightChild()));
        } else {
            return false;
        }
    }

    public static <E extends Comparable<E>> int computeOddNumbersBetweenLevels(BinaryTree<E> tree, int levelMin,
            int levelMax) {
        return computeOddNumbersFromNodeBetweenLevels(tree.getRoot(), levelMin, levelMax, 0);
    }

    private static <E extends Comparable<E>> int computeOddNumbersFromNodeBetweenLevels(BinaryTreeNode<E> treeNode,
            int levelMin, int levelMax, int currentLevel) {
        if (treeNode == null) {
            return 0;
        } else {

            int nodeContribution = 0;
            int leftContribution = 0;
            int rightContribution = 0;
            if (levelMin <= currentLevel) {
                nodeContribution = ((Integer) treeNode.getElement() % 2);
            }
            if (currentLevel + 1 <= levelMax) {
                leftContribution = computeOddNumbersFromNodeBetweenLevels(treeNode.getLeftChild(), levelMin, levelMax,
                        currentLevel + 1);
                rightContribution = computeOddNumbersFromNodeBetweenLevels(treeNode.getRightChild(), levelMin, levelMax,
                        currentLevel + 1);
            }

            return nodeContribution + leftContribution + rightContribution;
        }
    }
}