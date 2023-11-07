package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    Piece rook;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        rook = new Rook(new PositionComponent(7, 0), new Player(PLAYER_1));
    }
    @Test
    void testGetConstant(){
        assertEquals(ROOK, rook.getPieceConstant());
    }
    @Test
    void testNoInitialMoves(){
        assertEquals(0,rook.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 0), new Player(PLAYER_1));
        pawn.doMove(new PositionComponent(3, 0));
        assertTrue(rook.getMoves().size() > 0);
        for(PositionComponent move: rook.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        Board.display();
    }
}