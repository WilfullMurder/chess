package org.JFarrow.Pieces;

import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.*;
import static org.JFarrow.Board.Board.board;

public class Queen extends GamePiece{

    public Queen(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        availableMoves.addAll(getStraightLineMovements());
        availableMoves.addAll(getDiagonalMovements());
        return availableMoves;
    }

    private List<PositionComponent> getStraightLineMovements() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        //check moves down
        PositionComponent down = new PositionComponent(x+1, y);
        while(x < 7 && isEmpty(down)){
            doMove(down);
            if(!getOwner().getKing().isCheck()) availableMoves.add(down);
            undoMove(EMPTY);
            x++;
            down = new PositionComponent(x+1, y);
        }
        down = new PositionComponent(x+1, y);
        if(x < 7 && !getOwner().getNumber().equals(board[x+1][y].substring(1))){
            String piece = board[x+1][y];
            doMove(down);
            if(!getOwner().getKing().isCheck()) availableMoves.add(down);
            undoMove(piece);
        }

        x = currentPosition.intX();

        //check up moves
        PositionComponent up = new PositionComponent(x-1, y);
        while(x > 0 && isEmpty(up)){
            doMove(up);
            if(!getOwner().getKing().isCheck()) availableMoves.add(up);
            undoMove(EMPTY);
            x--;
            up = new PositionComponent(x-1, y);
        }

        up = new PositionComponent(x-1, y);
        if(x > 0 && !getOwner().getNumber().equals(board[x-1][y].substring(1))){
            String piece = board[x-1][y];
            doMove(new PositionComponent(x-1, y));
            if(!getOwner().getKing().isCheck()) availableMoves.add(up);
            undoMove(piece);
        }

        x = currentPosition.intX();

        //check right moves
        PositionComponent right = new PositionComponent(x, y+1);
        while(y < 7 && isEmpty(right)){
            doMove(right);
            if(!getOwner().getKing().isCheck()) availableMoves.add(right);
            undoMove(EMPTY);
            y++;
            right = new PositionComponent(x, y+1);
        }
        right = new PositionComponent(x, y+1);
        if(y < 7 && !getOwner().getNumber().equals(board[x][y+1].substring(1))){
            String piece = board[x][y+1];
            doMove(right);
            if(!getOwner().getKing().isCheck()) availableMoves.add(right);
            undoMove(piece);
        }

        y = currentPosition.intY();

        //check left moves
        PositionComponent left = new PositionComponent(x, y-1);
        while(y > 0 && isEmpty(left)){
            doMove(left);
            if(!getOwner().getKing().isCheck()) availableMoves.add(left);
            undoMove(EMPTY);
            y--;
            left = new PositionComponent(x, y-1);
        }
        left = new PositionComponent(x, y-1);
        if(y > 0 && !getOwner().getNumber().equals(board[x][y-1].substring(1))){
            String piece = board[x][y-1];
            doMove(left);
            if(!getOwner().getKing().isCheck()) availableMoves.add(left);
            undoMove(piece);
        }
        return availableMoves;
    }

    private List<PositionComponent> getDiagonalMovements() {
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
        return QUEEN;
    }
}
