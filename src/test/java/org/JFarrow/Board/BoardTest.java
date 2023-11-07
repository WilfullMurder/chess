package org.JFarrow.Board;

import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testResetBoard() {
        Board.resetBoard();
        for (int col = 0; col < board.length; col++) {
            assertEquals(PAWN + PLAYER_2, board[1][col]);
            assertEquals(PAWN + PLAYER_1, board[6][col]);

        }
        assertEquals(ROOK + PLAYER_2, board[0][0]);
        assertEquals(ROOK + PLAYER_2, board[0][7]);
        assertEquals(ROOK + PLAYER_1, board[7][0]);
        assertEquals(ROOK + PLAYER_1, board[7][7]);

        assertEquals(KNIGHT + PLAYER_2, board[0][1]);
        assertEquals(KNIGHT + PLAYER_2, board[0][6]);
        assertEquals(KNIGHT + PLAYER_1, board[7][1]);
        assertEquals(KNIGHT + PLAYER_1, board[7][6]);

        assertEquals(BISHOP + PLAYER_2, board[0][2]);
        assertEquals(BISHOP + PLAYER_2, board[0][5]);
        assertEquals(BISHOP + PLAYER_1, board[7][2]);
        assertEquals(BISHOP + PLAYER_1, board[7][5]);

        assertEquals(QUEEN + PLAYER_2, board[0][3]);
        assertEquals(QUEEN + PLAYER_1, board[7][3]);
        assertEquals(KING + PLAYER_2, board[0][4]);
        assertEquals(KING + PLAYER_1, board[7][4]);
    }

    @Test
    void testDisplayBoard(){
        Board.resetBoard();
        Board.display();
    }
}