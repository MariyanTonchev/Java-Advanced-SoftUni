import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String path = "E:\\Projects\\inputLineNumbers.txt";
        String out = "E:\\Projects\\write.txt";
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path));
             PrintWriter printWriter = new PrintWriter(out)) {
            int i = 1;
            String line = bufferedReader.readLine();
            while (line != null) {
                printWriter.println(i + ". " + line);
                i++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
