import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int mistakenValue = matrix[dimensions[0]][dimensions[1]];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int up = 0;
                int down = 0;
                int left = 0;
                int right = 0;
                if (i - 1 >= 0) {
                    up = matrix[i - 1][j];
                    if (up == mistakenValue) {
                        up = 0;
                    }
                }
                if (i + 1 <= matrix.length - 1) {
                    down = matrix[i + 1][j];
                    if (down == mistakenValue) {
                        down = 0;
                    }
                }
                if (j - 1 >= 0) {
                    left = matrix[i][j - 1];
                    if (left == mistakenValue) {
                        left = 0;
                    }
                }
                if (j + 1 <= matrix[i].length - 1) {
                    right = matrix[i][j + 1];
                    if (right == mistakenValue) {
                        right = 0;
                    }
                }
                if (matrix[i][j] == mistakenValue) {
                    matrix[i][j] = up + down + right + left;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}