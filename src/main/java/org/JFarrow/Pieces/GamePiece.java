package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;

public abstract class GamePiece implements Piece{
    private boolean killed;
    private final int colour;
    private String name;
    public GamePiece(int colour){
        this.colour = colour;
    }

    @Override
    public abstract boolean canMove(Board board, Square start, Square end);

    @Override
    public boolean isKilled() {
        return killed;
    }

    @Override
    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    @Override
    public int getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
