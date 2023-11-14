package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.List;

import static org.JFarrow.Board.Board.EMPTY;

public abstract class GamePiece implements Piece{
    protected PositionComponent lastPosition, currentPosition;
    private boolean alive;
    private final Player owner;

    public GamePiece(PositionComponent currentPosition, Player owner){
        lastPosition = null;
        this.currentPosition = currentPosition;
        this.owner = owner;
        alive = true;

    }

    @Override
    public abstract List<PositionComponent> getMoves();

    @Override
    public abstract String getPieceConstant();

    @Override
    public void doMove(PositionComponent end) {
        Board.board[end.intX()][end.intY()] = getPieceConstant() + owner.getNumber();
        Board.board[currentPosition.intX()][currentPosition.intY()] = EMPTY;
        lastPosition = currentPosition;
        currentPosition = end;
    }

    @Override
    public void undoMove(String piece) {
        Board.board[lastPosition.intX()][lastPosition.intY()] = getPieceConstant() + owner.getNumber();
        Board.board[currentPosition.intX()][currentPosition.intY()] = piece;
        currentPosition = lastPosition;
        lastPosition = null;

    }

    @Override
    public PositionComponent getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void kill() {
        alive = false;
    }

    @Override
    public void revive() {
        alive = true;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return getClass().getTypeName() + "@" + currentPosition;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof GamePiece p){
            return p.lastPosition == this.lastPosition && p.currentPosition == this.currentPosition;
        }
        return false;
    }

    public Player getOwner() {
        return owner;
    }
}
