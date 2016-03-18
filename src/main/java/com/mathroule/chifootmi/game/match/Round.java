package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.IBuilder;
import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.rule.Rule;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

/**
 * Abstract a round of a match between two players.
 */
public class Round extends RuledVersus {

    /**
     * Number of the round.
     */
    private final int round;

    /**
     * The first player weapon.
     */
    private final Weapon weapon1;

    /**
     * The second player weapon.
     */
    private final Weapon weapon2;

    /**
     * The used rule to determinate the issue of the round.
     */
    private final Rule rule;

    /**
     * The round result.
     */
    private final Result result;

    /**
     * The round result.
     */
    public enum Result {
        DRAW,
        PLAYER_1_WIN,
        PLAYER_2_WIN
    }

    /**
     * Round constructor from a builder.
     *
     * @param builder the match builder
     */
    private Round(Builder builder) {
        super(builder.player1, builder.player2, builder.rules);

        // Check round number
        if (builder.round < 1) {
            throw new IllegalArgumentException("Round number must be equal or greater than one");
        }

        // Check weapon 1 is not null
        if (builder.weapon1 == null) {
            throw new NullPointerException("Weapon 1 should not be null");
        }

        // Check weapon 2 is not null
        if (builder.weapon2 == null) {
            throw new NullPointerException("Weapon 2 should not be null");
        }

        // Get round result and determinate winner and looser or draw
        int comparison = rules.compare(builder.weapon1, builder.weapon2);
        if (comparison > 0) {
            result = Result.PLAYER_1_WIN;
            player1.won();
            player2.loose();
        } else if (comparison < 0) {
            result = Result.PLAYER_2_WIN;
            player2.won();
            player1.loose();
        } else {
            result = Result.DRAW;
        }

        // Try to get used rule from normal case: first weapon vs second weapon
        Rule usedRule = rules.getWiningRule(builder.weapon1, builder.weapon2);

        // Otherwise, try to get used rule from inverted case: second weapon vs first weapon
        if (usedRule == null) {
            usedRule = rules.getWiningRule(builder.weapon2, builder.weapon1);
        }
        this.rule = usedRule;
        this.round = builder.round;
        this.weapon1 = builder.weapon1;
        this.weapon2 = builder.weapon2;
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
    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Round #" + round + ": " + player1 + " (" + weapon1 + ") vs " + player2 + " (" + weapon2 + "): "
                + (rule != null ? rule : "draw");
    }

    /**
     * The round builder.
     */
    public final static class Builder implements IBuilder<Round> {

        private final Player player1;
        private final Player player2;
        private final Weapon weapon1;
        private final Weapon weapon2;
        private int round = 1;
        private Rules rules = new Basic();

        /**
         * Build a round with two players, with the weapons and basic rules.
         *
         * @param player1 the first player of the match
         * @param weapon1 the first player weapon for the match
         * @param player2 the second player of the match
         * @param weapon2 the second player weapon for the match
         */
        public Builder(Player player1, Weapon weapon1, Player player2, Weapon weapon2) {
            this.player1 = player1;
            this.player2 = player2;
            this.weapon1 = weapon1;
            this.weapon2 = weapon2;
        }

        /**
         * Set the round rules.
         *
         * @return This Builder object to allow chaining
         */
        public Builder rules(Rules rules) {
            this.rules = rules;
            return this;
        }

        /**
         * Set the round number.
         *
         * @return This Builder object to allow chaining
         */
        public Builder round(int round) {
            this.round = round;
            return this;
        }

        /**
         * Build a round.
         *
         * @return the built round
         */
        @Override
        public Round build() {
            return new Round(this);
        }
    }
}
