package org.JFarrow.Controllers;

import org.JFarrow.Board.Board;
import org.JFarrow.Core.PositionComponent;
import org.JFarrow.Pieces.King;
import org.JFarrow.Pieces.Piece;
import org.JFarrow.Pieces.Queen;
import org.JFarrow.Pieces.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player1;
    Player player2;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        player1 = new Player(PLAYER_1);
        player2 = new Player(PLAYER_2);
    }
    @Test
    void hasNum(){
        assertEquals(PLAYER_1, player1.getNumber());
        assertEquals(PLAYER_2, player2.getNumber());
    }
    @Test
    void testGetPiece(){
        Piece p = player1.getPiece(new PositionComponent(7,0));
        assertEquals(ROOK, p.getPieceConstant());
    }
    @Test
    void testGetKing(){
        Piece p = player1.getKing();
        assertEquals(KING, p.getPieceConstant());
    }
    @Test
    void testKillAndRevivePiece(){
        Piece p = player1.getPiece(new PositionComponent(7, 0));
        player1.killPiece(p);
        assertFalse(p.isAlive());
        player1.revive(p);
        assertTrue(p.isAlive());
    }
    @Test
    void testPromotePawn(){
        Piece p = new Queen(new PositionComponent(6, 0), player1);
        assertEquals(PAWN + PLAYER_1, board[6][0]);
        player1.promotePawn(p);
        assertEquals(QUEEN + PLAYER_1, board[6][0]);
    }

}