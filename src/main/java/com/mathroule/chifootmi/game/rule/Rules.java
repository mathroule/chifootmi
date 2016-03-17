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

    public Rule getWiningRule(Weapon weapon1, Weapon weapon2) {
        for (Rule rule : this) {
            if (rule.isRespected(weapon1, weapon2)) {
                return rule;
            }
        }
        return null;
    }

    @Override
    public int compare(Weapon o1, Weapon o2) {
        // Check if weapons are not null
        if (o1 == null || o2 == null) {
            throw new NullPointerException();
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
