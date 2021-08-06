import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       pseudoRandomStream(13).limit(100).mapToObj(x -> " " + x).forEach(System.out::print);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return Stream.iterate(seed, n -> (( (n *n) / 10) % 1000)).mapToInt(n ->n);
    }
}
