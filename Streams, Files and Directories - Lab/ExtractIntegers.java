import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "E:\\Projects\\input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Scanner reader = new Scanner(fileInputStream);
            while (reader.hasNext()) {
                if (reader.hasNextInt()) {
                    System.out.println(reader.nextInt());
                }
                reader.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
