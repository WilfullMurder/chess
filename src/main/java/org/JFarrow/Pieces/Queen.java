package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public class Queen extends GamePiece{
    public Queen(int colour) {
        super(colour);
        setName("Queen");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if(end.getPiece().getColour() == this.getColour()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY()) - end.getY();
        return x >= 0 || y >= 0;
        //check other movement logic
    }
}
