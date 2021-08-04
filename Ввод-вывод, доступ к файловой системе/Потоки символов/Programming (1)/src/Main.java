import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = reader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (a != -1) {
                stringBuilder.append(a);
                try {
                    double x = Double.parseDouble(stringBuilder.toString());
                } catch (NumberFormatException ex) {

                }
                a = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}