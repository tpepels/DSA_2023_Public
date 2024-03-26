package string_search;

public class BoyerMooreStringSearch {

    /**
     * Searches for occurrences of a pattern within a text using the Boyer-Moore
     * algorithm.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     */
    public static void search(String text, String pattern) {
        int comparisons = 0; // Counter for the number of comparisons
        int[] badChar = buildBadCharTable(pattern);

        int shift = 0; // The amount by which the pattern is shifted
        while (shift <= (text.length() - pattern.length())) {
            int j = pattern.length() - 1;

            // Keep reducing index j of pattern while characters of pattern and text are
            // matching at this shift
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
                comparisons++; // Count this as a comparison
            }

            if (j < 0) {
                System.out.println("Pattern occurs at shift = " + shift);
                // Shift the pattern so that the next character in text aligns with the last
                // occurrence of it in pattern.
                // This calculation simulates the effect of the bad character heuristic.
                shift += (shift + pattern.length() < text.length())
                        ? pattern.length() - badChar[text.charAt(shift + pattern.length())]
                        : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last
                // occurrence of it in pattern.
                int badCharShift = Math.max(1, j - badChar[text.charAt(shift + j)]);
                shift += badCharShift;
                comparisons++; // Count this as a comparison
            }
        }
        System.out.println("Total comparisons made: " + comparisons);
    }

    /**
     * Builds the bad character table; an array where the value at each index
     * corresponding
     * to a character is the last index of that character in the pattern, or -1 if
     * not present.
     *
     * @param pattern The pattern for which to build the bad character table.
     * @return The bad character table.
     */
    private static int[] buildBadCharTable(String pattern) {
        int[] badChar = new int[256]; // Supports Extended ASCII
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1; // Initialize all occurrences as -1
        }
        for (int i = 0; i < pattern.length(); i++) {
            badChar[(int) pattern.charAt(i)] = i; // Set the index of the character in pattern
        }
        // Print the bad character table
        System.out.println("Bad character table: ");
        for (int i = 0; i < 256; i++) {
            if (badChar[i] != -1) {
                System.out.println((char) i + " -> " + badChar[i]);
            }
        }

        return badChar;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
