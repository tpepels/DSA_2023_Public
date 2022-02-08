import java.util.Random;

public class RandomArray {

    public static int[] randomArray(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rd.nextInt(100);
        return arr;
    }

    public static void main(String[] args) {
        int[] randomArr = randomArray(10);
        System.out.println(java.util.Arrays.toString(randomArr));
    }
}
