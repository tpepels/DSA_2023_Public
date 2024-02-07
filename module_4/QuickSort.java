package module_4;

import java.util.Arrays;
import java.util.Random;

/**
 * Source:
 * https://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 */

public class QuickSort<E> {

    public void sort(E[] values, Comparator<E> comp) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        quickSort(values, 0, values.length - 1, comp);
    }

    private void quickSort(E[] arr, int begin, int end, Comparator<E> comp) {

        /*
         * 1. We choose an element from the list, called the pivot. We'll use it to
         * divide the list into two sub-lists.
         * 
         * 2. We reorder all the elements around the pivot – the ones with smaller value
         * are placed before it, and all the elements greater than the pivot after it.
         * After this step, the pivot is in its final position. This is the important
         * partition step.
         * 
         * 3. We apply the above steps recursively to both sub-lists on the left and
         * right of the pivot.
         */

        int i = begin, j = end;
        // Select the last element in the range as pivot
        E pivot = arr[end]; // ? Is this a good idea ?
        // Get the pivot element from the middle of the list
        // E pivot = arr[begin + (end - begin) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            // while (arr[i] < pivot) { // ? How can we compare two unknown types??
            while (comp.compare(arr[i], pivot) < 0) { // if first < second parameter,
                // comp returns < 0
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            // while (arr[j] > pivot) { // ? How can we compare two unknown types??
            while (comp.compare(arr[j], pivot) > 0) { // if first > second parameter,
                // comp returns > 0
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (begin < j)
            quickSort(arr, begin, j, comp);
        if (i < end)
            quickSort(arr, i, end, comp);
    }

    private void swap(E[] arr, int a, int b) {
        E swapTemp = arr[a];
        arr[a] = arr[b];
        arr[b] = swapTemp;
    }

    public static void main(String[] args) {
        Integer[] numbers = randomArray();

        System.out.println("Our input:");
        System.out.println(Arrays.toString(numbers));

        // Create the comparator used to compare integers
        Comparator<Integer> intComp = new IntComparator();

        QuickSort<Integer> sorter = new QuickSort<>();
        sorter.sort(numbers, intComp);

        if (!validate(numbers, intComp)) {
            System.err.println("We did bad!!");
            System.err.println(Arrays.toString(numbers));
            System.err.println("Is not sorted!");
        } else {
            System.out.println("The sorted result:");
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static <E> boolean validate(E[] numbers, Comparator<E> comp) {
        for (int i = 0; i < numbers.length - 1; i++) {
            // if (numbers[i] > numbers[i + 1]) {
            if (comp.compare(numbers[i], numbers[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static Integer[] randomArray() {
        Integer[] numbers;
        int SIZE = 20;
        int MAX = 20;

        numbers = new Integer[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        return numbers;
    }
}
