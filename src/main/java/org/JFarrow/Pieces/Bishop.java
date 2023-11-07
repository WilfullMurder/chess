package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public class Bishop extends GamePiece{
    public Bishop(int colour) {
        super(colour);
        setName("Bishop");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if(end.getPiece().getColour() == this.getColour()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY()) - end.getY();
        return x >= 1 && y >= 1;
        //check other move logic
    }
}
