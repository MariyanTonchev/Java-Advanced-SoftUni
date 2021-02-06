import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class VoinaCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> playerOne = new LinkedHashSet<>();
        LinkedHashSet<Integer> playerTwo = new LinkedHashSet<>();
        int[] playerOneCards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int playerOneCard : playerOneCards) {
            playerOne.add(playerOneCard);
        }
        int[] playerTwoCards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int playerTwoCard : playerTwoCards) {
            playerTwo.add(playerTwoCard);
        }
        for (int i = 0; i < 50; i++) {
            int first = playerOne.iterator().next();
            playerOne.remove(first);
            int second = playerTwo.iterator().next();
            playerTwo.remove(second);
            if (first > second) {
                playerOne.add(first);
                playerOne.add(second);
            } else if (second > first) {
                playerTwo.add(first);
                playerTwo.add(second);
            }
        }
        if (playerOne.size() > playerTwo.size()){
            System.out.println("First player win!");
        } else if (playerOne.size() < playerTwo.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}