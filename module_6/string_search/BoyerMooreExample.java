package string_search;

public class BoyerMooreExample {

    /**
     * Searches for occurrences of a pattern within a text using the Boyer-Moore
     * algorithm.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     */
    public static void search(String text, String pattern) {
        int comparisons = 0; // Counter for the number of comparisons
        int[] lastOcc = lastOccurrence(pattern);
        printLastOccurrenceTable(lastOcc);

        int i = 0; // The amount by which the pattern is shifted

        while (i <= (text.length() - pattern.length())) {
            int j = pattern.length() - 1;
            int ij = i + j; // The index in the text to which we are comparing the pattern

            // Match pattern with text from right to left
            while (j >= 0 && pattern.charAt(j) == text.charAt(ij)) {
                j--;
                comparisons++;
            }

            if (j < 0) {
                System.out.println("Pattern occurs at index = " + i);
                System.out.println("Total comparisons made: " + comparisons);
                return; // Stop searching after the first occurrence
            }

            // Shift based on the last occurrence heuristic
            i += Math.max(1, j - lastOcc[text.charAt(ij)]);
            comparisons++;
        }

        System.out.println("Pattern not found.");
        System.out.println("Total comparisons made: " + comparisons);
    }

    /**
     * Builds the last occurrence table, where each index corresponding to a
     * character
     * stores the last index of that character in the pattern, or -1 if not present.
     *
     * @param pattern The pattern for which to build the last occurrence table.
     * @return The last occurrence table.
     */
    private static int[] lastOccurrence(String pattern) {
        int[] lastOcc = new int[256]; // Supports Extended ASCII

        // Initialize all occurrences as -1
        for (int i = 0; i < 256; i++) {
            lastOcc[i] = pattern.lastIndexOf((char) i);
        }

        return lastOcc;
    }

    private static void printLastOccurrenceTable(int[] lastOcc) {
        System.out.println("Last occurrence table:");
        for (int i = 0; i < 256; i++) {
            if (lastOcc[i] != -1) {
                System.out.println((char) i + " -> " + lastOcc[i]);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.err.println("Text:    " + text);
        System.err.println("Pattern: " + pattern);
        search(text, pattern);
    }
}
