package org.JFarrow.Board;

import org.JFarrow.Controllers.Controller;
import org.JFarrow.Pieces.Piece;

public class Move {
    private Controller player;
    private Square start;
    private Square end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove;

    public Move(Controller player, Square start, Square end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }
}
