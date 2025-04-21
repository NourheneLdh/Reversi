package reversi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testInitialization() {
        Board board = new Board();
        int[] score = board.getScore();
        assertEquals(2, score[0]);
        assertEquals(2, score[1]);
    }

    @Test
    void testValidMove() {
        Board board = new Board();
        assertTrue(board.isValidMove(2, 3, 'B'));
        assertFalse(board.isValidMove(0, 0, 'B'));
    }

    @Test
    void testMakeMove() {
        Board board = new Board();
        assertTrue(board.makeMove(2, 3, 'B'));
        assertTrue(board.getScore()[0] > 2);
    }

    @Test
    void testMakeMoveAndFlip() {
        Board board = new Board();
        board.makeMove(2, 3, 'B');
        int[] score = board.getScore();
        assertTrue(score[0] > 2);
    }

    @Test
    void testInvalidMoveDoesNotChangeBoard() {
        Board board = new Board();
        board.makeMove(0, 0, 'B');
        assertEquals('.', board.getPiece(0, 0));
    }

    @Test
    void testNoValidMoves() {
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.makeMove(i, j, 'B');
            }
        }
        assertFalse(board.hasValidMoves('W'));
    }
}
