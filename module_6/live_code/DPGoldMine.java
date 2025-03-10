import java.util.Arrays;

public class DPGoldMine {

    static int recursions = 0;

    private static int collect(int[][] mine, int r, int c, int n, int m, int[][] dp) {
        recursions++;
    }

    public static int maxGoldCollected(int[][] mine, int n, int m, int startRow) {
        recursions = 0;

        // Edge case: Empty mine
        if (n == 0 || m == 0) {
            return 0;
        }

        // Initialize dp matrix with -1
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursive function from the given start row
        int result = collect(mine, startRow, 0, n, m, dp);

        // Print the DP matrix
        System.out.println("DP Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] < 10 && dp[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Total recursive calls: " + recursions);
        return result;
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

        // Try collecting gold from each row and get the maximum result
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, maxGoldCollected(goldMine, n, m, i));
        }

        System.out.println("Maximum gold collected: " + maxGold);
    }
}
