package reversi;

public class Board {
    private char[][] board = new char[8][8];

    public Board() {
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '.';
            }
        }
        board[3][3] = 'W';
        board[3][4] = 'B';
        board[4][3] = 'B';
        board[4][4] = 'W';
    }

    public boolean makeMove(int row, int col, char player) {
        if (!isValidMove(row, col, player)) return false;
        board[row][col] = player;
        flipPieces(row, col, player);
        return true;
    }

    public boolean isValidMove(int row, int col, char player) {
        if (row < 0 || col < 0 || row >= 8 || col >= 8 || board[row][col] != '.') return false;

        char opponent = (player == 'B') ? 'W' : 'B';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] d : directions) {
            int r = row + d[0], c = col + d[1];
            boolean seenOpponent = false;
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == opponent) {
                    seenOpponent = true;
                } else if (board[r][c] == player && seenOpponent) {
                    return true;
                } else break;
                r += d[0];
                c += d[1];
            }
        }
        return false;
    }

    public void flipPieces(int row, int col, char player) {
        char opponent = (player == 'B') ? 'W' : 'B';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] d : directions) {
            int r = row + d[0], c = col + d[1];
            boolean seenOpponent = false;
            int[][] toFlip = new int[8][2];
            int count = 0;
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == opponent) {
                    toFlip[count++] = new int[]{r, c};
                    seenOpponent = true;
                } else if (board[r][c] == player && seenOpponent) {
                    for (int i = 0; i < count; i++) {
                        board[toFlip[i][0]][toFlip[i][1]] = player;
                    }
                    break;
                } else break;
                r += d[0];
                c += d[1];
            }
        }
    }

    public boolean hasValidMoves(char player) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (isValidMove(i, j, player))
                    return true;
        return false;
    }

    public int[] getScore() {
        int[] score = new int[2];
        for (char[] row : board)
            for (char cell : row) {
                if (cell == 'B') score[0]++;
                if (cell == 'W') score[1]++;
            }
        return score;
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < 8; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public char getPiece(int row, int col) {
        return board[row][col];
    }
}
