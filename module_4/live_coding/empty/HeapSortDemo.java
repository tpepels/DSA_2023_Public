package module_4.live_coding.empty;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] array = { 9, 3, 7, 5, 6, 2, 8 };
        heapSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] arr) {

    }

    // Upheap: Bubbles up the element at index 'i'.
    private static void upheap(int[] heap, int i) {

    }

    // Downheap: Bubbles down the element at index 'i' within the heap of size
    // 'size'.
    private static void downheap(int[] heap, int i, int size) {

    }

    // Returns the parent index of a node at index 'i'.
    private static int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    // Returns the left child index of a node at index 'i'.
    private static int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    // Returns the right child index of a node at index 'i'.
    private static int getRightIndex(int i) {
        return 2 * i + 2;
    }

    // Swaps two elements in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
