package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.IBuilder;
import com.mathroule.chifootmi.game.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a match result;
 */
public final class Result extends Versus {

    private int draw = 0;

    /**
     * Result constructor from a builder.
     *
     * @param builder the result builder
     */
    private Result(Builder builder) {
        super(builder.player1, builder.player2);

        // Check rules is not null
        if (builder.rounds == null) {
            throw new NullPointerException("Rounds should not be null");
        }

        // Compute the count of draw rounds
        for (Round round : builder.rounds) {
            if (round.getResult().equals(Round.Result.DRAW)) {
                draw++;
            }
        }
    }

    public int getDraw() {
        return draw;
    }

    @Override
    public String toString() {
        return "--- Match " + super.toString() + " ---"
                + "\nDraw " + draw + " times"
                + "\n" + player1 + " wins " + player1.getWin() + " times"
                + "\n" + player2 + " wins " + player2.getWin() + " times";
    }

    /**
     * The result builder.
     */
    public final static class Builder implements IBuilder<Result> {

        private final Player player1;
        private final Player player2;
        private List<Round> rounds = new ArrayList<>();

        /**
         * Build a result with no rounds.
         *
         * @param player1 the first player of the result
         * @param player2 the second player of the result
         */
        public Builder(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        /**
         * Set the rounds.
         *
         * @return This Builder object to allow chaining
         */
        public Builder rounds(List<Round> rounds) {
            this.rounds = rounds;
            return this;
        }

        /**
         * Build a result.
         *
         * @return the built result
         */
        @Override
        public Result build() {
            return new Result(this);
        }
    }
}
