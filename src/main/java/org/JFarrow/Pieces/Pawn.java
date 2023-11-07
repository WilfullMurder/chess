package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public class Pawn extends GamePiece{
    public Pawn(int colour) {
        super(colour);
        setName("Pawn");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if(end.getPiece().getColour() == this.getColour()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x == 0 && y == 1;
        //check other movement logic
    }
}
