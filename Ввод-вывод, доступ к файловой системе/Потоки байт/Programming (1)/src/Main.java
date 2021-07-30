import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        byte[] arr = {65, 13, 10, 10, 13};
        ByteArrayInputStream inputStream0 = new ByteArrayInputStream(arr);
        System.setIn(inputStream0);
        try (InputStream inputStream = System.in) {
            byte[] array = new byte[1];
            int count = inputStream.read(array);
            List<Byte> arrayList = new ArrayList();
            while (count > 0) {
                for (byte b : array) {
                    arrayList.add(b);
                }
                count = inputStream.read(array);
            }
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i).equals((byte) 13) && arrayList.get(i + 1).equals((byte) 10)) {
                    arrayList.remove(i);
                }
            }
            for (Object o : arrayList) {
                System.out.write((byte) o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}