package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    Piece bishop;

    @BeforeEach
    void setUp() {
        Board.resetBoard();
        bishop = new Bishop(new PositionComponent(7, 2), new Player(PLAYER_1));
    }
    @Test
    void testNoInitialMoves(){
        assertEquals(0, bishop.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 1), new Player(PLAYER_1));
        pawn.doMove(new PositionComponent(3, 1));
        assertTrue(bishop.getMoves().size() > 0);
        System.out.println("Opening moves after pawn has moved");
        for(PositionComponent move: bishop.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
    }
    @Test
    void testMovesWithMultipleOpenings() {
        Piece pawn1 = new Pawn(new PositionComponent(6, 1), new Player(PLAYER_1));
        pawn1.doMove(new PositionComponent(3, 1));
        Piece pawn2 = new Pawn(new PositionComponent(6, 3), new Player(PLAYER_1));
        pawn2.doMove(new PositionComponent(3, 3));
        assertTrue(bishop.getMoves().size() > 0);
        System.out.println("Moves available with two openings:");
        for(PositionComponent move: bishop.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        display();
    }

    @Test
    void getPieceConstant() {
        assertEquals(BISHOP, bishop.getPieceConstant());
    }
}