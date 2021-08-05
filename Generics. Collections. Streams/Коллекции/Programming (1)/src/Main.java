import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            for (int i = 0; scanner.hasNext(); i++) {
                if (i==0 || i % 2 == 0) {
                    scanner.nextInt();
                } else {
                    arrayDeque.add(scanner.nextInt());
                }
            }
        scanner.close();
        while (!arrayDeque.isEmpty()) {
            System.out.print(arrayDeque.removeLast() + " ");
        }
    }
}