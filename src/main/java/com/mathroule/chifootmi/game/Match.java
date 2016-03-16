package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.Builder;
import com.mathroule.chifootmi.player.Player;

/**
 * Used to play a match.
 */
public class Match {

    /**
     * Player 1 of the match.
     */
    private Player player1;

    /**
     * Player 2 of the match.
     */
    private Player player2;

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
     * Match constructor from a builder.
     *
     * @param builder the match builder
     */
    private Match(MatchBuilder builder) {
        // Check player 1 is not null
        if (builder.player1 == null) {
            throw new IllegalArgumentException("Player 1 should not be null");
        }

        // Check player 2 is not null
        if (builder.player2 == null) {
            throw new IllegalArgumentException("Player 2 should not be null");
        }

        // Check players are different
        if (builder.player1.equals(builder.player2)) {
            throw new IllegalArgumentException("Players should be different");
        }

        // Check number of round
        if (builder.round <= 0) {
            throw new IllegalArgumentException("Number of round must be greater than zero");
        }

        // Allow IA mode only in mode is Human vs Computer
        if (builder.hasIA && !builder.mode.equals(Mode.HUMAN_VS_COMPUTER)) {
            throw new IllegalArgumentException("IA mode is only available in Human vs Computer match");
        }

        this.player1 = builder.player1;
        this.player2 = builder.player2;
        this.mode = builder.mode;
        this.round = builder.round;
        this.hasIA = builder.hasIA;
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
        private int round = 1;
        private Mode mode = Mode.COMPUTER_VS_COMPUTER;
        private boolean hasIA = false;

        public MatchBuilder(Player player1, Player player2) {
            System.out.println("MatchBuilder player1: " + player1 + " player2: " + player2);
            this.player1 = player1;
            this.player2 = player2;
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
}
