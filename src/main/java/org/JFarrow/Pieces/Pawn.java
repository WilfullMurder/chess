package org.JFarrow.Pieces;

import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.*;

public class Pawn extends GamePiece{

    public Pawn(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        int x = currentPosition.intX();
        int y = currentPosition.intY();
        List<PositionComponent> availableMoves = new ArrayList<>();

        if(getOwner().getNumber().equals(PLAYER_1)){
            //check move forward 1 space
            if(x > 0 && isEmpty(new PositionComponent(x-1, y))){
                doMove(new PositionComponent(x-1, y));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x-1, y));
                undoMove(EMPTY);
                //check initial move forward 2 spaces
                if(x == 6 && isEmpty(new PositionComponent(x-2, y))){
                    doMove(new PositionComponent(x-2, y));
                    if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x-2, y));
                    undoMove(EMPTY);
                }
            }
            //check left diagonal for enemy
            if(x > 0 && y > 0
                    && !isEmpty(new PositionComponent(x - 1, y - 1))
                    && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))){
                String piece = board[x-1][y-1];
                doMove(new PositionComponent(x-1, y-1));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x-1, y-1));
                undoMove(piece);
            }
            //check right diagonal for enemy
            if(x > 0 && y < 7
                    && !isEmpty(new PositionComponent(x - 1, y + 1))
                    && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))){
                String piece = board[x-1][y+1];
                doMove(new PositionComponent(x-1, y+1));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y + 1));
                undoMove(piece);
            }
        }

        if(getOwner().getNumber().equals(PLAYER_2)){
            if(x < 7 && isEmpty(new PositionComponent(x + 1, y))){
                doMove(new PositionComponent(x + 1, y));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y));
                undoMove(EMPTY);
                //check initial move forward 2 spaces
                if(x == 1 && isEmpty(new PositionComponent(x + 2, y))){
                    doMove(new PositionComponent(x + 2, y));
                    if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 2, y));
                    undoMove(EMPTY);
                }
            }
            //check left diagonal for enemy
            if(x < 7 && y > 0
                    && !isEmpty(new PositionComponent(x + 1, y - 1))
                    && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))){
                String piece = board[x+1][y-1];
                doMove(new PositionComponent(x+1, y-1));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x+1, y-1));
                undoMove(piece);
            }
            //check right diagonal for enemy
            if(x < 7 && y < 7
                    && !isEmpty(new PositionComponent(x + 1, y + 1))
                    && !getOwner().getNumber().equals(board[x+1][y+1].substring(1))){
                String piece = board[x+1][y-1];
                doMove(new PositionComponent(x+1, y+1));
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x+1, y+1));
                undoMove(piece);
            }
        }
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return PAWN;
    }
}
