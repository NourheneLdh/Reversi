package reversi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'B';

        while (board.hasValidMoves('B') || board.hasValidMoves('W')) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0-7):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer)) {
                currentPlayer = (currentPlayer == 'B') ? 'W' : 'B';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        board.printBoard();
        int[] scores = board.getScore();
        System.out.println("Game Over! Final Score - B: " + scores[0] + " W: " + scores[1]);
        if (scores[0] > scores[1]) {
            System.out.println("Player B wins!");
        } else if (scores[1] > scores[0]) {
            System.out.println("Player W wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
