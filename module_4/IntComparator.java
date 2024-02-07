package module_4;

public class IntComparator implements Comparator<Integer> {
    /*
     * if one > other parameter, comp returns > 0
     * if one < other parameter, comp returns < 0
     * else return 0
     */
    @Override
    public int compare(Integer one, Integer other) {
        // retrurn one.compareTo(other)
        return one - other;
    }

    public static void main(String[] args) {
        IntComparator comp = new IntComparator();
        System.out.println(comp.compare(1, 2));
        System.out.println(comp.compare(2, 1));
        System.out.println(comp.compare(2, 2));
    }
}
