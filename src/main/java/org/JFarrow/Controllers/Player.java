package org.JFarrow.Controllers;

import org.JFarrow.Board.Board;
import org.JFarrow.Core.PositionComponent;
import org.JFarrow.Pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.JFarrow.Board.Board.*;

public class Player {
    private final String number;
    private List<Piece> pieces;

    public Player(String number){
        this.number = number;
        pieces = new ArrayList<>();
        setPieces();
    }

    public List<PositionComponent> getMoves(){
        List<PositionComponent> moves = new ArrayList<>();
        for(Piece piece: pieces){
            if(piece != null && piece.isAlive()){
                moves.addAll(piece.getMoves());
            }
        }
        return moves;
    }

    private void setPieces() {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col].equals(PAWN + number)){
                    pieces.add(new Pawn(new PositionComponent(row, col), this));
                }
                if(board[row][col].equals(ROOK + number)){
                    pieces.add(new Rook(new PositionComponent(row, col), this));
                }
                if(board[row][col].equals(KNIGHT + number)){
                    pieces.add(new Knight(new PositionComponent(row, col), this));
                }
                if(board[row][col].equals(BISHOP + number)){
                    pieces.add(new Bishop(new PositionComponent(row, col), this));
                }
                if(board[row][col].equals(QUEEN + number)){
                    pieces.add(new Queen(new PositionComponent(row, col), this));
                }
                if(board[row][col].equals(KING + number)){
                    pieces.add(new King(new PositionComponent(row, col), this));
                }
            }
        }
    }

    public Piece getPiece(PositionComponent position){

        for(Piece piece: pieces){
            if(piece != null && piece.isAlive()
                    && piece.getCurrentPosition().equals(position)){
                return piece;

            }
        }
        return null;
    }


    public String getNumber() {
        return number;
    }

    public King getKing() {
        for(Piece piece: pieces){
            if(piece.getPieceConstant().equals(KING)) return (King) piece;
        }
        return null;
    }

    public void killPiece(Piece p) {
        for(Piece piece: pieces){
            if(piece.equals(p)){
                piece.kill();
                break;
            }
        }
    }

    public void revive(Piece p) {
        for(Piece piece: pieces){
            if(piece.equals(p)){
                piece.revive();
                break;
            }
        }
    }

    public void promotePawn(Piece promotion) {
        board[promotion.getCurrentPosition().intX()][promotion.getCurrentPosition().intY()] = promotion.getPieceConstant() + number;
        for(Piece piece: pieces){
            if(piece.getCurrentPosition().equals(promotion.getCurrentPosition())){
                int i = pieces.indexOf(piece);
                pieces.set(i, promotion);
            }
        }
    }
}
