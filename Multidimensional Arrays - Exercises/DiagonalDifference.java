import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int primarySum = 0;
        int secondarySum = 0;
        for (int i = 0; i < n; i++) {
            primarySum += matrix[i][i];
            secondarySum += matrix[n - 1 - i][i];
        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
