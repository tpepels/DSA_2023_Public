package string_search;

public class NaiveExample {

    /**
     * Searches for occurrences of a pattern within a text using brute force.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     * @return The starting index of the first occurrence of the pattern in the
     *         text, or -1 if not found.
     */
    public static int search(String text, String pattern) {
        int comparisons = 0; // Counter for the number of comparisons

        // Loop through the text
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;

            // For current index i, check for pattern match
            for (j = 0; j < pattern.length(); j++) {
                comparisons++; // Count each character comparison
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break; // If mismatch, break out of the loop
                }
            }

            // If the loop completed, we found a match
            if (j == pattern.length()) {
                System.out.println("Pattern found at index: " + i);
                System.out.println("Total comparisons made: " + comparisons);
                return i; // Return the start index of the pattern in text
            }
        }

        // If we reach here, the pattern was not found
        System.out.println("Pattern not found.");
        System.out.println("Total comparisons made: " + comparisons);
        return -1; // Indicate that the pattern was not found
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
