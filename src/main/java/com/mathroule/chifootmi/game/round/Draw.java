package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.game.player.Player;

/**
 * Implement a draw round of a match between two players.
 */
public class Draw extends Round {

    /**
     * Draw round constructor.
     *
     * @param round   the number of the round
     * @param player1 the first player of the round
     * @param player2 the second player of the round
     */
    public Draw(int round, Player player1, Player player2) {
        super(round, player1, player2, "draw");
    }

    @Override
    public String toString() {
        return super.toString() + " has been a draw";
    }
}
