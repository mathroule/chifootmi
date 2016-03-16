package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.Builder;

/**
 * Used to play a match.
 */
public class Match {

    /**
     * Number of round in match
     */
    private final int round;

    /**
     * Match mode (Human vs Computer, Computer vs Computer ...)
     */
    private final Mode mode;

    /**
     * Use IA or not (Only if it's an Human vs Computer mode)
     */
    private final boolean hasIA;

    /**
     * Match constructor from a builder.
     *
     * @param builder the match builder
     */
    private Match(MatchBuilder builder) {
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
        this.hasIA = builder.hasIA;
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

        private int round = 1;
        private Mode mode = Mode.COMPUTER_VS_COMPUTER;
        private boolean hasIA = false;

        public MatchBuilder() {
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
