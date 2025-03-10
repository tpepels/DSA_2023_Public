import java.util.Arrays;

public class DPGoldMine {

    static int recursions = 0;

    private static int collect(int[][] mine, int r, int c, int n, int m, int[][] dp) {
        recursions++;

        // Base condition: Out of grid bounds
        if (r < 0 || r >= n || c >= m) {
            return 0;
        }

        // If best answer already known, return stored result
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        // Recursive calls for three possible moves
        int upperDiagonal = collect(mine, r - 1, c + 1, n, m, dp); // ↗
        int straight = collect(mine, r, c + 1, n, m, dp); // →
        int lowerDiagonal = collect(mine, r + 1, c + 1, n, m, dp); // ↘

        // Store best answer in dp matrix
        dp[r][c] = mine[r][c] + Math.max(Math.max(upperDiagonal, straight), lowerDiagonal);
        return dp[r][c];
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
                { 10, 33, 13, 15 },
                { 22, 21, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 14, 2 }
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
