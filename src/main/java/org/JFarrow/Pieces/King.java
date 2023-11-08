package org.JFarrow.Pieces;

import org.JFarrow.Controllers.Player;
import org.JFarrow.Core.PositionComponent;

import java.util.ArrayList;
import java.util.List;

import static org.JFarrow.Board.Board.*;

public class King extends GamePiece{
    private boolean moved;

    public King(PositionComponent currentPosition, Player owner) {
        super(currentPosition, owner);
    }

    @Override
    public List<PositionComponent> getMoves() {
        List<PositionComponent> availableMoves = new ArrayList<>();
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        availableMoves.addAll(verticalMoves(x, y));
        availableMoves.addAll(horizontalMoves(x, y));
        availableMoves.addAll(diagonalMoves(x, y));
        return availableMoves;
    }

    private List<PositionComponent> verticalMoves(int x, int y){
        List<PositionComponent> availableMoves = new ArrayList<>();
        if(x < 7 && isEmpty(new PositionComponent(x + 1, y))){
            doMove(new PositionComponent(x + 1, y));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y));
            undoMove(EMPTY);
        }
        if(x < 7 && !isEmpty(new PositionComponent(x + 1, y)) && !getOwner().getNumber().equals(board[x+1][y].substring(1))){
            String piece = board[x+1][y];
            doMove(new PositionComponent(x + 1, y));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y));
            undoMove(piece);
        }
        if(x > 0 && isEmpty(new PositionComponent(x - 1, y))){
            doMove(new PositionComponent(x - 1, y));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y));
            undoMove(EMPTY);
        }
        if(x > 0 && !isEmpty(new PositionComponent(x - 1, y)) && !getOwner().getNumber().equals(board[x-1][y].substring(1))){
            String piece = board[x-1][y];
            doMove(new PositionComponent(x - 1, y));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y));
            undoMove(piece);
        }
        return availableMoves;
    }

    private List<PositionComponent> horizontalMoves(int x, int y){
        List<PositionComponent> availableMoves = new ArrayList<>();

        if(y < 7 && isEmpty(new PositionComponent(x, y + 1))){
            doMove(new PositionComponent(x, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x, y + 1));
            undoMove(EMPTY);
            //Player one king side castling
            if(getOwner().getNumber() == PLAYER_1) {
                if (!getOwner().getKing().isCheck() && y < 6
                        && isEmpty(new PositionComponent(x, y + 2))
                        && currentPosition.equals(new PositionComponent(7, 4))
                        && !moved && board[7][7].equals(ROOK + PLAYER_1)) {
                    Rook rook = (Rook) getOwner().getPiece(new PositionComponent(7, 7));
                    if (!rook.hasMoved()) {
                        doMove(new PositionComponent(7, 6));
                        rook.doMove(new PositionComponent(7, 5));
                    }
                    if (!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(7, 6));
                    undoMove(EMPTY);
                    rook.undoMove(EMPTY);
                }
                //Player two king side castling
            } else if (!getOwner().getKing().isCheck() && y < 6
                    && isEmpty(new PositionComponent(x, y + 2))
                    && currentPosition.equals(new PositionComponent(0, 4))
                    && !moved && board[0][7].equals(ROOK + PLAYER_2)) {
                Rook rook = (Rook) getOwner().getPiece(new PositionComponent(0, 7));
                if(!rook.hasMoved()){
                    doMove(new PositionComponent(0,6));
                    rook.doMove(new PositionComponent(0, 5));
                }
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(0, 6));
                undoMove(EMPTY);
                rook.undoMove(EMPTY);
            }
        }
        if(y < 7 && !isEmpty(new PositionComponent(x, y + 1)) && !getOwner().getNumber().equals(board[x][y+1].substring(1))){
            String piece = board[x][y+1];
            doMove(new PositionComponent(x, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x, y + 1));
            undoMove(piece);
        }

        //Player one queen side castling
        if(y > 0 && isEmpty(new PositionComponent(x, y - 1))){
            doMove(new PositionComponent(x, y-1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x, y - 1));
            undoMove(EMPTY);
            if(getOwner().getNumber().equals(PLAYER_1)){
                if(!getOwner().getKing().isCheck() && y > 1
                        && isEmpty(new PositionComponent(x, y-2))
                        && currentPosition.equals(new PositionComponent(7, 4))
                        && !moved && board[7][0].equals(ROOK + PLAYER_1)){
                    Rook rook = (Rook) getOwner().getPiece(new PositionComponent(7, 0));
                    if(!rook.hasMoved()){
                        doMove(new PositionComponent(7, 2));
                        rook.doMove(new PositionComponent(7, 3));
                    }
                    if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(7, 2));
                    undoMove(EMPTY);
                    rook.undoMove(EMPTY);
                }
            }
            //Player two Queen side castling
            else if (!getOwner().getKing().isCheck() && y > 1
                    && isEmpty(new PositionComponent(0, 4))
                    && !moved && board[0][0].equals(ROOK+PLAYER_2)) {
                Rook rook = (Rook) getOwner().getPiece(new PositionComponent(0,0));
                if(!rook.hasMoved()){
                    doMove(new PositionComponent(0, 2));
                    rook.doMove(new PositionComponent(0, 3));
                }
                if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(0, 2));
                undoMove(EMPTY);
                rook.undoMove(EMPTY);
            }
        }
        if(y > 0 && !isEmpty(new PositionComponent(x, y - 1)) && !getOwner().getNumber().equals(board[x][y-1].substring(1))){
            String piece = board[x][y-1];
            doMove(new PositionComponent(x, y - 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x, y - 1));
            undoMove(piece);
        }
        return availableMoves;
    }

    private List<PositionComponent> diagonalMoves(int x, int y){
        List<PositionComponent> availableMoves = new ArrayList<>();
        if(x < 7 && y < 7 && isEmpty(new PositionComponent(x + 1, y + 1))){
            doMove(new PositionComponent(x + 1, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y + 1));
            undoMove(EMPTY);
        }
        if(x < 7 && y < 7 && !isEmpty(new PositionComponent(x + 1, y + 1)) && !getOwner().getNumber().equals(board[x+1][y+1].substring(1))){
            String piece = board[x+1][y+1];
            doMove(new PositionComponent(x + 1, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y + 1));
            undoMove(piece);
        }
        if(x < 7 && y > 0 && isEmpty(new PositionComponent(x + 1, y - 1))){
            doMove(new PositionComponent(x + 1, y - 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y - 1));
            undoMove(EMPTY);
        }
        if(x < 7 && y > 7 && !isEmpty(new PositionComponent(x + 1, y - 1)) && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))){
            String piece = board[x+1][y-1];
            doMove(new PositionComponent(x + 1, y - 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x + 1, y - 1));
            undoMove(piece);
        }
        if(x > 0 && y < 7 && isEmpty(new PositionComponent(x - 1, y + 1))){
            doMove(new PositionComponent(x - 1, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y + 1));
            undoMove(EMPTY);
        }
        if(x > 0 && y < 7 && !isEmpty(new PositionComponent(x - 1, y + 1)) && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))){
            String piece = board[x-1][y+1];
            doMove(new PositionComponent(x - 1, y + 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y + 1));
            undoMove(piece);
        }
        if(x > 0 && y > 0 && isEmpty(new PositionComponent(x - 1, y - 1))){
            doMove(new PositionComponent(x - 1, y - 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y - 1));
            undoMove(EMPTY);
        }
        if(x > 0 && y > 0 && !isEmpty(new PositionComponent(x - 1, y - 1)) && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))){
            String piece = board[x-1][y-1];
            doMove(new PositionComponent(x - 1, y - 1));
            if(!getOwner().getKing().isCheck()) availableMoves.add(new PositionComponent(x - 1, y - 1));
            undoMove(piece);
        }
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return KING;
    }

    public boolean isCheck() {
        if(diagonalCheck()) return true;
        if(verticalCheck()) return true;
        if(knightCheck()) return true;
        if(kingCheck()) return true;
        return pawnCheck();
    }

    private boolean diagonalCheck(){
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        while(x < 7 && y < 7 && isEmpty(new PositionComponent(x+1, y+1))){
            x++;
            y++;
        }

        if(x < 7 && y < 7 && !getOwner().getNumber().equals(board[x+1][y+1].substring(1))
                && (board[x+1][y+1].startsWith(QUEEN) || board[x+1][y+1].startsWith(BISHOP))){
            //found a queen or bishop diagonally up right
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while(x < 7 && y > 0 && isEmpty(new PositionComponent(x+1, y-1))){
            x++;
            y--;
        }
        if(x < 7 && y > 0 && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))
                && (board[x+1][y-1].startsWith(QUEEN) || board[x+1][y-1].startsWith(BISHOP))){
            //found a queen or bishop diagonally up left
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while(x > 0 && y < 7 && isEmpty(new PositionComponent(x-1, y+1))){
            x--;
            y++;
        }
        if(x > 0 && y < 7 && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))
                && (board[x-1][y+1].startsWith(QUEEN) || board[x-1][y+1].startsWith(BISHOP))){
            //found a queen or bishop diagonally down right
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while (x > 0 && y > 0 && isEmpty(new PositionComponent(x-1, y-1))){
            x--;
            y--;
        }
        if(x > 0 && y > 0 && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))
                && (board[x-1][y-1].startsWith(QUEEN) || board[x-1][y-1].startsWith(BISHOP))){
            //found a queen or bishop diagonally down left
            return true;
        }
        return false;
    }

    private boolean verticalCheck() {
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        while(x < 7 && isEmpty(new PositionComponent(x+1, y))){
            x++;
        }
        if(x < 7 && !getOwner().getNumber().equals(board[x+1][y].substring(1))
                && (board[x+1][y].startsWith(QUEEN) || board[x+1][y].startsWith(ROOK))){
            //found queen or rook to the right
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while(x > 0 && isEmpty(new PositionComponent(x-1, y))){
            x--;
        }
        if(x > 0 && !getOwner().getNumber().equals(board[x-1][y].substring(1))
                && (board[x-1][y].startsWith(QUEEN) || board[x-1][y].startsWith(ROOK))){
            //found queen or rook to the left
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while(y < 7 && isEmpty(new PositionComponent(x, y+1))){
            y++;
        }
        if(y < 7 && !getOwner().getNumber().equals(board[x][y+1].substring(1))
                && (board[x][y+1].startsWith(QUEEN) || board[x][y+1].startsWith(ROOK))){
            //found queen or rook down
            return true;
        }

        x = currentPosition.intX();
        y = currentPosition.intY();

        while(y > 0 && isEmpty(new PositionComponent(x, y-1))){
            y--;
        }
        if(y > 0 && !getOwner().getNumber().equals(board[x][y-1].substring(1))
                && (board[x][y-1].startsWith(QUEEN) || board[x][y-1].startsWith(ROOK))){
            //found queen or rook up
            return true;
        }

        return false;
    }

    private boolean kingCheck() {
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        if(x < 7 && y < 7 && !getOwner().getNumber().equals(board[x+1][y+1].substring(1))
                && board[x+1][y+1].startsWith(KING)){
            return true;
        }
        if(x < 7 && y > 0 && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))
                && board[x+1][y-1].startsWith(KING)){
            return true;
        }
        if(x > 0 && y < 7 && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))
                && board[x-1][y+1].startsWith(KING)){
            return true;
        }
        if(x > 0 && y > 0 && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))
                && board[x-1][y-1].startsWith(KING)){
            return true;
        }
        if(x > 0 && !getOwner().getNumber().equals(board[x-1][y].substring(1))
                && board[x-1][y].startsWith(KING)){
            return true;
        }
        if(x < 7 && !getOwner().getNumber().equals(board[x+1][y].substring(1))
                && board[x-1][y].startsWith(KING)){
            return true;
        }
        if(y > 0 && !getOwner().getNumber().equals(board[x][y-1].substring(1))
                && board[x][y-1].startsWith(KING)){
            return true;
        }
        if(y < 7 && !getOwner().getNumber().equals(board[x][y+1].substring(1))
                && board[x][y+1].startsWith(KING)){
            return true;
        }
        return false;
    }

    private boolean knightCheck() {
        int x = currentPosition.intX();
        int y = currentPosition.intY();
        if(x > 0 && y < 6 && !getOwner().getNumber().equals(board[x-1][y+2].substring(1))
                && board[x-1][y+2].startsWith(KNIGHT)){
            return true;
        }
        if(x > 0 && y > 1 && !getOwner().getNumber().equals(board[x-1][y-2].substring(1))
                && board[x-1][y-2].startsWith(KNIGHT)){
            return true;
        }
        if(x > 1 && y > 0 && !getOwner().getNumber().equals(board[x-2][y-1].substring(1))
                && board[x-2][y-1].startsWith(KNIGHT)){
            return true;
        }
        if(x > 1 && y < 7 && !getOwner().getNumber().equals(board[x-2][y+1].substring(1))
                && board[x-2][y+1].startsWith(KNIGHT)){
            return true;
        }
        if(x < 6 && y < 7 && !getOwner().getNumber().equals(board[x+2][y+1].substring(1))
                && board[x+2][y+1].startsWith(KNIGHT)){
            return true;
        }
        if(x < 6 && y > 0 && !getOwner().getNumber().equals(board[x+2][y-1].substring(1))
                && board[x+2][y-1].startsWith(KNIGHT)){
            return true;
        }
        if(x < 7 && y < 6 && !getOwner().getNumber().equals(board[x+1][y+2].substring(1))
                && board[x+1][y+2].startsWith(KNIGHT)){
            return true;
        }
        if(x < 7 && y > 1 && !getOwner().getNumber().equals(board[x+1][y-2].substring(1))
                && board[x+1][y-2].startsWith(KNIGHT)){
            return true;
        }
        return false;
    }
    private boolean pawnCheck() {
        int x = currentPosition.intX();
        int y = currentPosition.intY();

        if(getOwner().getNumber().equals(PLAYER_1)){
            if(x > 0 && y > 0 && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))
                    && board[x-1][y-1].startsWith(PAWN)){
                return true;
            } else if (x > 0 && y < 7 && !getOwner().getNumber().equals(board[x-1][y+1].substring(1))
                    && board[x-1][y+1].startsWith(PAWN)) {
                return true;
            }

        }else {
            if(x < 7 && y > 0 && !getOwner().getNumber().equals(board[x+1][y-1].substring(1))
                    && board[x+1][y-1].startsWith(PAWN)){
                return true;
            } else if (x < 7 && y > 0 && !getOwner().getNumber().equals(board[x-1][y-1].substring(1))
                    && board[x-1][y-1].startsWith(PAWN)) {
                return true ;
            }
        }
        return false;
    }
}
