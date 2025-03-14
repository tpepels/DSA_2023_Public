import java.util.Arrays;

public class DPGoldMineTabulation {

    public static int maxGoldCollected(int[][] mine, int n, int m) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = mine[i][m - 1];
        }

        for (int col = m - 2; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int right = dp[row][col + 1];
                int rightUp = (row - 1 >= 0) ? dp[row - 1][col + 1] : 0;
                int rightDown = (row + 1 < n) ? dp[row + 1][col + 1] : 0;
                dp[row][col] = mine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        // print the dp table
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxGold;
    }

    public static void main(String[] args) {
        int[][] goldMine = {
                { 1, 0, 0, 8, 0 },
                { 0, 5, 3, 0, 8 },
                { 3, 0, 2, 9, 0 },
                { 0, 7, 0, 8, 1 },
                { 2, 10, 0, 7, 0 }
        };

        int n = goldMine.length;
        int m = goldMine[0].length;

        int maxGold = maxGoldCollected(goldMine, n, m);

        System.out.println("Maximum gold collected: " + maxGold);
    }
}
