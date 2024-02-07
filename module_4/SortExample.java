package module_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortExample {
    public static Random r = new Random();

    public static void main(String[] args) {
        int[] input = { 1, 5, 2, 2, 5, 6, 7, 2, 1, 7, 10 };

        int[] out = quicksort(input);

        System.out.println(Arrays.toString(out));
    }

    public static int[] quicksort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int pivotI = r.nextInt(input.length);
        int pivot = input[pivotI];

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int nPivot = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < pivot) {
                left.add(input[i]);
            }

            if (input[i] > pivot) {
                right.add(input[i]);
            }

            if (input[i] == pivot) {
                nPivot++;
            }
        }
        int[] leftO = new int[0];
        int[] rightO = new int[0];

        if (!left.isEmpty())
            leftO = quicksort(left.stream().mapToInt(i -> i).toArray());
        if (!right.isEmpty())
            rightO = quicksort(right.stream().mapToInt(i -> i).toArray());

        int[] output = new int[input.length];
        int k = 0;
        for (int i = 0; i < leftO.length; i++) {
            output[k++] = leftO[i];
        }
        for (int i = 0; i < nPivot; i++) {
            output[k++] = pivot;
        }
        for (int i = 0; i < rightO.length; i++) {
            output[k++] = rightO[i];
        }

        return output;
    }
}
