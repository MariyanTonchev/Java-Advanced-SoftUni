import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];
        for (int i = 0; i < firstMatrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }
        dimensions = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRows = dimensions[0];
        int secondMatrixCols = dimensions[1];
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];
        for (int i = 0; i < secondMatrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }
        if (compareMatrices(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                return false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}