package day1;

public class Tuple<V> {

    private final V entry1;
    private final V entry2;

    public Tuple(V entry1, V entry2) {
        this.entry1 = entry1;
        this.entry2 = entry2;
    }

    public V getEntry1() {
        return entry1;
    }

    public V getEntry2() {
        return entry2;
    }
}
