import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int elem = 0; elem < matrix[row].length; elem++) {
                char currentElement = matrix[row][elem];
                if (currentElement == 'q') {
                    if (check(matrix, row, elem)) {
                        System.out.print(row + " ");
                        System.out.print(elem);
                    }
                }
            }
        }
    }

    private static boolean check(char[][] chessTable, int row, int element) {
        for (int i = element + 1; i < chessTable[row].length; i++) {
            char charToCheck = chessTable[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = element - 1; i >= 0; i--) {
            char charToCheck = chessTable[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = row + 1; i < chessTable.length; i++) {
            char charToCheck = chessTable[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            char charToCheck = chessTable[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int uldElement = element - 1;
        for (int i = row - 1; i >= 0 && uldElement >= 0; i--, uldElement--) {
            char charToCheck = chessTable[i][uldElement];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int element2 = element + 1;
        for (int i = row - 1; i >= 0 && element2 < chessTable[i].length; i--, element2++) {
            char charToCheck = chessTable[i][element2];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int element3 = element - 1;
        for (int i = row + 1; i < chessTable.length && element3 >= 0; i++, element3--) {
            char charToCheck = chessTable[i][element3];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int element4 = element + 1;
        for (int i = row + 1; i < chessTable.length && element4 < chessTable[row].length; i++, element4++) {
            char charToCheck = chessTable[i][element4];
            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }
}