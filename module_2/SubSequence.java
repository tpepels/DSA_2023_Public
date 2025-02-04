package module_2;

public class SubSequence {
    public static boolean isSequence(String[][] S, String seq) {

        // The first dependence on the input:
        int k = S.length; // * The number of arrays in S

        int compIdx = 0; // The start of the substring of seq that we will compare to the strings in S

        for (int i = 0; i < k; i++) { // * k steps

            // * The second dependence on the input. i.e. The length of each array
            int n = S[i].length; // Not assuming that every array in S has the same length

            boolean match = false;

            for (int j = 0; j < n; j++) { // * n * k steps

                int g = S[i][j].length(); // Not assuming that every string has the same length

                // The values we're going to compare
                String subSeq = seq.substring(compIdx, compIdx + g); // ? O(g) What is the complexity of this method?
                String SVal = S[i][j];

                if (SVal.equals(subSeq)) { // ? What is the complexity of this method? O(g)
                    match = true;
                    compIdx += g; // The start of the next piece of the sequence to start comparing
                    break;
                }

            }
            // We did not find a match, this means that the sequence cannot be a proper
            // subsequence
            if (!match)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // This clears the console (on most systems)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String[][] S = { { "cc", "aa" }, { "bb", "aa" }, { "ee", "pp" } };

        String trueSequence = "ccaapp";
        System.out.println(String.format("is %s a subsequence?: %s", trueSequence,
                isSequence(S, trueSequence)));

        String falseSequene = "aaccll";
        System.out.println(String.format("is %s a subsequence?: %s", falseSequene,
                isSequence(S, falseSequene)));
    }
}
