package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.player.Player;

/**
 * Abstract a round of a match between two players.
 */
public abstract class Round {
    // TODO refactor with match

    /**
     * Number of the round.
     */
    private final int round;

    /**
     * Player 1 of the round.
     */
    private final Player player1;

    /**
     * Player 2 of the round.
     */
    private final Player player2;

    /**
     * Round result.
     */
    private final String result;

    /**
     * Round constructor.
     *
     * @param round   the number of the round
     * @param player1 the first player of the round
     * @param player2 the second player of the round
     * @param result  the result of the round
     */
    public Round(int round, Player player1, Player player2, String result) {
        // Check round number
        if (round < 1) {
            throw new IllegalArgumentException("Round number must be equal or greater than one");
        }

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

        // Check result is not null
        if (result == null) {
            throw new NullPointerException("Result should not be null");
        }

        this.round = round;
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
    }

    /**
     * Get the round number value.
     *
     * @return the round number
     */
    public int getRound() {
        return round;
    }

    /**
     * Get the player 1 value.
     *
     * @return the player 1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Get the player 2 value.
     *
     * @return the player 2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Get the round result value.
     *
     * @return the round result
     */
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Round #" + round + ": " + player1 + " vs " + player2;
    }
}
