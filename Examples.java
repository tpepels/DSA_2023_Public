public class Examples {

    /**
     * This function's complexity:
     * O(1) i.e. the runtime of the function is not dependent on its input
     */
    int Example1(int init) {
        int sum = init;

        for (int i = 3; i < 1000; i++)
            sum++;

        return sum;
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * This function's complexity:
     * O(n^5)
     */
    int Example2(int n) {
        /*
         * The sum of the first n integers is:
         * 
         * S = n(n+1) / 2
         * 
         * Note the n(n+1) makes this function O(n^2)
         *
         * (Strangely, however;
         * 1 + 2 + 3 + 4 + ... = -1/12
         * More info: (https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF))
         */

        int sum = 0;
        for (int i = 0; i < n * n * n; i++) // n^3
            for (int j = 0; j < i; j++)
                sum++; // (1 + 2 + 3 + ... + n) * n^3

        /*
         * Multiplying exponents:
         * (1 + 2 + 3 + ... + n) * n^3
         * --> n(n-1)/2 * n^3
         * --> 1/2 * n^4 * (n-1)
         * 
         * Drop lower order terms:
         * n^4 * n = n^5
         * 
         * a^m * a^n = a^(n+m)
         */
        return sum;
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * O(n) by counting the number of recurrent calls
     */
    int Example3(int n, int m) {
        if (m < 2) // 1 ( n calls )
            return m;
        if (n < 1) // 1 ( n calls )
            return n;

        if (n < 10)
            return Example3(n / m, m); // Note that m does not change..
        else
            return Example3(n - 1, m); // n
    }

    /*
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * O(n^2)
     *
     */
    void Example4(int n) {
        // i loop
        for (int i = 0; i < n; ++i) { // n
            // j loop
            for (int j = 0; j < n; ++j) // n^2 (this loop determines the final complexity)
                System.out.println("j = " + j);

            // k loop
            for (int k = 0; k < i; ++k) { // 1 + 2 + ... + n (which is < n^2 in the j-loop)
                System.out.println("k = " + k);

                // m loop
                for (int m = 0; m < 100; ++m) // 100 * n (which is < n^2 in the j-loop)
                    System.out.println("m = " + m);
            }
        }
        // Total: n^2 + (1 + 2 + .. + n) + 100n
        // Drop lower order terms: O(n^2)
    }
}
