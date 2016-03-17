package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.game.weapon.Weapon;

/**
 * Implement a winning game rule. (i.e. Scissors cuts paper)
 */
public final class Rule {

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
     * Rule constructor with a weapon beating another weapon by an action.
     *
     * @param winning the winning weapon of the rule
     * @param action  the action of the rule
     * @param loosing the loosing weapon of the rule
     */
    public Rule(Weapon winning, String action, Weapon loosing) {
        // Check winning weapon is not null
        if (winning == null) {
            throw new NullPointerException("Winning weapon should not be null");
        }

        // Check loosing weapon is not null
        if (loosing == null) {
            throw new NullPointerException("Loosing weapon should not be null");
        }

        // Check weapons are different
        if (winning.equals(loosing)) {
            throw new IllegalArgumentException("Weapons should be different");
        }

        this.winner = winning;
        this.action = action;
        this.looser = loosing;
    }

    /**
     * Check if the rule is respected for two weapons.
     *
     * @param weapon1 the first weapon
     * @param weapon2 the second weapon
     * @return true if the first weapon win versus the second weapon, false otherwise
     */
    public boolean isRespected(Weapon weapon1, Weapon weapon2) {
        return winner.equals(weapon1) && looser.equals(weapon2);
    }

    @Override
    public String toString() {
        return winner + " " + action + " " + looser;
    }
}
