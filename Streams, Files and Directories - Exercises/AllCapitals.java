import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String in = "E:\\Projects\\input.txt";
        String out = "E:\\Projects\\write.txt";
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(in)) ;
             PrintWriter printWriter = new PrintWriter(out)){
            String line = bufferedReader.readLine();
            while (line != null){
                printWriter.println(line.toUpperCase());
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
