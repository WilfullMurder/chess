package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.KNIGHT;
import static org.JFarrow.Board.Board.PLAYER_1;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Piece knight;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        knight = new Knight(new PositionComponent(7, 1), new Player(PLAYER_1));
    }

    @Test
    void getMoves() {
        assertTrue(knight.getMoves().size() > 0);
        for(PositionComponent move: knight.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
    }

    @Test
    void getPieceConstant() {
        assertEquals(KNIGHT, knight.getPieceConstant());
    }
}