package org.JFarrow.Pieces;

import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.*;

public class Bishop extends GamePiece{

    public Bishop(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        int x = currentPosition.intX();
        int y = currentPosition.intY();
        PositionComponent destination = new PositionComponent(x+1, y+1);

        // check up right diagonal
        while(x < 7 && y < 7 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
            x++;
            y++;
            destination = new PositionComponent(x+1, y+1);
        }
        destination = new PositionComponent(x+1, y+1);
        if(x < 7 && y < 7 && !getOwner().getNumber().equals(board[x+1][y+1].substring(1))){
            String piece = board[x+1][y+1];
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        //check up left diagonal
        destination = new PositionComponent(x + 1, y - 1);
        while( x < 7 && y > 0 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
            x++;
            y--;
            destination = new PositionComponent(x+1, y-1);
        }
        destination = new PositionComponent(x+1, y-1);
        if(x < 7 && y > 0 && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))){
            String piece = board[x+1][y-1];
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        //check downright diagonal
        destination = new PositionComponent(x-1, y+1);
        while(x > 0 && y < 7 && isEmpty(destination)){
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
            x--;
            y++;
            destination = new PositionComponent(x-1, y+1);
        }
        if(x > 0 && y < 7 && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))){
            String piece = board[x-1][y+1];
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        //check down left diagonal
        destination = new PositionComponent(x-1, y-1);
        while(x > 0 && y > 0 && isEmpty(destination)){
            doMove(destination);
            if (!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(EMPTY);
            x--;
            y--;
            destination = new PositionComponent(x-1, y-1);
        }
        if(x > 0 && y > 0 && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))){
            String piece = board[x-1][y-1];
            doMove(destination);
            if(!getOwner().getKing().isCheck()) availableMoves.add(destination);
            undoMove(piece);
        }

        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return BISHOP;
    }
}
