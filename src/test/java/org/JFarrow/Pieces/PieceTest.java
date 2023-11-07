package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.PLAYER_1;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    Piece piece;
    Player player1;

    @BeforeEach
    void setUp() {
        Board.resetBoard();
        player1 = new Player(PLAYER_1);
        piece = new Pawn(new PositionComponent(0,0), player1);
    }


    @Test
    void testDoAndUndoMove() {
        PositionComponent initialPos = piece.getCurrentPosition();
        PositionComponent movePos = new PositionComponent(0, 1);

        piece.doMove(movePos);
        assertNotEquals(initialPos, piece.getCurrentPosition());
        assertEquals(movePos, piece.getCurrentPosition());

        piece.undoMove(piece.getPieceConstant() + player1.getNumber());
        assertNotEquals(movePos, piece.getCurrentPosition());
        assertEquals(initialPos, piece.getCurrentPosition());
    }


    @Test
    void getCurrentPosition() {
        assertNotNull(piece.getCurrentPosition());
    }

    @Test
    void testKillAndRevive() {
        piece.kill();
        assertFalse(piece.isAlive());
        piece.revive();
        assertTrue(piece.isAlive());
    }
}