import java.util.Arrays;

public class SkippingProblem {
    public static int minimizeTotalCost(int[] steps) {
        return -10;
    }

    public static void main(String[] args) {
        int[] steps = { 1, 2, 3, 1, 5, 1, 2, 1 };
        System.out.println("Minimum Total Cost: " + minimizeTotalCost(steps));

        int[] steps_2 = { 6, 2, 3, 8, 1, 2, 2, 1 };
        System.out.println("Minimum Total Cost: " + minimizeTotalCost(steps_2));
    }
}
