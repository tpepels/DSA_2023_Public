package module_4.live_coding.empty;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] array = { 9, 3, 7, 5, 6, 2, 8 };
        heapSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            upheap(arr, i);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            downheap(arr, 0, i);
        }
    }

    // Upheap: Bubbles up the element at index 'i'.
    private static void upheap(int[] heap, int i) {
        while (i > 0) {
            int parentIndex = getParentIndex(i);
            if (heap[i] <= heap[parentIndex]) {
                break;
            }
            swap(heap, i, parentIndex);
            i = parentIndex;
        }
    }

    // Downheap: Bubbles down the element at index 'i' within the heap of size
    // 'size'.
    private static void downheap(int[] heap, int i, int size) {
        while (getLeftIndex(i) < size) {
            int leftIndex = getLeftIndex(i);
            int rightIndex = getRightIndex(i);
            int largest = i;
            if (leftIndex < size && heap[leftIndex] > heap[largest]) {
                largest = leftIndex;
            }
            if (rightIndex < size && heap[rightIndex] > heap[largest]) {
                largest = rightIndex;
            }
            if (largest == i) {
                break;
            }
            swap(heap, i, largest);
            i = largest;
        }
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
