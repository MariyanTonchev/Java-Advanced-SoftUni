import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] A = new char[rows][cols];
        char[][] B = new char[rows][cols];
        char[][] C = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            A[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        for (int i = 0; i < rows; i++) {
            B[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(A[i][j] == B[i][j]){
                    C[i][j] = A[i][j];
                } else {
                    C[i][j] = '*';
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}