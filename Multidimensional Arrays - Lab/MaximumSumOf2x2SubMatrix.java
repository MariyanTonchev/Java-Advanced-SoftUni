import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[2][2];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int[][] subMatrix = new int[2][2];
                subMatrix[0][0] = matrix[i][j];
                subMatrix[0][1] = matrix[i][j + 1];
                subMatrix[1][0] = matrix[i + 1][j];
                subMatrix[1][1] = matrix[i + 1][j + 1];
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        sum += subMatrix[k][l];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    bestMatrix = subMatrix;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}