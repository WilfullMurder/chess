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
    Player player;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        player = new Player(PLAYER_1);
        queen = new Queen(new PositionComponent(7, 3), player);
    }

    @Test
    void testNoInitialMoves(){
        assertEquals(0,queen.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 3), player);
        pawn.doMove(new PositionComponent(3, 3));
        assertTrue(queen.getMoves().size() > 0);
        for(PositionComponent move: queen.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        Board.display();
    }
    @Test
    void testMoveThroughMultipleOpenings(){
        Piece pawn1 = new Pawn(new PositionComponent(6, 3), player);
        pawn1.doMove(new PositionComponent(3, 3));
        Piece pawn2 = new Pawn(new PositionComponent(6, 4), player);
        pawn2.doMove(new PositionComponent(3, 4));
        Piece pawn3 = new Pawn(new PositionComponent(6, 2), player);
        pawn3.doMove(new PositionComponent(3, 2));
        assertTrue(queen.getMoves().size() > 0);
        for(PositionComponent move: queen.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        Board.display();
    }

    @Test
    void getPieceConstant() {
        assertEquals(QUEEN, queen.getPieceConstant());
    }
}