import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class ActivitySelection {
    public static void selectActivities(Activity[] activities) {
        // Step 1: Sort the activities by their end time
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        System.out.println("Selected activities are: ");
        // Step 2: Select the first activity
        int lastEndtime = 0;
        for (Activity activity : activities) {
            if (activity.start >= lastEndtime) {
                System.out.println("[" + activity.start + ", " + activity.end + "]");
                lastEndtime = activity.end;
            }
        }

    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(4, 6),
                new Activity(6, 8),
                new Activity(5, 7),
                new Activity(8, 9)
        };

        selectActivities(activities);
    }
}
