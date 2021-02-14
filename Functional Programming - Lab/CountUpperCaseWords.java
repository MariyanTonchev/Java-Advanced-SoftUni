import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split("\\s+");
        List<String> upperCaseWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));
            if (isUpperCase.test(words[i])) {
                upperCaseWords.add(words[i]);
            }
        }
        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(a -> System.out.println(a));
    }
}