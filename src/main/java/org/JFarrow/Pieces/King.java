package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public class King extends GamePiece{
    private boolean castled;

    public King(int colour) {
        super(colour);
        setName("King");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if(end.getPiece().getColour() == this.getColour()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY()) - end.getY();
        if(x + y == 1){
            //check if move leads to king in check
            return true;
        }
        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Square start, Square end) {
        if(castled){
            return false;
        }
        //Logic for t/f
        return true;
    }

    public boolean isCastlingMove(Square start, Square end){
        //check for valid castling move
        return false;
    }

    public boolean isCastled() {
        return castled;
    }

    public void setCastled(boolean castled) {
        this.castled = castled;
    }


}
