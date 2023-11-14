package org.JFarrow;

import org.JFarrow.Board.Board;
import org.JFarrow.State.Game;

public class Main {
    public static void main(String[] args) {
        Board.resetBoard();

        Game game = new Game();
        while(game.isRunning()){
            game.update();
        }
    }
}