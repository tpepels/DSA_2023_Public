package module_2;

import java.util.Random;
import java.util.stream.IntStream;

public class BinarySearch {
    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOfBinSearch(int[] a, int key) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOfBrute(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // 1. Algoritme tellen
    // 2. Worst case
    // 3. Testen met gesorteerde input
    public static void main(String[] args) {
        int nExperiments = 1000000;
        int nArrays = 20;

        int[] inputSizes = { 1000, 2500, 5000, 7500, 10000, 25000, 50000, 75000, 100000, 250000, 500000,
                750000, 1000000, 2500000, 5000000, 7500000, 10000000, 20000000 };

        Random r = new Random();
        long[] timings = new long[inputSizes.length];

        // Run the experiments
        for (int j = 0; j < inputSizes.length; j++) {
            int[][] randomArrays = new int[nArrays][];
            /*
             * Pre-generate the inputs
             */
            for (int i = 0; i < nArrays; i++) {
                // This lets us generate random arrays
                // https://stackoverflow.com/questions/25793098/how-to-generate-random-array-of-ints-using-stream-api-java-8/25793191
                IntStream intStream = r.ints(-1000, 1000);
                // Array must be sorted for binary search
                randomArrays[i] = intStream.limit(inputSizes[j]).sorted().toArray();
            }

            /*
             * Start the clock and run the experiments
             */
            long start = System.currentTimeMillis();

            for (int i = 0; i < nExperiments; i++) {
                // Choose one of the random arrays for this experiment
                int[] array = randomArrays[r.nextInt(nArrays)];
                // Select a random value from the random array
                int toFind = array[r.nextInt(array.length)];
                // Let's search!
                // indexOfBrute(array, toFind);
                indexOfBinSearch(array, toFind);
            }

            long end = System.currentTimeMillis();

            long totTime = end - start;
            timings[j] = totTime;
            System.out.println(inputSizes[j] + "," + totTime);
        }
        System.out.println();
        /*
         * Print just the timings to paste in excel
         */
        for (long time : timings) {
            System.out.println(time);
        }
        System.out.println();
    }
}
