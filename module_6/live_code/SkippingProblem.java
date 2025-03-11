import java.util.Arrays;

public class SkippingProblem {
    public static int minimizeTotalCost(int[] steps) {
        int[] dp = new int[steps.length];
        dp[0] = steps[0];
        dp[1] = Math.min(steps[0], steps[1]);

        for (int i = 2; i < steps.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + steps[i];
        }
        System.out.println(Arrays.toString(dp));
        return dp[steps.length - 1];
    }

    public static void main(String[] args) {
        int[] steps = { 1, 2, 3, 1, 5, 1, 2, 1 };
        System.out.println("Minimum Total Cost: " + minimizeTotalCost(steps));

        int[] steps_2 = { 6, 2, 3, 8, 1, 2, 2, 1 };
        System.out.println("Minimum Total Cost: " + minimizeTotalCost(steps_2));
    }
}
