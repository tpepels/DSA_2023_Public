public class GoldMineTest {

    public static void main(String[] args) {

        int[][] mine = {
                { 5, 10, 2, 5 },
                { 20, 6, 7, 9 },
                { 10, 2, 0, 8 },
                { 5, 20, 8, 2 }
        };

        int DPResult = DPGoldMine.maxGoldCollected(mine, 4, 4, 2);
        int simpleResult = SimpleGoldMine.maxGoldCollected(mine, 4, 4, 2);

        System.out.println("The simple recursive approach result: " + simpleResult + " needed "
                + SimpleGoldMine.recursions + " recursive calls.");

        System.out.println("The dynamic programming approach result: " + DPResult + " needed "
                + DPGoldMine.recursions + " recursive calls.");
    }

}
