package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.List;

import static org.JFarrow.Board.Board.QUEEN;

public class Queen extends GamePiece{

    public Queen(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        return null;
    }

    @Override
    public String getPieceConstant() {
        return QUEEN;
    }
}
