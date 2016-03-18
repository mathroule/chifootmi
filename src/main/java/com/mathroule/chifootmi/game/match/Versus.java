package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.game.player.Player;

/**
 * Abstract a versus between two players.
 */
abstract class Versus {

    /**
     * Player 1 of the versus.
     */
    final Player player1;

    /**
     * Player 2 of the versus.
     */
    final Player player2;

    /**
     * Versus constructor.
     *
     * @param player1 the first player of the round
     * @param player2 the second player of the round
     */
    Versus(final Player player1, final Player player2) {
        // Check player 1 is not null
        if (player1 == null) {
            throw new NullPointerException("Player 1 should not be null");
        }

        // Check player 2 is not null
        if (player2 == null) {
            throw new NullPointerException("Player 2 should not be null");
        }

        // Check players are different
        if (player1.equals(player2)) {
            throw new IllegalArgumentException("Players should be different");
        }

        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Get the player 1 value.
     *
     * @return the player 1
     */
    public final Player getPlayer1() {
        return player1;
    }

    /**
     * Get the player 2 value.
     *
     * @return the player 2
     */
    public final Player getPlayer2() {
        return player2;
    }

    @Override
    public String toString() {
        return player1 + " vs " + player2;
    }
}
