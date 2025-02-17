package module_4.live_coding;

import java.util.Arrays;

public class GenericHeapSort {

    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        // Build the heap using upheap.
        for (int i = 1; i < arr.length; i++) {
            upheap(arr, i);
        }
        // Extract elements one by one.
        for (int end = arr.length - 1; end > 0; end--) {
            swap(arr, 0, end); // Swap max element with the last element.
            downheap(arr, 0, end); // Restore the heap property.
        }
    }

    // Upheap: Bubbles up the element at index 'i' in the heap.
    private static <T extends Comparable<T>> void upheap(T[] arr, int i) {
        while (i > 0) {
            int parent = getParentIndex(i);
            if (arr[i].compareTo(arr[parent]) <= 0)
                break;
            swap(arr, i, parent);
            i = parent;
        }
    }

    // Downheap: Bubbles down the element at index 'i' within the heap of given
    // size.
    private static <T extends Comparable<T>> void downheap(T[] arr, int i, int size) {
        while (getLeftIndex(i) < size) {
            int left = getLeftIndex(i);
            int right = getRightIndex(i);
            int largest = i;
            if (left < size && arr[left].compareTo(arr[largest]) > 0) {
                largest = left;
            }
            if (right < size && arr[right].compareTo(arr[largest]) > 0) {
                largest = right;
            }
            if (largest == i)
                break;
            swap(arr, i, largest);
            i = largest;
        }
    }

    // Returns the parent index of the node at index 'i'.
    private static int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    // Returns the left child index of the node at index 'i'.
    private static int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    // Returns the right child index of the node at index 'i'.
    private static int getRightIndex(int i) {
        return 2 * i + 2;
    }

    // Swaps two elements in the array.
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage.
    public static void main(String[] args) {
        Integer[] array = { 9, 3, 7, 5, 6, 2, 8 };
        System.out.println("Before sorting: " + Arrays.toString(array));
        heapSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
