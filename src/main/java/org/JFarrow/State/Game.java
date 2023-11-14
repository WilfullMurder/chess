package org.JFarrow.State;


import org.JFarrow.Controllers.Player;
import org.JFarrow.Pieces.Piece;

import static org.JFarrow.Board.Board.*;

public class Game {
    private boolean running = true;
    private int counter = 0;
    private boolean hasCastled = false;
    private Player player1 = new Player(PLAYER_1);
    private Player player2 = new Player(PLAYER_2);

    private Piece lastPieceKilled;
    private Piece currentPiece;



    public boolean isRunning() {
        return running;
    }
    public int getCounter() {
        return counter;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void update(){
        display();
        System.out.print("Turn: " + counter + "\n");
        System.out.print("    Player: ");
        if(counter % 2 == 0) System.out.print(PLAYER_1 + "\n");
        else System.out.print(PLAYER_2 + "\n");

        //implement monte carlo

        counter++;
    }


}
