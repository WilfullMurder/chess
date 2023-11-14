package org.JFarrow.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.JFarrow.Board.Board.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        resetBoard();
        game = new Game();
    }

    @Test
    void testUpdate(){
        assertTrue(game.isRunning());
        assertEquals(PLAYER_1, game.getPlayer1().getNumber());
        assertEquals(PLAYER_2, game.getPlayer2().getNumber());
        for(int i = 0; i < 11; i++){
            assertEquals(i, game.getCounter());
            game.update();
        }

    }
}