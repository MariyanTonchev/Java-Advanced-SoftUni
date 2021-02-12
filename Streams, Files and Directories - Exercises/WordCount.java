import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Path wordsTxt = Path.of("E:\\Projects\\words.txt");
        Path textTxt = Path.of("E:\\Projects\\text.txt");
        String result = "E:\\Projects\\write.txt";
        List<String> words = new ArrayList<>();
        String regex = ("[a-zA-Z']+");
        Pattern pattern = Pattern.compile(regex);
        try (PrintWriter printWriter = new PrintWriter(result)){
            String allWordsString = Files.readString(wordsTxt);
            Collections.addAll(words, allWordsString.split(" "));
            String text = Files.readString(textTxt);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                String word = matcher.group();
                if(words.contains(word)){
                  if(!map.containsKey(word)){
                      map.put(word, 1);
                  } else {
                      map.put(word, map.get(word) + 1);
                  }
                }
            }
            map.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).forEach(c -> {
                printWriter.println(c.getKey() + " - " + c.getValue());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
