package com.mathroule.chifootmi.game;

import com.mathroule.chifootmi.game.player.Player;
import com.mathroule.chifootmi.game.rule.Rule;
import com.mathroule.chifootmi.game.rule.Rules;
import com.mathroule.chifootmi.game.weapon.Weapon;

/**
 * Abstract a round of a match between two players.
 */
public class Round extends Versus {

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
     * The round rules.
     */
    private final Rules rules;

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
     * Round constructor.
     *
     * @param round   the number of the round
     * @param player1 the first player of the round
     * @param weapon1 the first player weapon for the round
     * @param player2 the second player of the round
     * @param weapon2 the second player weapon for the round
     */
    public Round(int round, Rules rules, Player player1, Weapon weapon1, Player player2, Weapon weapon2) {
        super(player1, player2);

        // Check round number
        if (round < 1) {
            throw new IllegalArgumentException("Round number must be equal or greater than one");
        }

        // Check rules are not null
        if (rules == null) {
            throw new NullPointerException("Rules should not be null");
        }

        // Get round result and determinate winner and looser or draw
        int comparison = rules.compare(weapon1, weapon2);

        // TODO improve
        if (comparison > 0) {
            result = Result.PLAYER_1_WIN;
        } else if (comparison < 0) {
            result = Result.PLAYER_2_WIN;
        } else {
            result = Result.DRAW;
        }

        // Try to get used rule from normal case: first weapon vs second weapon
        Rule usedRule = rules.getWiningRule(weapon1, weapon2);

        // Otherwise, try to get used rule from inverted case: second weapon vs first weapon
        if (usedRule == null) {
            usedRule = rules.getWiningRule(weapon2, weapon1);
        }
        rule = usedRule;


        // TODO check null weapons and rules values

        this.round = round;
        this.rules = rules;
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
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
}
