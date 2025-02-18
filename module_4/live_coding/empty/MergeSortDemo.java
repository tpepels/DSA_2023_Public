package module_4.live_coding.empty;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        Integer[] array = { 9, 9, 9, 7, 7, 9, 9 };
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
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);
        // After this, both right and left are sorted lists.
        return merge(left, right);
    }

    // Merge: combines two sorted lists into one.
    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}
