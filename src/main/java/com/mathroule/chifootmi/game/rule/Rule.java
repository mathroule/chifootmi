package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.game.weapon.Weapon;

/**
 * Implement a winning game rule. (i.e. Scissors cuts paper)
 */
public class Rule {

    /**
     * The winner weapon of the rule.
     */
    private final Weapon winner;

    /**
     * The action of the rule.
     */
    private final String action;

    /**
     * The looser weapon of the rule.
     */
    private final Weapon looser;

    /**
     * Rule constructor.
     *
     * @param winner the winner weapon of the rule
     * @param action the action of the rule
     * @param looser the looser weapon of the rule
     */
    public Rule(Weapon winner, String action, Weapon looser) {
        // TODO check null values

        // Check weapons are different
        if (winner.equals(looser)) {
            throw new IllegalArgumentException("Weapons should be different");
        }

        this.winner = winner;
        this.action = action;
        this.looser = looser;
    }

    /**
     * Check if the rule is respected.
     *
     * @param weapon1 the first weapon
     * @param weapon2 the second weapon
     * @return true if the first weapon win versus the second weapon, false otherwise
     */
    public boolean isRespected(Weapon weapon1, Weapon weapon2) {
        // TODO check null values
        return winner.equals(weapon1) && looser.equals(weapon2);
    }

    @Override
    public String toString() {
        return winner + " " + action + " " + looser;
    }
}
