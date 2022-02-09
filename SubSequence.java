
public class SubSequence {
    public static boolean isSequence(String[][] S, String seq) {

        int n = S.length; // The number of arrays in S

        int compIdx = 0;

        for (int i = 0; i < n; i++) { // n steps

            int k = S[i].length; // Not assuming that every array in S has the same length
            boolean match = false;

            for (int j = 0; j < k; j++) { // k steps

                int slen = S[i][j].length(); // Not assuming that every string has the same length

                // The values we're going to compare
                String subSeq = seq.substring(compIdx, compIdx + slen);
                String SVal = S[i][j];

                if (SVal.equals(subSeq)) { // sLen comparisons (we could take this into consideration as the complexity)
                    match = true;
                    compIdx += slen; // The start of the next piece of the sequence to start comparing
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

        String[][] S = { { "cc", "aa" }, { "bb", "aa" }, { "ee", "pp" } };

        String trueSequence = "ccaapp";
        System.out.println(String.format("is %s a subsequence?: %s", trueSequence,
                isSequence(S, trueSequence)));

        String falseSequene = "aaccll";
        System.out.println(String.format("is %s a subsequence?: %s", falseSequene,
                isSequence(S, falseSequene)));
    }
}
