package lecture_notes;

import java.util.Arrays;

public class DynamicProgramming {
    public static class Fibonacci {
        // Table to store the solutions to the subproblems
        private static int[] table; // don't try this in codegrade!

        // Recursive function to compute the nth Fibonacci number
        private static int fibonacci(int n) {
            // If the solution has already been computed, return it
            if (table[n] != -1) {
                return table[n];
            }
            // Otherwise, compute the solution and store it in the table
            table[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return table[n];
        }

        public static void main(String[] args) {
            // Initialize the table with the base cases
            table = new int[n + 1];
            Arrays.fill(table, -1);
            table[0] = 0;
            table[1] = 1;
            // Compute and print the nth Fibonacci number
            int n = 10;
            int result = fibonacci(n);
            System.out.println(result);
        }
    }

    public static class Knapsack {
        // Table to store the solutions to the subproblems
        private static int[][] table;
        private static int callCount = 0;

        // Returns the maximum value that can be put in a knapsack
        static int recursive_knapsack(int[] values, int[] weights, int capacity, int n) {
            /* Base case 0 items left or knapsack is full */
            if (n == 0 || capacity == 0)
                return 0;

            /*
             * if weight of current element is less than or equal to capacity we can
             * either include or exclude the item.
             */
            if (weights[n - 1] <= capacity) {
                callCount++;
                // Otherwise, compute the maximum value by including or excluding the item
                int include = values[n - 1] + recursive_knapsack(values, weights, capacity - weights[n - 1], n - 1);
                int exclude = recursive_knapsack(values, weights, capacity, n - 1);

                return Math.max(include, exclude);
            }

            /*
             * if weight of current element is greater than the capacity we will
             * not include it thus returning just the ignoring part.
             */
            return recursive_knapsack(values, weights, capacity, n - 1);
        }

        // Recursive function to compute the maximum value that can be obtained by
        // including items in the knapsack
        private static int knapsack(int[] values, int[] weights, int capacity, int n) {
            // If the capacity is 0 or there are no more items, return 0
            if (capacity == 0 || n == 0)
                return 0;
            // If the solution has already been computed, return it
            if (table[capacity - 1][n - 1] != -1) {
                System.out.println("Memorized: " + table[capacity - 1][n - 1] + " capacity: " + capacity + " n: " + n);
                return table[capacity - 1][n - 1];
            }

            // If the weight of the nth item is greater than the capacity, skip it
            if (weights[n - 1] > capacity)
                return knapsack(values, weights, capacity, n - 1);

            callCount++;
            // Otherwise, compute the maximum value by including or excluding the item
            int include = values[n - 1] + knapsack(values, weights, capacity - weights[n - 1], n - 1);
            int exclude = knapsack(values, weights, capacity, n - 1);

            int max = Math.max(include, exclude);
            // Store the solution in the table and return it
            table[capacity - 1][n - 1] = max;
            return max;
        }

        public static void main(String[] args) { // Initialize the table with -1
            int capacity = 12;

            // Define the values and weights of the items
            int[] values = { 60, 100, 120, 180, 200 };
            int[] weights = { 1, 2, 3, 4, 5 };

            table = new int[capacity][weights.length];
            for (int[] row : table)
                Arrays.fill(row, -1);

            callCount = 0;
            // Compute and print the maximum value that can be obtained
            int result = knapsack(values, weights, capacity, weights.length);
            // int result = recursive_knapsack(values, weights, capacity, weights.length);
            System.out.println("Found result: " + result);
            System.out.println("Recursive calls: " + callCount);

            for (int[] row : table) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
