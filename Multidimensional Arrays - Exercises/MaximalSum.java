import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int sum = 0;
                int[][] tempMatrix = new int[3][3];
                int a = 0;
                int b = 0;
                for (int k = i; k <= i + 2; k++) {
                    for (int l = j; l <= j + 2; l++) {
                        sum += matrix[k][l];
                        tempMatrix[a][b] = matrix[k][l];
                        b++;
                    }
                    a++;
                    b = 0;
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    bestMatrix = tempMatrix;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix.length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}