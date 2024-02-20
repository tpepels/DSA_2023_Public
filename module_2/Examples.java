package module_2;

public class Examples {

    /**
     * Best case: O(1) (target is the first element)
     * Worst case: O(n) (target is the last element)
     * Expected case: O(n) (target is in the middle, still linear..)
     */
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    /**
     * This function's complexity:
     * O(1) i.e. the runtime of the function is not dependent on its input
     */
    int Example1(int init) {
        int sum = init;

        for (int i = 3; i < 1000; i++) // * No dependence on the input size
            sum++;

        return sum;
    }

    /**
     * This function's complexity:
     * O(n^2)
     */
    int Example2(int n) {
        // ! The sum of the first n integers is:
        // ! S = n(n+1) / 2
        //
        // * Note the n(n+1) makes this function O(n^2)
        //
        // ? Strangely, however;
        // ? 1 + 2 + 3 + 4 + ... = -1/12
        // ? More info: (https://youtu.be/w-I6XTVZXww)

        int sum = 0;
        for (int i = 0; i < n; i++) { // * n
            if (i > 100) {
                for (int j = 0; j < i; j++)
                    sum++; // * (1 + 2 + 3 + ... + 1/2 n)
            }
        }
        /*
         * Multiplying exponents:
         * (1 + 2 + 3 + ... + n)
         * --> n(n+1)/4
         * 
         */
        return sum;
    }

    /**
     * O(n) by counting the number of recurrent calls
     */
    int Example3(int n, int m) {
        if (m < 2) // * 1 ( n calls )
            return m;
        if (n < 1) // * 1 ( n calls )
            return n;

        if (n < 100) // ? Does this have any influence on the complexity? Think of n_0 in the O(g(n))
                     // definition
            return Example3(n / m, m); // ? Note that m does not change..
        else
            return Example3(n - 1, m); // * n
    }

    /**
     * O(n^2) time complexity
     * O(1) storage complexity
     */
    void Example4(int n) {

        // i loop
        for (int i = 0; i < n; ++i) { // * n steps
            // j loop
            for (int j = 0; j < n; ++j) // * n^2 steps
                System.out.println("j = " + j);

            // k loop
            for (int k = 0; k < i; ++k) { // * 1 + 2 + ... + n (which is < n^2 in the j-loop)
                System.out.println("k = " + k);

                // m loop
                for (int m = 0; m < 100; ++m) // * 100 * n (which is < n^2 in the j-loop)
                    System.out.println("m = " + m);
            }
        }

        // ? Total: n^2 + (1 + 2 + .. + n) + 100n
        // ? Drop lower order terms: O(n^2)
    }

    /**
     * O(n) complexity
     * O(n) storage complexity
     */
    public static int[] Example5(int[] inputArray) {
        // Initialize a new array of the same length as the input array
        int[] copy = new int[inputArray.length]; // * n extra space

        // Iterate through each element of the inputArray
        for (int i = 0; i < inputArray.length; i++) { // * n steps
            // Copy each element to the new array
            copy[i] = inputArray[i];
        }

        // Return the new array which is a copy of the input array
        return copy;
    }

    /**
     * O(nk) time complexity
     * O(1) storage complexity
     */
    public static int[][] Example6(int n, int k) {
        // Initialize a new two-dimensional array
        int[][] matrix = new int[n][k];

        // Outer loop runs 'n' times
        for (int i = 0; i < n; i++) { // * n steps
            // Inner loop runs 'k' times
            for (int j = 0; j < k; j++) { // * k steps
                // Fill the matrix with the product of the indices
                matrix[i][j] = i * j;
            }
        }

        // Return the filled matrix
        return matrix;
    }

    // Method to perform the binary search k times.
    /**
     * O(k log n) time complexity because this algorithm performs the binary search
     * k times
     */
    public static void Example7(int[] sortedArray, int[] targets) {
        for (int target : targets) { // * k steps
            int resultIndex = binarySearch(sortedArray, target); // * log n

            if (resultIndex != -1) {
                System.out.println("Target " + target + " found at index: " + resultIndex);
            } else {
                System.out.println("Target " + target + " not found.");
            }
        } // * total: k log n

    }

    /**
     * O(log n) time complexity (binary search)
     * O(1) storage complexity
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}
