/*

(source: https://www.codingninjas.com/codestudio/problem-details/gold-mine-problem_799363)

The miner can start from any row of the first column, hence we will be calling our recursive function.
In the recursive function, a miner can move in three particular directions:

    Upper right diagonal -> (R - 1,C + 1)
    Straight right -> (R,C)
    Lower right diagonal -> (R + 1, ‘C’)

Hence each function call will be representing/returning the addition of gold at that cell and the maximum of gold collected by choosing the best possible path ahead.

The base condition of the recursive function is:
    When column reaches its limit -> (C == M)
    When row is negative -> (R < 0)
    When row reaches its limit -> (R == N)
 

Each recursive function will further call 3 new recursive functions for each cell.
    Time complexity: O(3^(N*M))
    Space complexity: O(N*M)

N denotes the maximum number of rows in the matrix and M denotes the number columns in the matrix.
*/

public class SimpleGoldMine {

    static int recursions = 0;

    private static int collect(int[][] mine, int r, int c, int n, int m) {
        recursions++;
        // Base condition.
        if ((r < 0) || (r == n) || (c == m)) {
            return 0;
        }

        // Right upper diagonal.
        int upperDiagonal = collect(mine, r - 1, c + 1, n, m);

        // Straight right.
        int straight = collect(mine, r, c + 1, n, m);

        // Lower right diagonal.
        int lowerDiagonal = collect(mine, r + 1, c + 1, n, m);

        // Return the maximum gold collected.
        return mine[r][c] + Math.max(Math.max(upperDiagonal, straight), lowerDiagonal);
    }

    public static int maxGoldCollected(int[][] mine, int n, int m, int startRow) {
        recursions = 0;
        // Recursive function call for starting row.
        return collect(mine, startRow, 0, n, m);

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
        System.out.println("Recursive calls: " + recursions);
        System.out.println("N*M: " + n * m);
    }
}
