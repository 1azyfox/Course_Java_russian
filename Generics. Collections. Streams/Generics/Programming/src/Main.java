import java.util.Objects;

class Pair <T,K> {
    private T element1;
    private K element2;

    public T getFirst() {
        return (T) element1;
    }

    public K getSecond() {
        return (K) element2;
    }

    private Pair (T element1, K element2) {
        this.element1 = (T) element1;
        this.element2 = (K) element2;
    }

    public static <T, K> Pair<T, K> of (T element1, K element2) {
//        if (element1 == null && element2 == null) {
//            throw new NoSuchElementException("No element present");
//        }
        return new Pair<>(element1,element2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(element1, pair.element1) && Objects.equals(element2, pair.element2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element1, element2);
    }
}