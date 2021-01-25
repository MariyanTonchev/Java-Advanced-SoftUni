import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();
        String[] kidArray = scanner.nextLine().split("\\s+");
        Collections.addAll(kids, kidArray);
        int toss = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < toss; i++) {
                kids.offer(Objects.requireNonNull(kids.pollFirst()));
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int n) {
        boolean primeCheck = true;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    primeCheck = false;
                    break;
                }
            }
            return primeCheck;
        }
    }
}