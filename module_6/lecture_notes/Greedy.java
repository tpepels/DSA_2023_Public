package lecture_notes;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

    // To prove that this greedy approach is correct, we need to show that it always
    // leads to an optimal solution.
    // Suppose that we have made a series of locally optimal decisions, and we are
    // left with a remaining amount of change R. We will show that there is always a
    // coin C[i] in C such that C[i] <= R and adding C[i] to the solution is
    // optimal.

    // Since C is sorted in decreasing order, C[i] is the largest coin that is
    // less than or equal to R. If we add C[i] to the solution, we will reduce the
    // remaining amount of change by C[i], which is the largest possible reduction.
    // This means that adding C[i] to the solution is a locally optimal decision.

    public static int minCoins(int[] coins, int change) {
        // Sort the coins in decreasing order.
        Arrays.sort(coins);
        // Keep track of the number of coins used.
        int numCoins = 0;
        // Iterate through the coins, starting with the largest.
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            // Add as many of this coin as needed to make the change.
            while (change >= coin) {
                change -= coin;
                numCoins++;
            }
        }
        return numCoins;
    }

    // To prove that this greedy approach is correct, we need to show that it always
    // leads to an optimal solution.
    // Suppose that we have made a series of locally optimal decisions, and we are
    // at a point where we need to decide whether to select interval I[j] or not. We
    // will show that selecting I[j] is always optimal.

    // Since I[j] starts earliest among all the intervals that have not been
    // selected, it follows that I[j] does not overlap with any of the previously
    // selected intervals. This means that selecting I[j] is a locally optimal
    // decision.

    public static int maxNonOverlapping(int[][] intervals) {
        // Sort the intervals by starting point.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // O(n log n)

        // Keep track of the current end point.
        int end = Integer.MIN_VALUE;

        // Keep track of the number of intervals selected.
        int count = 0;

        // Iterate through the intervals.
        for (int[] interval : intervals) { // O(n)
            // If the interval starts after the current end point, select it.
            if (interval[0] >= end) {
                end = interval[1];
                count++;
            }
        }

        return count;
    }

}
