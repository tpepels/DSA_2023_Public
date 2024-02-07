package module_4.lecture_notes;

import java.util.Arrays;

public class LinearSort {

    // -- Start Radix Sort --

    public void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit.
        // Instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            radixCountSort(arr, exp);
        }
    }

    public void radixCountSort(int[] arr, int exp) {
        int n = arr.length;

        // Create an auxiliary array of size n
        int[] output = new int[n];
        int[] count = new int[10];

        // Initialize the count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store the count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array back to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    // -- End radix sort --

    // -- This is a seperate algorithm for counting sort
    public void countingSort(int[] arr, int min, int max) {
        int n = arr.length;

        // Create an auxiliary array of size k
        int k = max - min + 1;
        int[] count = new int[k];

        // Initialize the count array
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }

        // Count the number of occurrences of each element
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Create the sorted list
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min]-- > 0) {
                arr[j++] = i;
            }
        }
    }

}
