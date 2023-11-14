package org.JFarrow.Pieces;

import org.JFarrow.Core.PositionComponent;

import java.util.List;


public interface Piece {
    List<PositionComponent> getMoves();
    String getPieceConstant();
    void doMove(PositionComponent end);
    void undoMove(String piece);
    PositionComponent getCurrentPosition();
    void kill();
    void revive();
    boolean isAlive();


}
