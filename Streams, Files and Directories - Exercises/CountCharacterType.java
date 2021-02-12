import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterType {
    public static void main(String[] args) {
        String in = "E:\\Projects\\input.txt";
        String out = "E:\\Projects\\write.txt";
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = new ArrayList<>();
        Collections.addAll(punctuations, '.', ',', '!', '?');
        int v = 0;
        int p = 0;
        int c = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(in));
             PrintWriter printWriter = new PrintWriter(out)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (vowels.contains(ch)) {
                        v++;
                    } else if (punctuations.contains(ch)) {
                        p++;
                    } else {
                        if (ch != ' ') {
                            c++;
                        }
                    }
                }
                line = bufferedReader.readLine();
            }
            printWriter.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d", v, c, p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}