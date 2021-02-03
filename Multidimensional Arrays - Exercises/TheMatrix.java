import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = dimensions[0];
        int C = dimensions[1];
        char[][] matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] arr = scanner.nextLine().replace(" ", "").toCharArray();
            matrix[i] = arr;
        }
        char fillChar = scanner.nextLine().charAt(0);
        int[] startSymbolInfo = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startRow = startSymbolInfo[0];
        int startCol = startSymbolInfo[1];
        char c = matrix[startRow][startCol];
        fill(matrix, startRow, startCol, fillChar, c);
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }
        matrix[row][col] = fillChar;
        if (row + 1 < matrix.length) {
            fill(matrix, row + 1, col, fillChar, startChar);
        }
        if (row - 1 >= 0) {
            fill(matrix, row - 1, col, fillChar, startChar);
        }
        if (col + 1 < matrix[row].length) {
            fill(matrix, row, col + 1, fillChar, startChar);
        }
        if (col - 1 >= 0) {
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }
}