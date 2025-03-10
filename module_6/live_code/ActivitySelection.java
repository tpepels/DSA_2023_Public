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
