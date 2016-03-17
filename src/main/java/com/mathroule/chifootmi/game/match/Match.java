package com.mathroule.chifootmi.game.match;

import com.mathroule.chifootmi.IBuilder;
import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a match between two players.
 */
public final class Match extends RuledVersus {

    /**
     * Number of round in match.
     */
    private final int round;

    /**
     * Current round of the match.
     */
    private int currentRound = 1;

    /**
     * Rounds of the match.
     */
    private final List<Round> rounds;

    /**
     * Match constructor from a builder.
     *
     * @param builder the match builder
     */
    private Match(MatchBuilder builder) {
        super(builder.player1, builder.player2, builder.rules);

        // Check rules are not null
        if (builder.rules == null) {
            throw new NullPointerException("Rules should not be null");
        }

        // Check number of round
        if (builder.round <= 0) {
            throw new IllegalArgumentException("Number of round must be greater than zero");
        }

        this.round = builder.round;
        this.rounds = new ArrayList<>(round);
    }

    /**
     * Get the number of round value.
     *
     * @return the number of round
     */
    public int getRound() {
        return round;
    }

    /**
     * Get the match has remaining round value.
     *
     * @return true if the match has remaining round, false otherwise
     */
    public boolean hasRemainingRound() {
        return currentRound <= round;
    }

    /**
     * Play a round with players weapons.
     *
     * @param weapon1 the player 1 weapon
     * @param weapon2 the player 2 weapon
     * @return the round
     */
    public Round playRound(Weapon weapon1, Weapon weapon2) {
        if (!hasRemainingRound()) {
            throw new UnsupportedOperationException("No more rounds to play");
        }

        // Play the round
        Round round = new Round(currentRound++, rules, player1, weapon1, player2, weapon2);

        // Save the round
        rounds.add(round);

        // Return the round
        return round;
    }

    /**
     * Get the match result value.
     *
     * @return the match result
     */
    public Result getResult() {
        if (hasRemainingRound()) {
            throw new UnsupportedOperationException("Match is not finished");
        }

        return new Result(player1, player2, rounds);
    }

    /**
     * The match builder.
     */
    public static class MatchBuilder implements IBuilder<Match> {

        private final Player player1;
        private final Player player2;
        private Rules rules = new Basic();
        private int round = 1;

        public MatchBuilder(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        public MatchBuilder rules(Rules rules) {
            this.rules = rules;
            return this;
        }

        public MatchBuilder round(int round) {
            this.round = round;
            return this;
        }

        @Override
        public Match build() {
            return new Match(this);
        }
    }

    @Override
    public String toString() {
        return "Match " + super.toString() + " in " + round + " rounds";
    }
}
