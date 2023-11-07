package org.JFarrow.Pieces;

import org.JFarrow.Board.Board;
import org.JFarrow.Board.Square;
import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.KING;

public class King extends GamePiece{


    public King(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return KING;
    }

    public boolean isCheck() {
        return false;
    }
}
