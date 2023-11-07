package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public interface Piece {
    boolean canMove(Board board, Square start, Square end);
    void setKilled(boolean killed);
    boolean isKilled();
    int getColour();

}
