package string_search;

public class KMPStringMatching {

    /**
     * Searches for occurrences of a pattern within a text.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     */
    public static void search(String text, String pattern) {
        int comparisons = 0; // Counter for the number of comparisons
        int[] lps = computeLPSArray(pattern); // Preprocess the pattern
        printLPSArray(lps, pattern);

        int j = 0; // Index for pattern[]

        // Start searching for the pattern in the text
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
                comparisons++; // Count this as a comparison
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                comparisons++; // Count this as a comparison
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern at index " + (i - j + 1));
                j = lps[j - 1];
            }
        }

        // Print the total number of comparisons made
        System.out.println("Total comparisons made: " + comparisons);
    }

    /**
     * Computes the Longest Prefix Suffix (LPS) array.
     *
     * @param pattern The pattern for which to compute the LPS array.
     * @return The LPS array.
     */
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < pattern.length(); i++) {
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = lps[len - 1]; // Backtrack to the last known LPS
            }
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = ++len; // Extend LPS if characters match
            } else {
                lps[i] = 0; // No LPS match at this index
            }
        }
        return lps;
    }

    private static void printLPSArray(int[] lps, String pattern) {
        // Print the LPS array
        System.out.println("LPS array: ");
        // First each character:
        for (int i = 0; i < pattern.length(); i++) {
            System.out.print(pattern.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < pattern.length(); i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
