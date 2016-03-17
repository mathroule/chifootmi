package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.Builder;
import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.round.Draw;
import com.mathroule.chifootmi.game.round.Round;
import com.mathroule.chifootmi.game.round.Win;
import com.mathroule.chifootmi.game.rule.Basic;
import com.mathroule.chifootmi.game.rule.Rule;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a match between two players.
 */
public class Match extends Versus {

    /**
     * Number of round in match.
     */
    private final int round;

    /**
     * Match mode (Human vs Computer, Computer vs Computer ...).
     */
    private final Mode mode;

    /**
     * Use IA or not (Only if it's an Human vs Computer mode).
     */
    private final boolean hasIA; // TODO move in computer

    /**
     * Rules of the match.
     */
    private final Rules rules;

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
        super(builder.player1, builder.player2);

        // Check rules are not null
        if (builder.rules == null) {
            throw new NullPointerException("Rules should not be null");
        }

        // Check number of round
        if (builder.round <= 0) {
            throw new IllegalArgumentException("Number of round must be greater than zero");
        }

        // Allow IA mode only in mode is Human vs Computer
        if (builder.hasIA && !builder.mode.equals(Mode.HUMAN_VS_COMPUTER)) {
            throw new IllegalArgumentException("IA mode is only available in Human vs Computer match");
        }

        this.mode = builder.mode;
        this.round = builder.round;
        this.rounds = new ArrayList<>(round);
        this.hasIA = builder.hasIA;
        this.rules = builder.rules;
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
     * Get the match mode value.
     *
     * @return the match mode
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Get the IA enabled value.
     *
     * @return true if the IA is enabled, false otherwise
     */
    public boolean hasIA() {
        return hasIA;
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

        // Get round result and determinate winner and looser or draw
        int result = rules.compare(weapon1, weapon2);
        Player winner = result > 0 ? player1 : (result < 0 ? player2 : null);

        // Try to get used rule from normal case: first weapon vs second weapon
        Rule rule = rules.getWiningRule(weapon1, weapon2);

        // Otherwise, try to get used rule from inverted case: second weapon vs first weapon
        if (rule == null) {
            rule = rules.getWiningRule(weapon2, weapon1);
        }

        // If no result it's a draw
        Round round = rule != null
                ? new Win(currentRound++, player1, player2, winner, rule.toString())
                : new Draw(currentRound++, player1, player2); // It's a round won by one of the players

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
        // TODO allow to get result everywhere
        if (hasRemainingRound()) {
            throw new UnsupportedOperationException("Match is not finished");
        }

        return new Result(player1, player2, rounds);
    }


    /**
     * The available match mode.
     */
    public enum Mode {
        HUMAN_VS_COMPUTER,
        COMPUTER_VS_COMPUTER
    }

    /**
     * The match builder.
     */
    public static class MatchBuilder implements Builder<Match> {

        private final Player player1;
        private final Player player2;
        private Rules rules = new Basic();
        private int round = 1;
        private Mode mode = Mode.COMPUTER_VS_COMPUTER;
        private boolean hasIA = false;

        public MatchBuilder(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        public MatchBuilder rules(Rules rules) {
            this.rules = rules;
            return this;
        }

        public MatchBuilder mode(Mode mode) {
            this.mode = mode;
            return this;
        }

        public MatchBuilder round(int round) {
            this.round = round;
            return this;
        }

        public MatchBuilder hasIA(boolean hasIA) {
            this.hasIA = hasIA;
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
