import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            if (data.length == 5) {
                int row1 = Integer.parseInt(data[1]);
                int row2 = Integer.parseInt(data[3]);
                int col1 = Integer.parseInt(data[2]);
                int col2 = Integer.parseInt(data[4]);
                if (row1 > rows || row2 > rows || cols < col2 || cols < col1) {
                    System.out.println("Invalid input!");
                } else {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }
}