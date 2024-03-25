/*
(source: https://www.codingninjas.com/codestudio/problem-details/gold-mine-problem_799363)

In the recursive solution, we can clearly see overlappings.

A single cell might be visited many times, and we further need to calculate the best answer from that cell, which we have already calculated.
Hence we can store those answers in a 2-D matrix. For each cell, if the answer is already calculated, we will return the stored answer.
We can initialize the matrix with -1, so if a cell of the new matrix is -1, we need too calculate the best answer and then store the answer in the matrix.
But if it’s greater than -1, it clearly indicates that answer has already been calculated and returns the answer (value stored at that cell).

Finally, in the end, we will be getting maximum of gold collected starting from each row of the first column in the main function. We will be returning maximum of all those amounts.\

The answer for each cell will be calculated by the recursive function only once.
    Time complexity: O(N*M)
    Space complexity: O(N*M)

N denotes the maximum number of rows in the matrix and M denotes the number columns in the matrix.
*/
public class DPGoldMine {

    static int recursions = 0;

    private static int collect(int[][] mine, int r, int c, int n, int m, int[][] dp) {
        recursions++;

        // Base condition.
        if ((r < 0) || (r == n) || (c == m)) {
            return 0;
        }

        // If best answer already known.
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        // Right upper diagonal.
        int upperDiagonal = collect(mine, r - 1, c + 1, n, m, dp);

        // Straight right.
        int straight = collect(mine, r, c + 1, n, m, dp);

        // Lower right diagonal.
        int lowerDiagonal = collect(mine, r + 1, c + 1, n, m, dp);

        // Store the best answer in dp matrix and return.
        dp[r][c] = mine[r][c] + Math.max(Math.max(upperDiagonal, straight), lowerDiagonal);
        return dp[r][c];
    }

    public static int maxGoldCollected(int[][] mine, int n, int m, int startRow) {
        recursions = 0;
        // Initialize the dp matrix.
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        // Recursive function call for ith row.
        return collect(mine, startRow, 0, n, m, dp);
    }
}
