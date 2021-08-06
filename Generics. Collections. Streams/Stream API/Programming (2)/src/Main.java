import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            File directory = new File("folder");
//            directory.mkdir();
            File file = new File("folder", "strings.txt");
//            file.createNewFile();
            InputStream inputStream = new FileInputStream(file);
            System.setIn(inputStream);
//            Files.lines(Paths.get("folder.txt"));
            String[] arrayOfStrings = new String[1];
            arrayOfStrings[0] = DataInputStream.readUTF(new DataInputStream(System.in));
            Set<String> set = Arrays.stream(arrayOfStrings)
                    .collect(Collectors.toSet());
            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}