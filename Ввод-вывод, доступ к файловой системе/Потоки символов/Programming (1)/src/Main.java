import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        File directory = new File("folder");
//        directory.mkdir();
        File file = new File("folder", "digits.txt");
        InputStream inputStream = new FileInputStream(file);
//        try {
//            file.createNewFile();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        System.setIn(inputStream);
        double x = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                x += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.format("%.6f", x);
    }
}
