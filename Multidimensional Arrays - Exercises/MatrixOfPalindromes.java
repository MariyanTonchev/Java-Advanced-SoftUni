import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] palindromes = new String[dimensions[0]][dimensions[1]];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int one = i + 97;
                int two = i + j + 97;
                char firstAndLast = (char) one;
                char middle = (char) two;
                String palindrome = Character.toString(firstAndLast) + middle + firstAndLast;
                palindromes[i][j] = palindrome;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(palindromes[i][j] + " ");
            }
            System.out.println();
        }
    }
}