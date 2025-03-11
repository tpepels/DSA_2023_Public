package string_search;

public class BruteForceStringSearch {

    /**
     * Searches for occurrences of a pattern within a text using brute force.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     * @return The starting index of the first occurrence of the pattern in the
     *         text, or -1 if not found.
     */
    public static int search(String text, String pattern) {
        int comparisonCount = 0;

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0; // Index into the pattern
            for (j = 0; j < pattern.length(); j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pattern.length()) {
                System.err.println("Pattern found at index " + i + " after " + comparisonCount + " comparisons.");
                return i;
            }
        }
        System.out.println("Pattern not found after " + comparisonCount + " comparisons.");
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
