package org.JFarrow.Board;

import org.JFarrow.Core.PositionComponent;
import org.JFarrow.Pieces.Piece;

import java.util.Arrays;

public class Board {
    public static final String BISHOP = "B";
    public static final String KING = "K";
    public static final String KNIGHT = "N";
    public static final String PAWN = "P";
    public static final String QUEEN = "Q";
    public static final String ROOK = "R";
    public static final String PLAYER_1 = "1";
    public static final String PLAYER_2 = "2";
    public static final String EMPTY = "-";
    public static String[][] board = new String[8][8];
    public static void resetBoard() {

        for (String[] strings : board) {
            Arrays.fill(strings, EMPTY);
        }
        setInitialBoardPieces();
    }


    private static void setInitialBoardPieces() {
        for(int col = 0; col < board.length; col++){
            board[1][col] = PAWN + PLAYER_2;
            board[6][col] = PAWN + PLAYER_1;
            switch (col) {
                case 0 -> setPiece(col, ROOK);
                case 1 -> setPiece(col, KNIGHT);
                case 2 -> setPiece(col, BISHOP);
            }
        }
        Board.board[0][3] = QUEEN + PLAYER_2;
        Board.board[7][3] = QUEEN + PLAYER_1;
        Board.board[0][4] = KING + PLAYER_2;
        Board.board[7][4] = KING + PLAYER_1;
    }

    private static void setPiece(int col, String piece) {
        board[0][col] = piece + PLAYER_2;
        board[0][7-col] = piece + PLAYER_2;
        board[7][col] = piece + PLAYER_1;
        board[7][7-col] = piece + PLAYER_1;
    }


    public static void display() {
        System.out.println();
        for (String[] places : board) {
            for (String string : places) {
                System.out.print(string + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public static boolean isEmpty(PositionComponent position){
        return board[position.intX()][position.intY()].equals(EMPTY);
    }
}
