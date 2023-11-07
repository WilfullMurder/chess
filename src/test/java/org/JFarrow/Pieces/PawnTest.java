package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    Piece pawn;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        pawn = new Pawn(new PositionComponent(6, 1), new Player(PLAYER_1));
    }
    @Test
    void testPieceConstant(){
        assertEquals(PAWN, pawn.getPieceConstant());
    }

    @Test
    void getMoves() {
        assertTrue(pawn.getMoves().size() > 0);
        for(PositionComponent move: pawn.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
    }
}