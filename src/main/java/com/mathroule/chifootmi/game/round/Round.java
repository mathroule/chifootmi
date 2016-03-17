package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.game.Versus;
import com.mathroule.chifootmi.game.player.Player;

/**
 * Abstract a round of a match between two players.
 */
public abstract class Round extends Versus {

    /**
     * Number of the round.
     */
    private final int round;

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
        super(player1, player2);

        // Check round number
        if (round < 1) {
            throw new IllegalArgumentException("Round number must be equal or greater than one");
        }

        // Check result is not null
        if (result == null) {
            throw new NullPointerException("Result should not be null");
        }

        this.round = round;
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
     * Get the round result value.
     *
     * @return the round result
     */
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Round #" + round + ": " + super.toString();
    }
}
