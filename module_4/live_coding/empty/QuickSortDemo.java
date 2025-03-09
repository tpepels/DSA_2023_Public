package module_4.live_coding.empty;

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
        if (low < high) {
            int pivot = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    // Partitioning: divides array into left (smaller than pivot) and right (greater
    // than pivot)
    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + (high - low) / 2;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}