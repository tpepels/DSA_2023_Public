package tutorial_2;

import java.util.*;
import java.util.stream.IntStream;

public class MaxFind {

    /***
     * Find the highest number in an (unsorted) array
     * 
     * @param array The array of integers
     * @return The highest value in the array
     */
    public static int findMax(int[] array) {
        int currentMax = array[0];
        for (int i = 1; i <= array.length - 1; i++) {
            if (currentMax < array[i]) {
                currentMax = array[i];
            }
        }
        return currentMax;
    }

    // 1. Algoritme tellen
    // 2. Worst case
    // 3. Testen met willekeurige input
    // 4. Testen met gesorteerde input
    public static void main(String[] args) {

        int nExperiments = 100;
        int nArrays = 20;

        int[] inputSizes = { 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000, 50000, 75000, 100000, 250000, 500000,
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
                // randomArrays[i] = intStream.limit(inputSizes[j]).sorted().toArray();
                randomArrays[i] = intStream.limit(inputSizes[j]).toArray();
            }
            /*
             * Start the clock and run the experiments
             */
            long start = System.currentTimeMillis();

            for (int i = 0; i < nExperiments; i++) {
                // Choose one of the random arrays for this experiment
                int[] array = randomArrays[r.nextInt(nArrays)];
                findMax(array);
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
