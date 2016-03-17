package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.Comparator;
import java.util.List;

/**
 * Interface game rules. Main purpose is to compare if a weapon beat another.
 */
public interface IRules extends Comparator<Weapon> {

    /**
     * Get the available weapons of a game rules.
     *
     * @return the list of available weapons
     */
    public abstract List<Weapon> getAvailableWeapons();

    /**
     * Get the winning rule for the first weapon1 vs the second weapon.
     *
     * @param weapon1 the first weapon
     * @param weapon2 the second weapon
     * @return the winning rule, null if no rules matched
     */
    public Rule getWiningRule(Weapon weapon1, Weapon weapon2);

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
    public int compare(Weapon o1, Weapon o2);
}
