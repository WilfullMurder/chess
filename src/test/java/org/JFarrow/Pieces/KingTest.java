package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.KING;
import static org.JFarrow.Board.Board.PLAYER_1;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    Piece king;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        king = new King(new PositionComponent(7,5), new Player(PLAYER_1));
    }

    @Test
    void testNoInitialMoves(){
        assertEquals(0, king.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 5), new Player(PLAYER_1));
        pawn.doMove(new PositionComponent(3, 5));
        assertTrue(king.getMoves().size() > 0);
        for(PositionComponent move: king.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
    }

    @Test
    void getPieceConstant() {
        assertEquals(KING, king.getPieceConstant());
    }

    @Test
    void isCheck() {
    }
}