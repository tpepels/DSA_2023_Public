package module_4;

public class MinPriorityQueue {
    private int[] heap; // Array representation of the heap
    private int size; // Number of elements currently in the heap
    private int capacity; // Maximum number of elements that can be stored in the heap

    // Constructor to initialize the priority queue with a given capacity
    public MinPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // Heap is 1-indexed, so allocate an extra space
        heap[0] = Integer.MIN_VALUE; // Set a sentinel value at the 0th index
    }

    // Helper function to get the parent index of a node at position pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Helper function to get the index of the left child of a node at position pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Helper function to get the index of the right child of a node at position pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Helper function to check if a node at position pos is a leaf node
    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    // Helper function to swap two elements in the heap
    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Function to heapify the node at position pos
    private void minHeapify(int pos) {
        // If the node is a non-leaf node and is greater than any of its child
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                // Swap with the left child and heapify the left child
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                // Swap with the right child and heapify the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a new element into the priority queue
    public void insert(int element) {
        if (size >= capacity) {
            return; // Heap is full
        }
        heap[++size] = element; // Place the element at the end of the heap
        int current = size;

        // Traverse up the heap and fix the min heap property if it is violated
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Function to remove and return the minimum element from the heap
    public int remove() {
        int popped = heap[1]; // The root of the heap contains the minimum element
        heap[1] = heap[size--]; // Replace the root with the last element in the heap
        minHeapify(1); // Heapify the root element to maintain heap property
        return popped;
    }

    // Main method to test the MinPriorityQueue class
    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinPriorityQueue minHeap = new MinPriorityQueue(15);
        // Insert elements into the heap
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        // Print the heap
        minHeap.print();
        // Remove and print the minimum element
        System.out.println("The Min val is " + minHeap.remove());
    }
}
