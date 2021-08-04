import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int next = 0;
        int prev = System.in.read();
        while (prev != -1) {
            next = System.in.read();
            if (prev != 13 || next != 10) {
                System.out.write(prev);
            }
            prev = next;
        }
        System.out.flush();
//        byte[] arr = {13, 13, 10}; //65, 66, 13, 10, 10, 13, 67, 13, 13
//        ByteArrayInputStream inputStream0 = new ByteArrayInputStream(arr);
//        System.setIn(inputStream0);
//        for (; ; ) {
//            again:
//            {
//                int first = System.in.read();
//                {
//                    if (first == -1) {
//                        break;
//                    }
//                    if (first == 13) there:{
//                        int next = System.in.read();
//                        if (next == -1) {
//                            System.out.print(first);
//                            break;
//                        }
//                        if (next == 10) {
//                            first = next;
//                            break there;
//                        }
//                        if (next == 13) {
//                            first = next;
//                            System.out.print(first);
//                            break again;
//                        }
//                        System.out.print(next);
//                    }
//                    System.out.print(first);
//                }
//            }
//        }
//        System.out.flush();
    }
}