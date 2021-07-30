import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        final byte[] data = {0x33, 0x45, 0x01};
        final byte[] data2 = {};

        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            System.out.println(checkSumOfStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream2 = new ByteArrayInputStream(data2)) {
            System.out.println(checkSumOfStream(inputStream2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        for(int i = inputStream.read(); i != -1; i = inputStream.read()) {
            int c = Integer.rotateLeft(result,1);
            result = c ^ i;
        }
        return result;
//        if (inputStream.available() == 0) {
//            return 0;
//        }
//        int a=inputStream.available();
//        int[] data = new int[a];
//        for (int j =0; j < a; j ++) {
//            data[j] = inputStream.read();
//        }
//        int result = 0;
//        for (int i = 0; i < data.length - 1; i++) {
//            int c = ((Integer.rotateLeft(data[i+1],1)));
//            int b = data[i];
//            result = c ^ b;
//        }
//        return result;
    }
}
