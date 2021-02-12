import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "E:\\Projects\\input.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');
        String path2 = "E:\\Projects\\write.txt";
        try (InputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(path2)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
