package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.weapon.Weapon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract game rules. Main purpose is to compare if a weapon is better than another.
 */
public abstract class Rules extends ArrayList<Rule> implements Comparator<Weapon> {

    // TODO use decorator

    /**
     * Get the winning rule for the first weapon1 vs the second weapon.
     *
     * @param weapon1 the first weapon
     * @param weapon2 the second weapon
     * @return the winning rule, null if no rules matched
     */
    public Rule getWiningRule(Weapon weapon1, Weapon weapon2) {
        for (Rule rule : this) {
            if (rule.isRespected(weapon1, weapon2)) {
                return rule;
            }
        }
        return null;
    }

    /**
     * Compare weapon1 vs weapon2.
     *
     * @param o1 the first weapon
     * @param o2 the second weapon
     * @return a negative integer if the second weapon beats the first weapon.
     * Zero if both weapons are equals.
     * A positive integer if the first weapon beats the second weapon.
     */
    @Override
    public int compare(Weapon o1, Weapon o2) {
        // Check if weapons are not null
        if (o1 == null || o2 == null) {
            throw new NullPointerException("Weapons should not be null");
        }

        // Return draw if weapons are equals
        if (o1.equals(o2)) {
            return 0;
        }

        // Return win if first weapon beat second weapon using rules
        if (getWiningRule(o1, o2) != null) {
            return 1;
        }

        // Return lose otherwise
        return -1;
    }
}
