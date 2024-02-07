package module_2.lecture_notes;

public class AlgorithmAnalysis {

    public void timeMethod() {
        long startTime = System.currentTimeMillis();
        // algorithm goes here
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
    }

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) { // 3n + 2
            if (arr[i] == target) { // n * 3
                return i; // 1
            }
        }
        return -1; // 1
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void bubbleSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

}