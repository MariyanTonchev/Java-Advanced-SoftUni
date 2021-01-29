import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double heiganHealth = 3000000.0;
        int playerHealth = 18500;
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";
        boolean activeCloud = false;
        double damage = Double.parseDouble(scanner.nextLine());
        while (playerHealth > 0 && heiganHealth > 0) {
            heiganHealth -= damage;
            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;
                if (playerHealth < 0) {
                    break;
                }
            }
            if (heiganHealth < 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            boolean[][] matrix = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < matrix.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < matrix[row].length) {
                            matrix[i][j] = true;
                        }
                    }
                }
            }
            if (matrix[playerRow][playerCol]) {
                if (isRowValid(matrix, playerRow - 1) && !matrix[playerRow - 1][playerCol]) {
                    playerRow--;
                } else if (isColValid(matrix, playerCol + 1) && !matrix[playerRow][playerCol + 1]) {
                    playerCol++;
                } else if (isRowValid(matrix, playerRow + 1) && !matrix[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (isColValid(matrix, playerCol - 1) && !matrix[playerRow][playerCol - 1]) {
                    playerCol--;
                }
                if (matrix[playerRow][playerCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            lastSpell = spell;
                            break;
                    }
                }
            }
        }

        if (heiganHealth > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth > 0) {
            System.out.printf("Player: %d%n", playerHealth);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean isRowValid(boolean[][] hsChamber, int startPlRow) {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] hsChamber, int startPlCol) {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }
}