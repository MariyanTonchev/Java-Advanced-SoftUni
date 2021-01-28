import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] squareMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            squareMatrix[i] = arr;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(squareMatrix[i][i] + " ");
        }
        System.out.println();
        int k = n;
        for (int i = 0; i < n; i++) {
            System.out.print(squareMatrix[k - 1][i] + " ");
            k--;
        }
    }
}