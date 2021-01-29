import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        if (pattern.equals("A")){
            patternA(n);
        } else if (pattern.equals("B")){
            patternB(n);
        }
    }

    public static void patternA(int n) {
        int[][] matrix = new int[n][n];
        int k = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = k++;
            }
        }
        PrintMatrix(matrix);
    }

    public static void patternB(int n) {
        int[][] matrix = new int[n][n];
        int k = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = k;
                    k++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[i][j] = k;
                    k++;
                }
            }
        }
        PrintMatrix(matrix);
    }

    private static void PrintMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}