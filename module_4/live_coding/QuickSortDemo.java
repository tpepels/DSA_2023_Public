package module_4.live_coding;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] array = { 9, 3, 7, 5, 6, 2, 8 }; // Test array
        System.out.println("Before sorting: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    // Quicksort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // Base case: stop if low is not less than high
            int pivotIndex = partition(arr, low, high); // Partition
            quickSort(arr, low, pivotIndex - 1); // Sort left part
            quickSort(arr, pivotIndex + 1, high); // Sort right part
        }
    }

    // Partitioning: divides array into left (smaller than pivot) and right (greater
    // than pivot)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index for smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // Element must be left of pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Put pivot in the correct place
        return i + 1; // Return the pivot position
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}