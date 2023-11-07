package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public class Rook extends GamePiece{
    public Rook(int colour) {
        super(colour);
        setName("Rook");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if(end.getPiece().getColour() == this.getColour()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY()) - end.getY();
        return x>=0 && y == 0 || x == 0 && y>=0;
        //check other move logic
    }
}
