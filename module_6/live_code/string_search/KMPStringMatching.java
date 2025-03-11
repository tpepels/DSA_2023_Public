package string_search;

public class KMPStringMatching {

    /**
     * Searches for occurrences of a pattern within a text.
     *
     * @param text    The text in which to search for the pattern.
     * @param pattern The pattern to search for.
     */
    public static void search(String text, String pattern) {

    }

    /**
     * Computes the Longest Prefix Suffix (LPS) array.
     *
     * @param pattern The pattern for which to compute the LPS array.
     * @return The LPS array.
     */
    private static int[] computeLPSArray(String pattern) {

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
