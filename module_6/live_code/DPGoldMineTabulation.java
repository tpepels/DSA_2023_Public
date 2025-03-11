import java.util.Arrays;

public class DPGoldMineTabulation {

    public static int maxGoldCollected(int[][] mine, int n, int m) {

    }

    public static void main(String[] args) {
        int[][] goldMine = {
                { 1, 0, 0, 8, 0 },
                { 0, 5, 3, 0, 0 },
                { 3, 0, 2, 9, 0 },
                { 0, 7, 0, 8, 0 },
                { 2, 10, 0, 7, 0 }
        };

        int n = goldMine.length;
        int m = goldMine[0].length;

        int maxGold = maxGoldCollected(goldMine, n, m);

        System.out.println("Maximum gold collected: " + maxGold);
    }
}
