import java.util.Arrays;

public class DPGoldMineTabulation {

    public static int maxGoldCollected(int[][] mine, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        // DP table initialized with the same values as mine
        int[][] dp = new int[n][m];

        // Copy last column from the mine to dp table (base case)
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = mine[i][m - 1];
        }

        // Fill the DP table column by column, from right to left
        for (int col = m - 2; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                // Right (→)
                int right = dp[row][col + 1];

                // Right-up diagonal (↗)
                int rightUp = (row > 0) ? dp[row - 1][col + 1] : 0;

                // Right-down diagonal (↘)
                int rightDown = (row < n - 1) ? dp[row + 1][col + 1] : 0;

                // Update DP table with the maximum gold collected
                dp[row][col] = mine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        // Find the maximum value in the first column (best start position)
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        // Print the DP Table
        System.out.println("DP Table:");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return maxGold;
    }

    public static void main(String[] args) {
        int[][] goldMine = {
                { 1, 0, 0, 8, 0 },
                { 0, 5, 3, 0, 0 },
                { 3, 0, 2, 9, 0 },
                { 0, 7, 0, 8, 0 },
                { 2, 10, 0, 7, 0 }
        };

        int n = goldMine.length;
        int m = goldMine[0].length;

        int maxGold = maxGoldCollected(goldMine, n, m);

        System.out.println("Maximum gold collected: " + maxGold);
    }
}
