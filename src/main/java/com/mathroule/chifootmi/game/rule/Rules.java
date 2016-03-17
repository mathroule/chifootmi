package com.mathroule.chifootmi.game.rule;

import com.mathroule.chifootmi.weapon.Weapon;

import java.util.Comparator;

/**
 * Abstract game rules. Main purpose is to compare if a weapon is better than another.
 */
public interface Rules extends Comparator<Weapon> {
    // TODO use decorator
}
