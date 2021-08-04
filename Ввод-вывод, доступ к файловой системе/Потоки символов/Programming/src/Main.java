import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inByte = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inByte, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder result = new StringBuilder();
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            int a = inputStreamReader.read();
            while (a != -1) {
                result.append((char) a);
                a = inputStreamReader.read();
            }
        }
        return result.toString();
    }
}