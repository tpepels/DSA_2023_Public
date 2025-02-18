package module_4.live_coding.empty;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        Integer[] array = { 9, 3, 7, 5, 6, 2, 8 };
        System.out.println("Before sorting: " + Arrays.toString(array));

        // Convert array to ArrayList for sorting.
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        list = mergeSort(list);

        // Convert sorted ArrayList back to array.
        array = list.toArray(new Integer[0]);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    // MergeSort: returns a sorted ArrayList
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {

    }

    // Merge: combines two sorted lists into one.
    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

    }
}
