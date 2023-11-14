package org.JFarrow.Pieces;

import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.*;

public class Knight extends GamePiece{

    public Knight(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        //up 1, right 2
        PositionComponent destination = new PositionComponent(x+1, y+2);
        if(x < 7 && y < 6 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x < 7 && y < 6 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x + 1][y + 2].substring(1))) {
            String piece = board[x + 1][y + 2];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        //down 1, right 2
        destination = new PositionComponent(x-1, y+2);
        if(x > 0 && y < 6 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x > 0 && y < 6 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x - 1][y + 2].substring(1))) {
            String piece = board[x - 1][y + 2];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // down 2, left 1
        destination = new PositionComponent(x+2, y-1);
        if(x < 6 && y > 0 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x < 6 && y > 0 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x + 2][y - 1].substring(1))) {
            String piece = board[x + 2][y - 1];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // down 2, right 1
        destination = new PositionComponent(x + 2, y + 1);
        if(x < 6 && y < 7 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x < 6 && y < 7 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x + 2][y + 1].substring(1))) {
            String piece = board[x + 2][y + 1];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // down 1, left 2
        destination = new PositionComponent(x + 1, y - 2);
        if(x < 7 && y > 1 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x < 7 && y > 1 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x + 1][y - 2].substring(1))) {
            String piece = board[x + 1][y - 2];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // up 1, left 2
        destination = new PositionComponent(x - 1, y - 2);
        if(x > 0 && y > 1 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x > 0 && y > 1 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x - 1][y - 2].substring(1))) {
            String piece = board[x - 1][y - 2];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // up 2, left 1
        destination = new PositionComponent(x - 2, y - 1);
        if(x > 1 && y > 0 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x > 1 && y > 0 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x - 2][y - 1].substring(1))) {
            String piece = board[x - 2][y - 1];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        // up 2, right 1
        destination = new PositionComponent(x - 2, y + 1);
        if(x > 1 && y < 7 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
        }
        if (x > 1 && y < 7 && !isEmpty(destination) && !getOwner().getNumber().equals(board[x - 2][y + 1].substring(1))) {
            String piece = board[x - 2][y + 1];
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return KNIGHT;
    }
}
