import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new TreeSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        System.out.println(symmetricDifference(Collections.unmodifiableSet(set1),Collections.unmodifiableSet(set2)));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<>();
        for (T firstSetElement : set1) {
            if (!set2.contains(firstSetElement)) {
                resultSet.add(firstSetElement);
            }
        }
        for (T secondSetElement : set2) {
            if (!set1.contains(secondSetElement)) {
                resultSet.add(secondSetElement);
            }
        }
//        for (T firstSetElement : set1) {
//            boolean firstElementInResultSet = false;
//            for (T secondSetElement : set2) {
//                if (firstSetElement.equals(secondSetElement)) {
//                    firstElementInResultSet = false;
//                    break;
//                } else {
//                    firstElementInResultSet = true;
//                }
//            }
//            if (firstElementInResultSet) {
//                resultSet.add(firstSetElement);
//            }
//        }
//
//        for (T secondSetElement : set2) {
//            boolean secondElementInResultSet = false;
//            for (T firstSetElement : set1) {
//                if (secondSetElement.equals(firstSetElement)) {
//                    secondElementInResultSet = false;
//                    break;
//                } else {
//                    secondElementInResultSet = true;
//                }
//            }
//            if (secondElementInResultSet) {
//                resultSet.add(secondSetElement);
//            }
//        }

        return resultSet;
    }
}
