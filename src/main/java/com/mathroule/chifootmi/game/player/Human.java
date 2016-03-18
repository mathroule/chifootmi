package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;

/**
 * Abstract class for an human player.
 */
public abstract class Human extends Player {

    /**
     * Human player constructor using name.
     *
     * @param name the player name
     */
    public Human(String name) {
        super(name);
    }

    /**
     * Pick a weapon from a list available of weapons.
     *
     * @param weapons the list available of weapons
     * @return the picked weapon
     */
    @Override
    public abstract Weapon pickWeapon(List<Weapon> weapons);
}
