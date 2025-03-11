import java.util.Arrays;

public class SkippingProblemExample {
    public static int minTotalCost(int[] steps) {
        if (steps == null || steps.length == 0)
            return 0;

        if (steps.length == 1)
            return steps[0];

        int[] dp = new int[steps.length];
        dp[0] = steps[0];
        dp[1] = Math.min(steps[0], steps[1]);

        for (int i = 2; i < steps.length; i++) {
            dp[i] = steps[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // Print the array with the inbuilt function
        System.out.println(Arrays.toString(dp));

        return dp[steps.length - 1];
    }

    public static void main(String[] args) {
        int[] steps = { 1, 2, 3, 1, 5, 1, 2, 1 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps));

        int[] steps_2 = { 6, 2, 3, 8, 1, 2, 2, 1 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_2));
    }
}
