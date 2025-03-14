import java.util.Arrays;

public class SkippingProblemExample {
    public static int minTotalCost(int[] steps) {
        if (steps == null || steps.length == 0)
            return 0;

        if (steps.length == 1)
            return steps[0];

        int[] dp = new int[steps.length];
        dp[0] = steps[0];
        dp[1] = Math.min(steps[0], steps[1] + steps[0]);

        for (int i = 2; i < steps.length; i++) {
            dp[i] = steps[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // Print the array with the inbuilt function
        System.out.print("DP Array: ");
        System.out.println(Arrays.toString(dp));

        return dp[steps.length - 1];
    }

    public static void main(String[] args) {
        int[] steps = { 1, 2, 3, 1, 5, 1, 2, 1 };

        int[] steps_2 = { 1, 2 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_2));

        int[] steps_3 = { 1, 2, 3 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_3));

        int[] steps_4 = { 1, 2, 3, 1 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_4));

        int[] steps_5 = { 1, 2, 3, 1, 5 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_5));

        int[] steps_6 = { 1, 2, 3, 1, 5, 1 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_6));

        int[] steps_7 = { 1, 2, 3, 1, 5, 1, 2 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_7));
        System.out.println("Final solution:");
        System.out.println("Minimum Total Cost: " + minTotalCost(steps));

        System.out.println("");
        int[] steps_two = { 6, 2, 3, 8, 1, 2, 2, 1 };
        System.out.println("Minimum Total Cost: " + minTotalCost(steps_two));
    }
}
