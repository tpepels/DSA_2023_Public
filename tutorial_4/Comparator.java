package tutorial_4;

public interface Comparator<E> {

    /*
     * if one > other parameter, comp returns > 0
     * if one < other parameter, comp returns < 0
     * else return 0
     */
    public int compare(E one, E other);
}
