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
        int length = 0; // Length of the previous longest prefix suffix
        lps[0] = 0; // lps[0] is always 0

        // The loop calculates lps[i] for i = 1 to M-1
        for (int i = 1; i < pattern.length(); i++) {
            while (length > 0 && pattern.charAt(i) != pattern.charAt(length)) {
                length = lps[length - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
            }
            lps[i] = length;
        }

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

        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
