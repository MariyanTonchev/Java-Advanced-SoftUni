import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String path1 = "E:\\Projects\\inputOne.txt";
        String path2 = "E:\\Projects\\inputTwo.txt";
        String writePath = "E:\\Projects\\write.txt";
        combine(path1, path2, writePath);
    }

    private static void combine(String readPath1,String readPath2, String writePath) {
        try (BufferedReader bufferedReader1 = Files.newBufferedReader(Paths.get(readPath1));
             BufferedReader bufferedReader2 = Files.newBufferedReader(Paths.get(readPath2));
             PrintWriter printWriter = new PrintWriter(writePath)) {
            String line1 = bufferedReader1.readLine();
            while (line1 != null) {
                printWriter.println(line1);
                line1 = bufferedReader1.readLine();
            }
            String line2 = bufferedReader2.readLine();
            while (line2 != null) {
                printWriter.println(line2);
                line2 = bufferedReader2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
