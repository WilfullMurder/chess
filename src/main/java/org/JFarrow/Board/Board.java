package org.JFarrow.Board;

import org.JFarrow.Pieces.*;

import java.util.Arrays;

public class Board {
    Square[][] squares = new Square[8][8];
    private final int WHITE = 0;
    private final int BLACK = 1;

    public Board(){
        resetBoard();
    }

    public void resetBoard() {
        squares[0][0] = new Square(0, 0, new Rook(WHITE));
        squares[0][1] = new Square(0, 1, new Knight(WHITE));
        squares[0][2] = new Square(0, 2, new Bishop(WHITE));
        squares[0][3] = new Square(0, 3, new Queen(WHITE));
        squares[0][4] = new Square(0, 4, new King(WHITE));
        squares[0][5] = new Square(0, 2, new Bishop(WHITE));
        squares[0][6] = new Square(0, 1, new Knight(WHITE));
        squares[0][7] = new Square(0, 0, new Rook(WHITE));

        for(int cols = 0; cols < squares[1].length; cols++){
            squares[1][cols] = new Square(1, cols, new Pawn(WHITE));
            squares[6][cols] = new Square(6, cols, new Pawn(BLACK));
        }
        squares[7][0] = new Square(0, 0, new Rook(BLACK));
        squares[7][1] = new Square(0, 1, new Knight(BLACK));
        squares[7][2] = new Square(0, 2, new Bishop(BLACK));
        squares[7][3] = new Square(0, 3, new Queen(BLACK));
        squares[7][4] = new Square(0, 4, new King(BLACK));
        squares[7][5] = new Square(0, 2, new Bishop(BLACK));
        squares[7][6] = new Square(0, 1, new Knight(BLACK));
        squares[7][7] = new Square(0, 0, new Rook(BLACK));

        for(int rows = 2; rows < 6; rows++){
            for(int cols = 0; cols < squares[rows].length; cols++){
                squares[rows][cols] = new Square(rows, cols, null);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            for(int cols = 0; cols < squares.length; cols++){
                for(int rows = 0; rows < squares[cols].length; rows++){
                if(squares[cols][rows].getPiece() == null){
                    builder.append("null ");
                }
                else{
                    builder.append(squares[cols][rows].getPiece().toString()).append(" ");
                }

                if(rows == squares[cols].length - 1){
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    public Square getSquare(int row, int col) {
        return squares[row][col];
    }

    public void setSquare(int row, int col, Piece piece) {
        squares[row][col] = new Square(row, col, piece);
    }
}
