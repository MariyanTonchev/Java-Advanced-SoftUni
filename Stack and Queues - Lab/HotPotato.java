import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();
        String[] kidArray = scanner.nextLine().split("\\s+");
        Collections.addAll(kids, kidArray);
        int toss = Integer.parseInt(scanner.nextLine());
        while (kids.size() > 1) {
            for (int i = 1; i < toss; i++) {
                kids.offer(Objects.requireNonNull(kids.pollFirst()));
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.poll());
    }
}