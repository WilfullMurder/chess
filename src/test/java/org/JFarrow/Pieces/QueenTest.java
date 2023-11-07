package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.PLAYER_1;
import static org.JFarrow.Board.Board.QUEEN;
import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Piece queen;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        queen = new Queen(new PositionComponent(7, 4), new Player(PLAYER_1));
    }

    @Test
    void testNoInitialMoves(){
        assertEquals(0,queen.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 4), new Player(PLAYER_1));
        pawn.doMove(new PositionComponent(3, 4));
        assertTrue(queen.getMoves().size() > 0);
        for(PositionComponent move: queen.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
    }

    @Test
    void getPieceConstant() {
        assertEquals(QUEEN, queen.getPieceConstant());
    }
}