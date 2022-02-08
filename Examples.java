public class Examples {

    // O(1)
    int Example1() {
        int sum = 0;

        for (int i = 3; i < 1000; i++)
            sum++;

        return sum;
    }

    // O(n^6) (n^2 * n^6)
    int Example2(int n) {
        /*
         * The sum of the first n integers is:
         * 
         * S = n(n+1) / 2
         * 
         * Note the n(n+1) makes this function O(n^2)
         *
         * Strangely, however;
         * 1 + 2 + 3 + 4 + ... = -1/12
         * More info: (https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF)
         */

        int sum = 0;
        for (int i = 0; i < n * n * n; i++) // n^3
            for (int j = 0; j < i; j++) // 1 + 2 + 3 + ... + n^3
                sum++;

        /*
         * Multiplying exponents:
         * 
         * a^m * a^n = a^(n+m)
         */
        return sum;
    }

    // O(n)
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

    // O(n^2)
    void Example4(int n) {
        for (int i = 0; i < n; ++i) { // n

            for (int j = 0; j < n; ++j) // n * n
                System.out.println("j = " + j);

            for (int k = 0; k < i; ++k) { // 1 + 2 + ... + n
                System.out.println("k = " + k);

                for (int m = 0; m < 100; ++m) // 100 * n
                    System.out.println("m = " + m);
            }
        }
    }
}
