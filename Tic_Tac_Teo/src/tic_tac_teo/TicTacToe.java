package tic_tac_teo;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char firstPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printBoard();

        while (true) {
            playMove(scanner);
            printBoard();

            if (checkWin()) {
                System.out.println("Player " + firstPlayer + " wins!");
                break;
            }

            if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + firstPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = firstPlayer;
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static void switchPlayer() {
        firstPlayer = (firstPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == firstPlayer && board[i][1] == firstPlayer && board[i][2] == firstPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == firstPlayer && board[1][i] == firstPlayer && board[2][i] == firstPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == firstPlayer && board[1][1] == firstPlayer && board[2][2] == firstPlayer) ||
                (board[0][2] == firstPlayer && board[1][1] == firstPlayer && board[2][0] == firstPlayer);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
