package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    Piece king;
    Player player_1;
    Player player_2;
    @BeforeEach
    void setUp() {
        Board.resetBoard();
        player_1 = new Player(PLAYER_1);
        player_2 = new Player(PLAYER_2);
        king = new King(new PositionComponent(7,4), player_1);
    }

    @Test
    void testNoInitialMoves(){
        assertEquals(0, king.getMoves().size());
    }

    @Test
    void testMoveAfterPawn() {
        Piece pawn = new Pawn(new PositionComponent(6, 4), player_1);
        pawn.doMove(new PositionComponent(3, 4));
        assertTrue(king.getMoves().size() > 0);

    }
    @Test
    void testKingSideCastling(){
        Piece pawn = new Pawn(new PositionComponent(6, 4), player_1);
        pawn.doMove(new PositionComponent(3, 4));
        Piece bishop = new Bishop(new PositionComponent(7, 5), player_1);
        bishop.doMove(new PositionComponent(5, 3));
        Piece knight = new Knight(new PositionComponent(7, 6), player_1);
        knight.doMove(new PositionComponent(5, 5));
        assertTrue(king.getMoves().size() > 0);

        System.out.println("Testing king side castling");
        for(PositionComponent move: king.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        System.out.println();
    }

    @Test
    void testQueenSideCastling(){
        Piece pawn = new Pawn(new PositionComponent(6, 3), player_1);
        pawn.doMove(new PositionComponent(4, 3));
        Piece bishop = new Bishop(new PositionComponent(7, 2), player_1);
        bishop.doMove(new PositionComponent(4, 6));
        Piece knight = new Knight(new PositionComponent(7, 1), player_1);
        knight.doMove(new PositionComponent(5, 2));
        Piece queen = new Queen(new PositionComponent(7, 3), player_1);
        queen.doMove(new PositionComponent(5, 3));
        assertTrue(king.getMoves().size() > 0);

        System.out.println("Testing Queen side castling");
        for(PositionComponent move: king.getMoves()){
            System.out.println();
            System.out.println(move.toString());
        }
        System.out.println();
    }

    @Test
    void getPieceConstant() {
        assertEquals(KING, king.getPieceConstant());
    }

    @Test
    void testCheckByKnight(){
        Piece p2Knight = new Knight(new PositionComponent(0, 2), player_2);
        p2Knight.doMove(new PositionComponent(5, 3));
        Board.display();
        King k = (King) king;
        assertTrue(k.isCheck());
    }

    @Test
    void testCheckByBishop(){
        Piece p1Pawn = new Pawn(new PositionComponent(6, 3), player_1);
        p1Pawn.doMove(new PositionComponent(3, 3));
        Piece p2Bishop = new Bishop(new PositionComponent(0, 2), player_2);
        p2Bishop.doMove(new PositionComponent(4, 1));
        Board.display();
        King k = (King) king;
        assertTrue(k.isCheck());
    }
    @Test
    void testCheckByQueen(){
        Piece p1Pawn = new Pawn(new PositionComponent(6, 3), player_1);
        p1Pawn.doMove(new PositionComponent(3, 3));
        Piece p2Queen = new Queen(new PositionComponent(0, 3), player_2);
        p2Queen.doMove(new PositionComponent(4, 1));
        Board.display();
        King k = (King) king;
        assertTrue(k.isCheck());
    }
    @Test
    void testCheckByRook(){
        movePlayerOnePiecesForRookCheck();
        movePlayerTwoPiecesForPawnCheck();
        Board.display();
        King k = (King) king;
        assertTrue(k.isCheck());
    }

    void movePlayerOnePiecesForRookCheck(){
        Piece p1Pawn1 = new Pawn(new PositionComponent(6, 3), player_1);
        p1Pawn1.doMove(new PositionComponent(3, 3));
        Piece p1Pawn2 = new Pawn(new PositionComponent(6, 4), player_1);
        p1Pawn2.doMove(new PositionComponent(4, 4));
        for(int row = 6; row < board.length; row++){
            for(int col = 5; col < board[row].length; col++){
                board[row][col] = EMPTY;
            }
        }
    }

    void movePlayerTwoPiecesForPawnCheck(){
        board[1][7] = EMPTY;
        Piece p2Rook = new Rook(new PositionComponent(0, 7), player_2);
        p2Rook.doMove(new PositionComponent(7, 7));
    }

    @Test
    void testCheckByPawn(){
        board[6][3] = EMPTY;
        Piece pawn = new Pawn(new PositionComponent(1, 3), player_2);
        pawn.doMove(new PositionComponent(6, 3));
        Board.display();
        King k = (King) king;
        assertTrue(k.isCheck());
    }

}