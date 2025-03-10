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
