import java.util.Stack;
import java.util.Scanner;

public class HanoiTowers {
    private static Stack<Integer>[] towers;
    private static int numDisks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        numDisks = scanner.nextInt();

        // Initialize towers
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }

        // Populate Tower A with disks
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }

        // Print initial state
        System.out.println("Initial state:");
        printTowers();

        // Solve the Tower of Hanoi
        moveDisks(numDisks, 0, 2, 1);
        scanner.close();
    }

    private static void moveDisks(int n, int startTower, int endTower, int tempTower) {
        if (n > 0) {
            moveDisks(n - 1, startTower, tempTower, endTower);

            // Move disk
            int disk = towers[startTower].pop();
            towers[endTower].push(disk);

            System.out.printf("\nMoved disk %d from Tower %c to Tower %c:\n", disk, (char) ('A' + startTower),
                    (char) ('A' + endTower));
            printTowers();

            moveDisks(n - 1, tempTower, endTower, startTower);
        }
    }

    private static void printTowers() {
        for (int i = numDisks - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                printTowerLevel(i, j);
            }
            System.out.println();
        }
        printBaseLabels();
    }

    private static void printTowerLevel(int level, int tower) {
        int width = numDisks * 2 - 1; // Calculate the width for the base of the largest disk
        if (level < towers[tower].size()) {
            int disk = towers[tower].get(level);
            int spaces = (width - (disk * 2 - 1)) / 2; // Center the disk
            System.out.print(" ".repeat(spaces) + "-".repeat(disk * 2 - 1) + " ".repeat(spaces));
        } else {
            System.out.print(" ".repeat(width));
        }
        if (tower < 2) { // Add extra space between towers except after the last one
            System.out.print(" ");
        }
    }

    private static void printBaseLabels() {
        int width = numDisks * 2 - 1; // Width for the largest disk
        int spaces = (width - 1) / 2; // Spaces on each side for the labels
        for (int i = 0; i < 3; i++) {
            System.out.print(" ".repeat(spaces) + (char) ('A' + i) + " ".repeat(spaces));
            if (i < 2) { // Add extra space between labels except after the last one
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
