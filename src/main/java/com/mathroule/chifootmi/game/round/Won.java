package com.mathroule.chifootmi.game.round;

import com.mathroule.chifootmi.game.player.Player;

/**
 * Implement a won round of a match between two players.
 */
public class Won extends Round {

    /**
     * Winner player of the round.
     */
    private final Player winner;

    /**
     * Round constructor.
     *
     * @param round   the number of the round
     * @param player1 the first player of the round
     * @param player2 the second player of the round
     * @param winner  the winner player of the round
     * @param result  the result of the round
     */
    public Won(int round, Player player1, Player player2, Player winner, String result) {
        super(round, player1, player2, result);

        // Check winner 1 is not null
        if (winner == null) {
            throw new NullPointerException("Winner should not be null");
        }

        // Check winner is a player
        if (!winner.equals(player1) && !winner.equals(player2)) {
            throw new IllegalArgumentException("Winner should be a player of the round");
        }

        this.winner = winner;
    }

    /**
     * Get the round winner player value.
     *
     * @return the round winner player
     */
    public Player getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return super.toString() + " has been won by " + winner + " with " + getResult();
    }
}
