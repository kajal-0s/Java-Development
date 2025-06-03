import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static final char EMPTY = ' ';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        boolean playAgain;

        do {
            initializeBoard();
            playGame();
            System.out.print("Play again? (y/n): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("y");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    private static void playGame() {
        char currentPlayer = 'X';
        int movesMade = 0;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 1 for top-left): ");

            int row = -1, col = -1;
            while (true) {
                String input = scanner.nextLine();
                String[] parts = input.trim().split("\\s+");
                if (parts.length != 2) {
                    System.out.println("Invalid input. Please enter two numbers separated by space.");
                    continue;
                }
                try {
                    row = Integer.parseInt(parts[0]) - 1;
                    col = Integer.parseInt(parts[1]) - 1;
                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Invalid move. Row and column must be between 1 and 3.");
                    } else if (board[row][col] != EMPTY) {
                        System.out.println("Cell already taken. Choose another.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numbers only.");
                }
            }

            board[row][col] = currentPlayer;
            movesMade++;

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (movesMade == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
        }
    }

    private static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
