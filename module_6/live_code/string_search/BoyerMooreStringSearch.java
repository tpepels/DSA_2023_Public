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
        int comparisonCount = 0;
        int[] lastOcc = lastOccurrence(pattern);
        printLastOccurrenceTable(lastOcc);

        int i = 0;
        while (i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
                j--;
                comparisonCount++;
            }
            if (j <= 0) {
                System.out.println("Pattern found at index " + i);
                i++;
            } else {
                // Shift based on the last occurrence heuristic
                if (lastOcc[text.charAt(i + j)] == -1) {
                    i += pattern.length() - j;
                } else {
                    i += j - lastOcc[text.charAt(i + j)];
                }
            }
        }
        System.out.println("Total comparisons: " + comparisonCount);
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
        int[] lastOcc = new int[256];
        for (int i = 0; i < 256; i++) {
            lastOcc[i] = pattern.lastIndexOf((char) i);
        }
        return lastOcc;
    }

    /**
     * Prints the given last occurrence table.
     */
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
